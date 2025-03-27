public class MAV {
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
        return 0;
    }

    /**
     * @return if the vehicle can reach its destination with its current charge
     */
    public boolean doesReachDest(){
        return false;
    }

    /**
     * @param otherMAV takes another MAV to compare
     * @return the name of whichever vehicle can go further on its full battery capacity. if there is a tie (within 0.01 meters), it produces the names in this format: “thisVehiclesName&paramVehiclesName”
     */
    public String whichGoesFurther(MAV otherMAV){
        return "";
    }

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed of its propellers,
     * @param seconds
     */
    public void flyFor(double seconds){

    }
}
