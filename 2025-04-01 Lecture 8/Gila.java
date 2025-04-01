public class Gila implements Cageable{
    public String name;
    public int bodyLength;
    public int tailLength;

    public Gila(String name, int bodyLength, int tailLength) {
        this.name = name;
        this.bodyLength = bodyLength;
        this.tailLength = tailLength;
    }

    /**
     * Computes whether this animal can fit in a cage
     *
     * @param exhibitSideLength with a square side length
     * @return true if the animal fits
     */
    @Override
    public boolean fitInExhibit(int exhibitSideLength) {
        return exhibitSideLength > bodyLength + tailLength;
    }

    /**
     * @return the name of the animal
     */
    @Override
    public String name() {
        return this.name;
    }
}
