import java.util.List;

public interface IToyBinStrategy {
    public GachaResult receiveToys(int quartersLoaded, int quartersPerToy, List<Toy> toys);
}
