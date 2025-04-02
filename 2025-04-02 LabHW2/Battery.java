/**
 * a Battery object, used in a MAV
 * @author graham simons
 */
public class Battery {
    /**
     * a battery object
     * @param capacity (when full) in milliAmpere-seconds (mAs)
     * @param amountLeft is the current power providable by a battery to use in mAs
     */
    double capacity;
    double amountLeft;

    public Battery(double capacity, double amountLeft){
        this.capacity = capacity;
        this.amountLeft = amountLeft;
    }

    /**
     * @param currentDraw takes in the total current draw of the MAV's propellers
     * @return the time that the MAV can run based on the battery's amount left
     */
    protected double timeToEmpty(double currentDraw){
        return this.amountLeft / currentDraw;
    }

    /**
     * @param currentDraw takes in the total current draw of the MAV's propellers
     * @return the max amount of time that the MAV can fly based on the battery's fully charged capacity
     */
    protected double maxTimeToEmpty(double currentDraw){
        return this.capacity / currentDraw;
    }

    /**
     * @param currentDraw the total current draw of the MAV (mA)
     * @param time the total time the MAV is being run for
     * @return the battery amount discharged in the given time
     */
    protected double amountDischargedIn(double currentDraw, double time){
        return currentDraw * time;
    }

    /**
     * @param amount decreases the battery's current power by amount (mAs)
     */
    protected void dischargeBy(double amount){
        this.amountLeft -= amount;
    }
}
