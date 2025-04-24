public class Customer {

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
}
