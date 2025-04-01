public class Dillo implements Cageable {

    public int  id;
    public double length;
    public boolean rolledUp;

    public Dillo(int id, double length, boolean rolledUp) {
        this.id = id;
        this.length = length;
        this.rolledUp = rolledUp;
    }

    /**
     * Computes whether this animal can fit in a cage
     *
     * @param exhibitSideLength with a square side length
     * @return true if the animal fits
     */
    @Override
    public boolean fitInExhibit(int exhibitSideLength) {
        if (rolledUp) {
            return length < exhibitSideLength/2;
        } else {
            return length < exhibitSideLength;
        }
    }

    /**
     * @return the name of the animal
     */
    @Override
    public String name() {
        return String.format("Dillo %d", id);
    }
}
