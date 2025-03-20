import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    /*
        TRIP COSTS
    */
    @Test
    public void testBoatTourExpensesNoPeople(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500, boatTour.tripCosts(0, 0));
    }

    @Test
    public void testBoatTourExpenses100Adults(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500+100*7, boatTour.tripCosts(100, 0));
    }

    @Test
    public void testBoatTourExpenses1Adult(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500+7, boatTour.tripCosts(1, 0));
    }

    @Test
    public void testBoatTourExpenses1Kid(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500+5, boatTour.tripCosts(0, 1));
    }

    @Test
    public void testBoatTourExpenses100Kids(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500+100*5, boatTour.tripCosts(0, 100));
    }

    @Test
    public void testBoatTourExpenses100Adults100Kids(){
        BoatTour boatTour = new BoatTour();
        assertEquals(1500+100*7+100*5, boatTour.tripCosts(100, 100));
    }

    /*
    TOTAL COST
     */

    @Test
    public void testBoatTourGrossCostNoPeople(){
        BoatTour boatTour = new BoatTour();
        assertEquals(0, boatTour.tripGross(0, 0));
    }

    @Test
    public void testBoatTourGrossCost1Adult(){
        BoatTour boatTour = new BoatTour();
        assertEquals(60, boatTour.tripGross(1, 0));
    }

    @Test
    public void testBoatTourGrossCost1Kid(){
        BoatTour boatTour = new BoatTour();
        assertEquals(45, boatTour.tripGross(0, 1));
    }


    @Test
    public void testBoatTourGrossCost100Adults(){
        BoatTour boatTour = new BoatTour();
        assertEquals(100*60, boatTour.tripGross(100, 0));
    }

    @Test
    public void testBoatTourGrossCost100Kids(){
        BoatTour boatTour = new BoatTour();
        assertEquals(100*45, boatTour.tripGross(0, 100));
    }

    @Test
    public void testBoatTourGrossCost100Adults100Kids(){
        BoatTour boatTour = new BoatTour();
        assertEquals(100*60+100*45, boatTour.tripGross(100, 100));
    }

    /*
    NET PROFIT
     */

    @Test
    public void testBoatTourNetProfitNoPeople(){
        BoatTour boatTour = new BoatTour();
        assertEquals("trip profit: -$1500", boatTour.netProfit(0, 0));
    }

    @Test
    public void testBoatTourNetProfit1Adult(){
        BoatTour boatTour = new BoatTour();
        // -1500 + 60 - 7
        assertEquals("trip profit: -$1447", boatTour.netProfit(1, 0));
    }

    @Test
    public void testBoatTourNetProfit1Kid(){
        BoatTour boatTour = new BoatTour();
        // -1500 + 45 - 5
        assertEquals("trip profit: -$1460", boatTour.netProfit(0, 1));
    }

    @Test
    public void testBoatTourNetProfit100Adults(){
        BoatTour boatTour = new BoatTour();
        // -1500 + 60*100 - 7*100
        assertEquals("trip profit: $3800", boatTour.netProfit(100, 0));
    }

    @Test
    public void testBoatTourNetProfit100Kids(){
        BoatTour boatTour = new BoatTour();
        // -1500 + 45*100 - 5*100;
        assertEquals("trip profit: $2500", boatTour.netProfit(0, 100));
    }

    @Test
    public void testBoatTourNetProfit100Adults100Kids(){
        BoatTour boatTour = new BoatTour();
        // -1500 + 45*100 - 5*100 + 60*100 - 7*100
        assertEquals("trip profit: $7800", boatTour.netProfit(100, 100));
    }


    /*
    HOUSE CALCULATOR
     */

    @Test
    public void testHouseCalculatorDownPaymentEqualsPurchasePrice(){
        HouseCalculator houseCalculator = new HouseCalculator();
        // 2500 + 1000 + 0.08 * 0 * 30
        assertEquals(3500, houseCalculator.totalCost(1000, 1000), 0.0001);
    }

    @Test
    public void testHouseCalculatorDownPaymentLessThanPurchasePrice(){
        HouseCalculator houseCalculator = new HouseCalculator();
        // 2500 + 1000 + 0.08 * 500 * 30
        assertEquals(4700, houseCalculator.totalCost(1000, 500), 0.0001);
    }

    @Test
    public void testHouseCalculatorDownPaymentZero(){
        HouseCalculator houseCalculator = new HouseCalculator();
        // 2500 + 1000 + 0.08 * 1000 * 30
        assertEquals(5900, houseCalculator.totalCost(1000, 0), 0.0001);
    }


}
