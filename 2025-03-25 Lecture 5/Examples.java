import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void testSecondsUntil60DegreesC(){
        // propane: 11900 C L / kg
        // Pick nice numbers to make the math easy for a simple test
        Furnace furnace = new Furnace(10.0);
        WaterTank waterTank = new WaterTank(119000,50,50.0);
        FuelTank fuelTank = new FuelTank(10000,11900);
        HeatingSystem heatingSystem = new HeatingSystem(furnace,waterTank,fuelTank);
        assertEquals(5.0, heatingSystem.secondsUntil60Degrees(),0.01);
    }

    @Test
    public void testRunFor5Seconds(){
        // propane: 11900 C L / kg
        // Pick nice numbers to make the math easy for a simple test
        Furnace furnace = new Furnace(10.0);
        WaterTank waterTank = new WaterTank(119000,50,50.0);
        FuelTank fuelTank = new FuelTank(10000,11900);
        HeatingSystem heatingSystem = new HeatingSystem(furnace,waterTank,fuelTank);
        heatingSystem.runFor(5);
        assertEquals(60.0, waterTank.temperature,0.01);
        assertEquals(9950.0,fuelTank.amount,0.01);
    }
}
