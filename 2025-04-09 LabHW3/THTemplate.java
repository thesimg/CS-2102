import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * a template for temperature and humidity sensors
 * @author graham simons
 */
public abstract class THTemplate implements THSensible {
    protected List<String> sensorData;
    protected List<Double> temperatures;
    protected List<Double> humidities;

    public THTemplate() {
        sensorData = new ArrayList<>();
        temperatures = new ArrayList<>();
        humidities = new ArrayList<>();
    }

    /**
     * splits the input data string and adds it to sensorData then calls postCollect()
     * @param data the raw data string
     */
    public void collect(String data) {
        List<String> splitData = Arrays.asList(data.split("\\s+"));
        sensorData.addAll(splitData);
        postCollect();
    }

    /**
     * @param lo the lower bound
     * @param hi the upper bound
     * @return the number of temperatures outside the given range (not inclusive)
     */
    public int tempsOutsideRange(double lo, double hi) {
        preQuery();
        int count = 0;
        for (double temp : temperatures) {
            if (temp < lo || temp > hi) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the lowest humidity %, or 0 if none
     */
    public double minHumidity() {
        preQuery();
        if (humidities.isEmpty()) return 0;
        return humidities.get(0);
    }

    /**
     * @return the highest humidity %, or 0 if none
     */
    public double maxHumidity() {
        preQuery();
        if (humidities.isEmpty()) return 0;
        return humidities.get(humidities.size() - 1);
    }

    /**
     * @return the average humidity %, or 0 if none
     */
    public double avgHumidity() {
        preQuery();
        if (humidities.isEmpty()) return 0;
        double total = 0;
        for (double humidity : humidities) {
            total += humidity;
        }
        return total / humidities.size();
    }

    /**
     * removes all date strings and "Err" entries from sensorData
     */
    protected void clean() {
        List<String> cleaned = new ArrayList<>();
        for (String s : sensorData) {
            if (!(s.length() == 8 && s.chars().allMatch(Character::isDigit)) && !s.equals("Err")) {
                cleaned.add(s);
            }
        }
        sensorData = cleaned;
    }

    /**
     * parses cleaned sensorData into temperatures and humidities, then sorts both lists and clears sensorData
     */
    protected void parse() {
        for (int i = 0; i < sensorData.size() - 1; i++) {
            String label = sensorData.get(i);
            String value = sensorData.get(i + 1);
            try {
                if (label.equals("T")) {
                    temperatures.add(Double.parseDouble(value));
                } else if (label.equals("H")) {
                    humidities.add(Double.parseDouble(value));
                }
            } catch (NumberFormatException ignored) {}
        }

        Collections.sort(temperatures);
        Collections.sort(humidities);
        sensorData.clear();
    }

    /**
     * abstract postCollect() method to be implemented by children!
     */
    protected abstract void postCollect();

    /**
     * abstract preQuery() method to be implemented by children!
     */
    protected abstract void preQuery();
}
