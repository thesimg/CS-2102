import java.util.ArrayList;
import java.util.List;

/**
 * a competition class
 * @author graham simons
 */
public class Competition {
    List<Vehicle> vehicles;

    Competition(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @param percent is a percentage between 0.0 and 1.0
     * @return how many (count) vehicles have a percentUntilRecharge() greater than that percentage
     */
    public int overThreshold(double percent) {
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            count += vehicle.percentUntilRecharge() > percent ? 1 : 0;
        }
        return count;
    }

    /**
     *
     * @return the identifier()s of the vehicles (in the same order as they appear in the List field) that can reach their destination
     */
    List<String> potentialWinners() {
        List<String> winners = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if(vehicle.doesReachDest()){
                winners.add(vehicle.identifier());
//                System.out.println(vehicle.identi/fier());
            }
        }
//        System.out.println(winners);
        return winners;
    }

    /**
     *
     * @return the intetify of the vehicle with the largest metersOnFull(). if there is a tie (within 0.01 meters), the vehicle that appears later in the vehicles List field should win. if there are no vehicles, "Nobody" should be produced
     */
    public String whoGoesFurthest() {
        int largest = 0;
        if (!vehicles.isEmpty()) {
            for(Vehicle vehicle : vehicles) {
                if(vehicle.metersOnFull() >= largest){
                    largest = vehicles.indexOf(vehicle);
                }
            }
            return vehicles.get(largest).identifier();
        } else {
            return "Nobody";
        }
    }

    /**
     * mutates the state of the vehicles to "travel" for the provided number of seconds at the speed given
     * @param seconds the number of seconds
     */
    public void simulateAll(double seconds) {
        for (Vehicle vehicle : vehicles) {
            vehicle.runFor(seconds);
        }
    }

    /**
     * @return all vehicles in a string
     */
    @Override
    public String toString() {
        String returnString = "";
        for (Vehicle vehicle : vehicles) {
            returnString += vehicle.toString() + " ";
        }
        return returnString; // .substring(0, vehicles.toString().length() - 1)
    }

    /**
     * @param o object to compare
     * @return if the vehicles are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Competition competition) {
            return this.vehicles.equals(competition.vehicles);
        }
        return false;
    }
}
