package Lecture11Starter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Examples {

    /* Learning Objectives
     * You are given a class, ClubRoster, which takes in club attendance strings
     *   from a Office of Student Life online feed.
     * You want to perform some queries as specified in an interface ClubManageable
     * Given is an implementation in the style of HW1/HW2 where:
     * - Data is stored in fields upon construction
     * - Queries do data processing to produce an answer
     * But can we have some runtime customizability and reduce redundant data
     *   processing by treating the data as an assembly line?
     *
     * - Lecture 11: Code Planning with Cleaning and Parsing
     *   - Cleaning is when we mutate to remove data we do not need
     *   - Parsing is when we transform the data from one form to another
     *      ideally to make particular queries easier
     *   Activity: Rewrite ClubRosters to have clean() parse() and sort() helper
     *             methods to make the ClubManagable queries easier
     *             Use the ClubRoster helper class provided
     * - Lecture 12: Batch vs Real-time Processing
     *   - We can treat objects as stateful-machines for data processing
     *   - Batch Processing is when we do our data processing as
     *       answers are queried.
     *       Useful for when data added often, but answers are queried rarely
     *   - Real-Time Processing is when we do our data processing as
     *       data is added. Useful for when data is added slowly, but
     *       answers are queried frequently.
     *   Activity:
     *     - Rewrite ClubRoster two ways: Batch Processing and Real-Time Processing
     *     - Test the timing properties with System.nanoTime()
     * - Lecture 13: Template Method Pattern
     *  - We can use inheritance to take our assembly-line like code plan
     *    and turn it into helper methods we can call and override from
     *    subclasses
     *  - Activity: Refactor common code between ClubRosterBP and ClubRosterRTP
     *      into a common abstract superclass
     *      The subclasses should only have the code they need to do their specific
     *      part of the algorithm. They should use the super keyword to call
     *      the template when they need to.
     *  - Activity: Extend one of BP or RTP to do additional cleaning or parsing
     *      by overriding the template method and using super.
     */
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
    public void testClub(){
        ClubManagable clubRoster = new ClubRosters(rawData);
        assertEquals("ACM",clubRoster.mostPopular());
        assertEquals(5, clubRoster.uniqueClubs());
        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
                clubRoster.sortedEmails("ACM"));
    }

//    @Test
//    public void testClubBP(){
//        ClubManagable clubRoster = new ClubRosters(rawData);
//        clubRoster.intake(rawData);
//        assertEquals("ACM",clubRoster.mostPopular());
//        assertEquals(5, clubRoster.uniqueClubs());
//        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
//                     clubRoster.sortedEmails("ACM"));
//    }

//    @Test
//    public void testClubRTP(){
//        ClubManagable clubRosters = new ClubRostersRTP();
//        clubRosters.intake(rawData);
//        assertEquals("ACM",clubRosters.mostPopular());
//        assertEquals(5, clubRosters.uniqueClubs());
//        assertEquals(List.of("b@wpi.edu", "d@wpi.edu", "j@wpi.edu"),
//                clubRosters.sortedEmails("ACM"));
//    }
//
//    @Test
//    public void testClubTimingIntake(){
//        ClubManagable clubRostersRTP = new ClubRostersRTP();
//        ClubManagable clubRostersBP = new ClubRosters();
//
//        long preRTPIntake = System.nanoTime();
//        clubRostersRTP.intake(rawData);
//        long postRTPIntake = System.nanoTime();
//
//        long preBPIntake = System.nanoTime();
//        clubRostersBP.intake(rawData);
//        long postBPIntake = System.nanoTime();
//
//        assertTrue((postRTPIntake - preRTPIntake) > (postBPIntake - preBPIntake));
//    }
//
//    @Test
//    public void testClubTimingOutput(){
//        ClubManagable clubRostersRTP = new ClubRostersRTP();
//        ClubManagable clubRostersBP = new ClubRosters();
//        clubRostersRTP.intake(rawData);
//        clubRostersBP.intake(rawData);
//
//        long preRTPAnswer = System.nanoTime();
//        clubRostersRTP.mostPopular();
//        long postRTPAnswer = System.nanoTime();
//
//        long preBPAnswer = System.nanoTime();
//        clubRostersBP.mostPopular();
//        long postBPAnswer = System.nanoTime();
//
//        assertTrue((postRTPAnswer - preRTPAnswer) < (postBPAnswer - preBPAnswer));
//    }

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
