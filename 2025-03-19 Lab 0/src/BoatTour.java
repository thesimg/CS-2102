/**
 * a class to calculate the trip costs, gross profit, and net profit of a boat tour
 * @author graham simons
 */
public class BoatTour {
    /**
     * calculates the total trip costs for running a boat trip
     * @param numAdults a positive whole number of adults on the trip
     * @param numKids a positive whole number of kids on the trip
     * @return an int representing the base boat costs and the cost per adult and kid, added together
     */
    public int tripCosts(int numAdults, int numKids){
        int boatCost = 1500;
        int adultSuppliesCost = 7;
        int kidsSuppliesCost = 5;

        return boatCost + (numAdults * adultSuppliesCost) + (numKids * kidsSuppliesCost);
    }

    /**
     * returns the gross profit of a boat tour
     * @param numAdults a positive whole number for the number of adults on the trip
     * @param numKids a positive whole number of the kids on the trip
     * @return an int representing the gross profit from a trip
     */
    public int tripGross(int numAdults, int numKids){
        int adultTicketCost = 60;
        int kidsTicketCost = 45;

        return (numAdults * adultTicketCost) + (numKids * kidsTicketCost);
    }

    /**
     * returns the net profit of a boat tour
     * @param numAdults a positive whole number for the number of adults on the trip
     * @param numKids a positive whole number of the kids on the trip
     * @return a string containing the net trip profit, in the format "trip profit: $1000" or "trip profit: -$1000"
     */
    public String netProfit(int numAdults, int numKids){
        int net = (tripGross(numAdults, numKids) - tripCosts(numAdults, numKids));
        if(net < 0){
            return "trip profit: -$" + Math.abs(net);
        } else {
            return "trip profit: $" + net;
        }
    }
}
