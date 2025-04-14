import java.util.LinkedList;
import java.util.List;

public class Gachapon {

    private List<Toy> toys = new LinkedList<>();

    private int quartersLoaded = 0;

    private int quartersPerToy = 2;

    private IToyBinStrategy strategy;

    public Gachapon(List<Toy> toys){
        this.toys.addAll(toys); // Encapsulation error!!!!

    }

    public Gachapon refillToyBin(List<Toy> toys){
        this.toys.addAll(toys);
        return this;
    }

    public Gachapon loadQuarter(){
        this.quartersLoaded++;
        return this;
    }
    public Gachapon loadQuarter(int howMany){
        this.quartersLoaded+= howMany;
        return this;
    }

    public int refundQuarters(){
        int quartersToRefund = this.quartersLoaded;
        this.quartersLoaded = 0;
        return quartersToRefund;
    }

    public List<Toy> receiveToys(){
//        LinkedList<Toy> toysToReceive = new LinkedList<>();
//        if(quartersLoaded < quartersPerToy){
//            System.err.println("Not enough quarters");
//        }
//        for(int i = quartersLoaded; i >= quartersPerToy && ! toys.isEmpty(); i = i - quartersPerToy){
//            toysToReceive.add(toys.remove(0));
//        }
//        return toysToReceive;
        GachaResult gr = this.strategy.receiveToys(quartersLoaded, quartersPerToy, toys);
        this.quartersLoaded -= gr.getQuartersSpent();
        return gr.getToysToReturn();
    }

    public void setStrategy(IToyBinStrategy strategy){
        this.strategy = strategy; // okay encapsulation because no mutable data :)
    }


}
