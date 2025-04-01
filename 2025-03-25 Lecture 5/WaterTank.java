/** A passive "Hot Water Heater" tank*/
public class WaterTank {
    /** capacity in Liters */
    public double capacity;

    /** temperature in Celsius */
    public double temperature;

    /** percent full of hot water (0.0% - 100.0%) */
    public double percentFull;

    /**
     * Construct a water tank object
     * @param capacity the capacity of the tank to hold hot water in Liters (L)
     * @param temperature the temperature of the hot water in Celsius (C)
     * @param percentFull the percentage of the capacity currently filled with hot water.
     */
    public WaterTank(double capacity, double temperature, double percentFull){
        this.capacity = capacity;
        this.temperature = temperature;
        this.percentFull = percentFull;
    }

    /**
     *
     * @returns the  current amount of water in the tank in Liters
     */
    public double currentAmount(){
        return this.capacity * (this.percentFull / 100.0);
    }

    /**
     *
     * @param targetTemp in celsius
     * @return the delta C or - if targetTemp is less than current temp
     */
    protected double deltaC(double targetTemp){
        return this.temperature > targetTemp ? 0 : this.temperature - targetTemp;
    }

    public boolean equals(Object o){
        if(o instanceof WaterTank other){
            return Math.abs(this.temperature - other.temperature) < 0.01 &&
                    Math.abs(this.percentFull - other.percentFull) < 0.01 &&
                    Math.abs(this.capacity - other.capacity) < 0.01;
        } else
            return false;
    }
}
