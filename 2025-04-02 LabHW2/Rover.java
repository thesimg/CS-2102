import java.util.ArrayList;
import java.util.List;

/**
 * a rover class
 * @author graham simons
 */
public class Rover implements Vehicle {

    int serialNum;
    List<Wheel> wheels;
    Battery battery;
    List<Double> wayPoints;

    /**
     * a rover object
     *
     * @param serialNum the serial number of the rover
     * @param wheels    a list of wheel objects
     * @param battery   a battery object
     * @param wayPoints a list of distances to the next waypoint
     */
    Rover(int serialNum, List<Wheel> wheels, Battery battery, List<Double> wayPoints) {
        this.serialNum = serialNum;
        this.wheels = new ArrayList<>(wheels);
        this.battery = battery;
        this.wayPoints = new ArrayList<>(wayPoints);
    }

    /**
     * @returns a string identifying the rover in the format "Rover#%d" where %d is the rover's serial number
     */
    @Override
    public String identifier() {
        return String.format("Rover#%d", serialNum);
    }

    public double totalCurrentDraw() {
        double currentDraw = 0;
        for (Wheel wheel : wheels) {
            currentDraw += wheel.totalCurrentDraw();
        }
        return currentDraw;
    }

    public double minSpeed() {
        double minSpeed = 0;
        for (Wheel wheel : wheels) {
            if (wheel.speed() > minSpeed) {
                minSpeed = wheel.speed();
            }
        }
        return minSpeed;
    }

    /**
     * @return the total cumulative distance between all waypoints
     */
    public double totalDistance() {
        double total = 0;
        for (double wayPoint : wayPoints) {
            total += wayPoint;
        }
        return total;
    }

    /**
     * @return the distance travelable on the current battery charge
     */
    public double metersTravelableOnBattery() {
        double batteryTimeLeft = this.battery.timeToEmpty(totalCurrentDraw());
        return batteryTimeLeft * minSpeed();
    }

    /**
     * @param seconds the number of seconds to attempt to travel for
     * @return the distance travelable in the given time
     */
    public double metersTravelableInSeconds(double seconds) {
        return seconds * minSpeed();
    }

    /**
     * @return the ratio (between 0.0 and 1.0) of meters travelable on the current charge to meters until its destination. If the vehicle can go past its destination, this should return 1.0
     */
    @Override
    public double percentUntilRecharge() {
        double percentage = 0;
        if (totalCurrentDraw() > 0) {
            percentage = metersTravelableOnBattery() / totalDistance();
        } else {
            percentage = 1.0;
        }
        return Math.abs(percentage) <= 1.0 ? percentage : 1.0;
    }

    /**
     * @return if the vehicle can reach its destination with its current charge
     */
    @Override
    public boolean doesReachDest() {
        return this.percentUntilRecharge() == 1.0;
    }

    /**
     * @return the distance in meters the vehicle can travel with a full battery
     */
    @Override
    public double metersOnFull() {
        return battery.capacity * minSpeed();
    }

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed given
     *
     * @param seconds the number of seconds
     */
    @Override
    public void runFor(double seconds) {
//        double totalCurrentDraw = this.totalCurrentDraw();
//        double batteryCapacityUsed = this.battery.amountDischargedIn(totalCurrentDraw, seconds);
//
//        this.battery.dischargeBy((this.battery.amountLeft - batteryCapacityUsed >= 0) ? batteryCapacityUsed : this.battery.amountLeft);

        double totalDistanceToTravel = metersTravelableInSeconds(seconds);

        while (totalDistanceToTravel > 0 && this.battery.amountLeft > 0 && !this.wayPoints.isEmpty()) {
//            if (totalDistanceToTravel > this.wayPoints.get(0)) {
                double distance = this.wayPoints.get(0);
                totalDistanceToTravel -= distance;

                // get the time traveled during this waypoint
                double timeToWaypoint = distance / minSpeed();

                double batteryDrain = this.battery.amountDischargedIn(this.totalCurrentDraw(), timeToWaypoint);
                this.battery.dischargeBy(batteryDrain);

                this.wayPoints.remove(0);
//            } else {
//                double distance = this.wayPoints.get(0);
//                totalDistanceToTravel -= distance;
//
//                // get the time traveled during this waypoint
//                double timeToWaypoint = distance / minSpeed();
//
//                double batteryDrain = this.battery.amountDischargedIn(this.totalCurrentDraw(), timeToWaypoint);
//                this.battery.dischargeBy(batteryDrain);
//
//                this.wayPoints.remove(0);
//            }
        }
    }

    /**
     * @return the identifier of the rover
     */
    @Override
    public String toString() {
        return this.identifier();
    }

    /**
     * @param o object to compare
     * @return checks all attributes to ensure equality
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rover rover) {
//            if (this.wayPoints.size() == rover.wayPoints.size()) {
//                for (int i = 0; i < this.wayPoints.size(); i++) {
//                    if (Math.abs(this.wayPoints.get(i) - rover.wayPoints.get(i)) > 1) {
//                        return false;
//                    }
//                }
//            } else {
//                return false;
//            }
            return this.serialNum == rover.serialNum && this.battery.equals(rover.battery) && this.wheels.equals(rover.wheels) && this.wayPoints.equals(rover.wayPoints);
        }
        return false;
    }

}
