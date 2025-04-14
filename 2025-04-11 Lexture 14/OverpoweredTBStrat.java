import java.util.Collections;
import java.util.List;

public class OverpoweredTBStrat implements IToyBinStrategy {

    @Override
    public GachaResult receiveToys(int quartersLoaded, int quartersPerToy, List<Toy> toys) {
        toys.sort(Toy::compareTo);
        Collections.reverse(toys);
        InOrderTBStrat inOrderTBStrat = new InOrderTBStrat();
        return inOrderTBStrat.receiveToys(quartersLoaded, quartersPerToy, toys);
    }
}
