import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void testPercentUntilRecharge50Percent(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(0.5, mav1.percentUntilRecharge(), 0.01);
    }

    @Test
    public void testPercentUntilRecharge100Percent(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.125),
                new Battery(10, 10), 20);
        assertEquals(1.0, mav1.percentUntilRecharge(), 0.01);
    }

    @Test
    public void testReachesDest50Percent(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(false, mav1.doesReachDest());
    }

    @Test public void testReachesDest100Percent(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.125),
                new Battery(10, 10), 20);
        assertEquals(true, mav1.doesReachDest());
    }

    @Test
    public void testThisObjectGoesFurther(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.125),
                new Battery(20, 10), 20);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.125),
                new Battery(10, 20), 20);
        assertEquals("bumblebee", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void testThatObjectGoesFurther(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.125),
                new Battery(10, 5), 20);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.125),
                new Battery(20, 20), 20);
        assertEquals("firefly", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void theObjectsTie(){
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.125),
                new Battery(20, 20), 20);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.125),
                new Battery(20, 20), 20);
        assertEquals("bumblebee&firefly", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void testFlyForShort(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        mav.flyFor(1);
        assertEquals(9, mav.battery.amountLeft, 0.01);
    }

    @Test
    public void testFlyForLong(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 2.5),
                new Battery(10, 10), 20);
        mav.flyFor(1);
        assertEquals(0, mav.battery.amountLeft, 0.01);
    }


    /*
        LAB 2 TESTS
     */

    @Test
    public void testOverThreshold() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(30, 25), 20);
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(mav1);
        vehicles.add(mav2);
        Competition comp = new Competition(vehicles);
        comp.simulateAll(1);
        assertEquals(2, comp.overThreshold(0.0));
    }

    @Test
    public void testSimulateAll(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        Competition c = new Competition(List.of(mav));
        c.simulateAll(1);
        MAV mavAfter = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 9), 19);
        Competition cAfter = new Competition(List.of(mavAfter));
        assertEquals(cAfter, c);
    }

    @Test
    public void testAllLose(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        Competition c = new Competition(List.of(mav, mav2));
        c.simulateAll(1);
        assertEquals(c.potentialWinners(), List.of());
    }

    @Test
    public void testAllWin(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 5);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 5);
        Competition c = new Competition(List.of(mav, mav2));
        c.simulateAll(25);
        assertEquals(c.potentialWinners(), List.of("bumblebee", "firefly"));
    }

    @Test
    public void testOneWins(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 5);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 50);
        Competition c = new Competition(List.of(mav, mav2));
        c.simulateAll(25);
        assertEquals(c.potentialWinners(), List.of("bumblebee"));
    }

    @Test
    public void testOneWinsRover(){
        Rover rover = new Rover(1,
                List.of(
                        new Wheel(1, 10),
                        new Wheel(1, 10)
                ),
                new Battery(1000, 1000),
                List.of(1.0, 1.0)
        );
        Rover rover2 = new Rover(2,
                List.of(
                        new Wheel(1, 1),
                        new Wheel(1, 1)
                ),
                new Battery(10, 10),
                List.of(10.0, 10.0)
        );
        Competition c = new Competition(List.of(rover, rover2));
        c.simulateAll(25);
        assertEquals(c.potentialWinners(), List.of("Rover#1"));
    }

    @Test
    public void firstGoesFurthest(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 5);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(1000, 1000), 5);
        Competition c = new Competition(List.of(mav, mav2));
        assertEquals(c.whoGoesFurthest(), "firefly");
    }

    @Test
    public void goesFurthestTie(){
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 5);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 1, 0.25),
                new Battery(100, 100), 5);
        Competition c = new Competition(List.of(mav, mav2));
        assertEquals(c.whoGoesFurthest(), "firefly");
    }

    @Test
    public void nobodyGoesFurthest(){
        Competition c = new Competition(List.of());
        assertEquals(c.whoGoesFurthest(), "Nobody");
    }

}
