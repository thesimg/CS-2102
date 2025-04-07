import java.util.List;

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
        return 0;
    }

    /**
     *
     * @return the identifier()s of the vehicles (in the same order as they appear in the List field) that can reach their destination
     */
    List<String> potentialWinners() {
        return null;
    }

    /**
     *
     * @return the intetify of the vehicle with the largest metersOnFull(). if there is a tie (within 0.01 meters), the vehicle that appears later in the vehicles List field should win. if there are no vehicles, "Nobody" should be produced
     */
    public String whoGoesFurthest() {
        // first check if tehre are vehicles
        // then

        return null;
    }

    /**
     * mutates the state of the vehicles to "travel" for the provided number of seconds at the speed given
     * @param seconds the number of seconds
     */
    public void simulateAll(double seconds) {

    }
}
