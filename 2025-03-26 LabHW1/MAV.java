/**
 * a Micro Air Vehicle object, which has n propellers and a battery
 * @author graham simons
 */
public class MAV {
    /**
     * a MAV object
     * @param name the name of the MAV
     * @param propellers is the Propellers object for the MAV
     * @param battery is the Battery object for the MAV
     * @param metersToDest the distance to the destination in meters
     */
    String name;
    Propellers propellers;
    Battery battery;
    double metersToDest;

    public MAV(String name, Propellers propellers, Battery battery, double metersToDest){
        this.name = name;
        this.propellers = propellers;
        this.battery = battery;
        this.metersToDest = metersToDest;
    }

    /**
     * @return the ratio (between 0.0 and 1.0) of meters travelable on the current charge to meters until its destination. If the vehicle can go past its destination, this should return 1.0
     */
    public double percentUntilRecharge(){
        double currentDraw = this.propellers.totalCurrentDraw();

        double batteryTimeLeft = this.battery.timeToEmpty(currentDraw);
        double metersTravelable = propellers.distanceTravelable(batteryTimeLeft);

        return metersTravelable / metersToDest;
    }

    /**
     * @return if the vehicle can reach its destination with its current charge
     */
    public boolean doesReachDest(){
        return this.percentUntilRecharge() == 1.0;
    }

    /**
     * @param otherMAV takes another MAV to compare
     * @return the name of whichever vehicle can go further on its full battery capacity. if there is a tie (within 0.01 meters), it produces the names in this format: “thisVehiclesName&paramVehiclesName”
     */
    public String whichGoesFurther(MAV otherMAV){
        double thisMaxTimeToEmpty = this.battery.maxTimeToEmpty(this.propellers.totalCurrentDraw());
        double thisMaxDistanceTravelable = this.propellers.distanceTravelable(thisMaxTimeToEmpty);

        double otherMaxTimeToEmpty = otherMAV.battery.maxTimeToEmpty(otherMAV.propellers.totalCurrentDraw());
        double otherMaxDistanceTravelable = otherMAV.propellers.distanceTravelable(otherMaxTimeToEmpty);


        double difference = thisMaxDistanceTravelable - otherMaxDistanceTravelable;

        if (Math.abs(difference) <= 0.01){
            return this.name + "&" + otherMAV.name;
        } else if (difference < 0){ // other was larger
            return otherMAV.name;
        } else {
            return this.name;
        }
    }

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed of its propellers,
     * @param seconds
     */
    public void flyFor(double seconds){
        double totalCurrentDraw = this.propellers.totalCurrentDraw();
        double batteryCapacityUsed = this.battery.amountDischargedIn(totalCurrentDraw, seconds);

        this.battery.dischargeBy((this.battery.amountLeft - batteryCapacityUsed >= 0) ? batteryCapacityUsed : this.battery.amountLeft);


        double distanceTravelled = propellers.distanceTravelable(seconds);

        this.metersToDest = (this.metersToDest - distanceTravelled >= 0) ? this.metersToDest - distanceTravelled : 0;

    }
}
