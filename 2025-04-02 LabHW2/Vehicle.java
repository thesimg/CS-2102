public interface Vehicle {
    /**
     *
     * @returns a string identifying the vehicle by its specific logic
     */
    String identifier();

    /**
     * @return the ratio (between 0.0 and 1.0) of meters travelable on the current charge to meters until its destination. If the vehicle can go past its destination, this should return 1.0
     */
    double percentUntilRecharge();

    /**
     * @return if the vehicle can reach its destination with its current charge
     */
    boolean doesReachDest();

    /**
     * @return the distance in meters the vehicle can travel with a full battery
     */
    double metersOnFull();

    /**
     * mutates the state of the vehicle to "travel" for the provided number of seconds at the speed given
     * @param seconds the number of seconds
     */
    void runFor(double seconds);
}
