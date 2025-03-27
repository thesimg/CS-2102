public class Battery {
    /**
     * a battery object
     * @param capacity (when full) in milliAmpere-seconds (mAs)
     * @param amountLeft is the current power providable by a battery to use in mAs
     */
    double capacity;
    double amountLeft;

    public Battery(double capacity, double amountLeft){
        this.capacity = capacity;
        this.amountLeft = amountLeft;
    }
}
