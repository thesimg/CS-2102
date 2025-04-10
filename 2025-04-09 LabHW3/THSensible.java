public interface THSensible {
    /**
     * @param data to be split and stored
     */
    void collect(String data);

    /**
     * @param lo the low temp
     * @param hi the high temp
     * @return the count of temps outside the range
     */
    int tempsOutsideRange(double lo, double hi);

    /**
     * @return the lowest humidity % (or 0 if none)
     */
    double minHumidity();

    /**
     * @return the largest humidity % (or 0 if none)
     */
    double maxHumidity();

    /**
     * @return the avg humidity % (or 0 if none)
     */
    double avgHumidity();
}
