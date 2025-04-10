import java.util.List;

public abstract class THTemplate implements THSensible {
    protected List<String> sensorData;
    protected List<Double> temperatures;
    protected List<Double> humidities;

    public THTemplate() {}

    public void collect(String data) {

    }

    public int tempsOutsideRange(double lo, double hi) {
        return 0;
    }

    public double minHumidity() {
        return 0;
    }

    public double maxHumidity() {
        return 0;
    }

    public double avgHumidity() {
        return 0;
    }

    protected void clean(){

    }

    protected void parse(){

    }

    protected abstract void postCollect();

    protected abstract void preQuery();
}
