/**
 * a Propellers object, used in a MAV
 * @author graham simons
 */
public class Propellers {
    /**
     * a propellers object
     * @param count is the number of propellers on the unit
     * @param speed os how fast the unit can go (meters per second)
     * @param currentDrawEach is how much power each propeller consumes (mA per propeller)
     */
    int count;
    double speed;
    double currentDrawEach;

    public Propellers(int count, double speed, double currentDrawEach){
        this.count = count;
        this.speed = speed;
        this.currentDrawEach = currentDrawEach;
    }

    /**
     * @return total current draw of MAV
     */
    protected double totalCurrentDraw(){
        return this.currentDrawEach * this.count;
    }

    /**
     * @param time
     * @return total distance travelable (meters) in a given amount of time
     */
    protected double distanceTravelable(double time){
        return speed * time;
    }

    /**
     * @return the speed, count, and current draw of the propellers
     */
    @Override
    public String toString() {
        return this.speed + " " + this.count + " " + this.currentDrawEach;
    }

    /**
     * @param o object to compare
     * @return checks all attributes to ensure equality
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Propellers propellers) {
            return this.count == propellers.count && Math.abs(this.speed - propellers.speed) < 0.02 && Math.abs(this.currentDrawEach - propellers.currentDrawEach) < 0.02;
        }
        return false;
    }
}
