import java.util.LinkedList;
import java.util.List;

public class NoDupesTBStrat implements IToyBinStrategy{

    @Override
    public GachaResult receiveToys(int quartersLoaded, int quartersPerToy, List<Toy> toys) {
        LinkedList<Toy> toysToReceive = new LinkedList<>();
        int quartersSpent = 0;
        for(int i = quartersLoaded; i >= quartersPerToy && ! toys.isEmpty(); i = i - quartersPerToy){
            boolean searching = true;
            for(int j = 0; j < toys.size(); j++){
                if(searching && ! toysToReceive.contains(toys.get(j)))
                toysToReceive.add(toys.remove(0));
                quartersSpent += quartersPerToy;
                searching = false;
            }
        }
        return new GachaResult(toysToReceive, quartersSpent);    }
}
