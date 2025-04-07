package Lecture13Starter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Examples {

    List<String> rawData =
            List.of("a@wpi.edu", "Bionics",
                    "b@wpi.edu", "ACM",
                    "c@wpi.edu", "WICS",
                    "d@wpi.edu", "ACM",
                    "e@wpi.edu", "Pep Band",
                    "m@tufts.edu", "Pep Band",
                    "g@wpi.edu", "Console Game Club",
                    "h@wpi.edu", "WICS",
                    "y@clemson.edu", "ACM",
                    "j@wpi.edu", "ACM");

    @Test
    public void testClubBP(){
        ClubManagable clubRoster = new ClubRostersBP();
        clubRoster.intake(rawData);
        assertEquals("ACM",clubRoster.mostPopular());
        assertEquals(5, clubRoster.uniqueClubs());
        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
                     clubRoster.sortedEmails("ACM"));
    }

    @Test
    public void testClubRTP(){
        ClubManagable clubRosters = new ClubRostersRTP();
        clubRosters.intake(rawData);
        assertEquals("ACM",clubRosters.mostPopular());
        assertEquals(5, clubRosters.uniqueClubs());
        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
                clubRosters.sortedEmails("ACM"));
    }

    @Test
    public void testClubTimingIntake(){
        ClubManagable clubRostersRTP = new ClubRostersRTP();
        ClubManagable clubRostersBP = new ClubRostersBP();

        long preRTPIntake = System.nanoTime();
        clubRostersRTP.intake(rawData);
        long postRTPIntake = System.nanoTime();

        long preBPIntake = System.nanoTime();
        clubRostersBP.intake(rawData);
        long postBPIntake = System.nanoTime();

        assertTrue((postRTPIntake - preRTPIntake) > (postBPIntake - preBPIntake));
    }

    @Test
    public void testClubTimingOutput(){
        ClubManagable clubRostersRTP = new ClubRostersRTP();
        ClubManagable clubRostersBP = new ClubRostersBP();
        clubRostersRTP.intake(rawData);
        clubRostersBP.intake(rawData);

        long preRTPAnswer = System.nanoTime();
        clubRostersRTP.mostPopular();
        long postRTPAnswer = System.nanoTime();

        long preBPAnswer = System.nanoTime();
        clubRostersBP.mostPopular();
        long postBPAnswer = System.nanoTime();

        assertTrue((postRTPAnswer - preRTPAnswer) < (postBPAnswer - preBPAnswer));
    }

//    @Test
//    public void testClubCountBPCSClubs(){
//        ClubManagable clubRoster = new CSClubRostersBP(List.of("ACM", "WICS"));
//        clubRoster.intake(rawData);
//        assertEquals("ACM",clubRoster.mostPopular());
//        assertEquals(2, clubRoster.uniqueClubs());
//        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
//                clubRoster.sortedEmails("ACM"));
//    }
}
