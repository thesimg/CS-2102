public class Customer implements Comparable<Customer> {

    protected String name;
    protected int cash;
    protected int unitsOrdering;

    protected boolean hasBeenHelped = false;

    public Customer(String name, int cash, int unitsOrdering) {
        this.name = name;
        this.cash = cash;
        this.unitsOrdering = unitsOrdering;
    }

    public void help(int pricePerUnit){
        hasBeenHelped = true;
        cash -= pricePerUnit * unitsOrdering;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Customer o) {
        if (this.cash < o.cash)
            return -1;
        else if (this.cash > o.cash)
            return 1;
        else
        return 0;
    }

    @Override
    public String toString() {
        return cash ;
    }
}
