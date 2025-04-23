package hw3;

public interface THSensible {
    void collect(String data);
    int tempsOutsideRange(double lo, double hi);
    double minHumidity();
    double maxHumidity();
    double avgHumidity();
}
