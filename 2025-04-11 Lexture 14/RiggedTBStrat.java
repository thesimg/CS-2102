import java.util.List;

public class RiggedTBStrat implements IToyBinStrategy {

    @Override
    public GachaResult receiveToys(int quartersLoaded, int quartersPerToy, List<Toy> toys) {
        toys.sort(Toy::compareTo);
        InOrderTBStrat inOrderTBStrat = new InOrderTBStrat();
        return inOrderTBStrat.receiveToys(quartersLoaded, quartersPerToy, toys);
    }
}
