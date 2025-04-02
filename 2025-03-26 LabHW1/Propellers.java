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

}
