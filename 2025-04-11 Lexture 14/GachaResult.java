import java.util.List;
public class GachaResult {
    private List<Toy> toysToReturn;
    private int quartersSpent;

    public GachaResult(List<Toy> toysToReturn, int quartersSpent){
        this.toysToReturn = toysToReturn;
        this.quartersSpent = quartersSpent;
    }

    public List<Toy> getToysToReturn(){
        return this.toysToReturn; // encapsulation error!
    }

    public int getQuartersSpent(){
        return this.quartersSpent;
    }

}
