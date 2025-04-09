import java.util.ArrayList;
import java.util.List;

/**
 * a hovercraft class
 * @author graham simons
 */
public class Hovercraft implements Vehicle {

    String name;
    Skirt skirt;
    Battery battery;
    double distanceToDestination;

    /**
     * a hovercraft constructor
     * @param name of the hovercraft
     * @param skirt a skirt object
     * @param battery a battery object
     * @param distanceToDestination the total distance to the destination (meters)
     */
    Hovercraft(String name, Skirt skirt, Battery battery, double distanceToDestination) {
        this.name = name;
        this.skirt = skirt;
        this.battery = battery;
        this.distanceToDestination = distanceToDestination;
    }

    /**
     * @returns a string identifying the hovercraft with its name
     */
    @Override
    public String identifier() {
        return this.name;
    }

    /**
     * @return the distance travelable on the current battery charge
     */
    public double metersTravelableOnBattery(){
        double batteryTimeLeft = this.battery.timeToEmpty(this.skirt.totalCurrentDraw());
        return batteryTimeLeft * this.skirt.speed();
    }

    /**
     * @param seconds the number of seconds to attempt to travel for
     * @return the distance travelable in the given time
     */
    public double metersTravelableInSeconds(double seconds){
        return seconds * this.skirt.speed();
    }

    /**
     * @return the ratio (between 0.0 and 1.0) of meters travelable on the current charge to meters until its destination. If the vehicle can go past its destination, this should return 1.0
     */
    @Override
    public double percentUntilRecharge() {
        double batteryTimeLeft = this.battery.timeToEmpty(this.skirt.totalCurrentDraw());
        double metersTravelable = this.skirt.speed() * batteryTimeLeft;

        if(this.distanceToDestination > 0) {
            return metersTravelable / this.distanceToDestination;
        } else {
            return 1.0;
        }
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
        return battery.capacity * this.skirt.speed();
    }

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed given
     *
     * @param seconds the number of seconds
     */
    @Override
    public void runFor(double seconds) {
        double totalCurrentDraw = this.skirt.totalCurrentDraw();
        double batteryCapacityUsed = this.battery.amountDischargedIn(totalCurrentDraw, seconds);

        this.battery.dischargeBy((this.battery.amountLeft - batteryCapacityUsed >= 0) ? batteryCapacityUsed : this.battery.amountLeft);


        double distanceTravelled = this.skirt.speed() * metersTravelableOnBattery();

        this.distanceToDestination = (this.distanceToDestination - distanceTravelled >= 0) ? this.distanceToDestination - distanceTravelled : 0;
    }


    /**
     * @return the identifier of the hovercraft
     */
    @Override
    public String toString(){
        return this.identifier();
    }

    /**
     * @param o object to compare
     * @return checks all attributes to ensure equality
     */
    @Override
    public boolean equals(Object o){
        if (o instanceof Hovercraft hovercraft) {
            return this.name.equals(hovercraft.name) && this.skirt.equals(hovercraft.skirt) && this.battery.equals(hovercraft.battery) && Math.abs(this.distanceToDestination - hovercraft.distanceToDestination) < 0.01;
        }
        return false;
    }
}
