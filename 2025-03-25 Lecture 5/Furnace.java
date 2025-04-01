/** A water boiler that consumes some amount of fuel */
public class Furnace {
    /** The rate at which this furnace consumes fuel while running (kilogram of fuel per second) */
    public double fuelConsumption;

    /**
     * Instantiates the furnace to a particular thoroughput
     * @param fuelConsumption (kg fuel/s)
     */
    public Furnace(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

    protected double howLong(double kgToBurn){
        return kgToBurn / this.fuelConsumption;
    }

    public boolean equals(Object o){
        if(o instanceof Furnace other){
            return Math.abs(this.fuelConsumption - other.fuelConsumption) < 0.01;
        } else
            return false;
    }
}
