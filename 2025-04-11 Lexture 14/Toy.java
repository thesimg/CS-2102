public class Toy implements Comparable<Toy>{
    /** the name of this toy */
    private String name;
    /** 0 - common ~ 10 - ultra rare SSS+ */
    private int rarity;

    public Toy(String name, int rarity){
        this.name = name;
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o){
        if(! (o instanceof Toy)){
            return false;
        }
        Toy t = (Toy) o;
        return t.name.equals(this.name) && t.rarity == this.rarity;
    }

    @Override
    public String toString(){
        return String.format("%s[%d]",this.name, this.rarity);
    }

    // If you implement compareTo, then you can use List.sort(...)
    @Override
    public int compareTo(Toy o) {
        return (Integer.valueOf(this.rarity)).compareTo(o.rarity);
    }
}
