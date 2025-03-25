/**
 * a class containing methods to calculate the total cost of a house
 * @author graham simons
 */
public class HouseCalculator {
    /**
     * a helper method to calculate simple interest on a house
     * @param purchasePrice a positive purchase price
     * @param downPaymentPrice a positive down payment price, less than or equal to the purchase price
     * @return a double containing the calculated simple interest of the house
     */
    protected double simpleInterest(double purchasePrice, double downPaymentPrice){
        return 0.08 * (purchasePrice - downPaymentPrice) * 30;
    }

    /**
     * a method to calculate the total cost of a house
     * @param purchasePrice a positive purchase price
     * @param downPaymentPrice a positive down payment price, less than or equal to the purchase price
     * @return a double containing the total cost of the house purchase
     */
    public double totalCost(double purchasePrice, double downPaymentPrice){
        double bankFees = 2500;
        double simpleInterest = simpleInterest(purchasePrice, downPaymentPrice);

        return purchasePrice + simpleInterest + bankFees;
    }
}
