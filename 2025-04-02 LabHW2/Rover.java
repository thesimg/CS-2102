import java.util.List;

public class Rover implements Vehicle {

    int serialNum;
    List<Wheel> wheels;
    Battery battery;
    List<Double> wayPoints;

    Rover(int serialNum, List<Wheel> wheels, Battery battery, List<Double> wayPoints) {
        this.serialNum = serialNum;
        this.wheels = wheels;
        this.battery = battery;
        this.wayPoints = wayPoints;
    }

    /**
     * @returns a string identifying the rover in the format "Rover#%d" where %d is the rover's serial number
     */
    @Override
    public String identifier() {
        return "";
    }

    /**
     * @return the ratio (between 0.0 and 1.0) of meters travelable on the current charge to meters until its destination. If the vehicle can go past its destination, this should return 1.0
     */
    @Override
    public double percentUntilRecharge() {
        return 0;
    }

    /**
     * @return if the vehicle can reach its destination with its current charge
     */
    @Override
    public boolean doesReachDest() {
        return false;
    }

    /**
     * @return the distance in meters the vehicle can travel with a full battery
     */
    @Override
    public double metersOnFull() {
        return 0;
    }

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed given
     *
     * @param seconds the number of seconds
     */
    @Override
    public void runFor(double seconds) {

    }
}
