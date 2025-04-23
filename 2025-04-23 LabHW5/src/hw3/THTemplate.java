package hw3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/** Template Method pattern for a Temperature-Humidity Combo sensor */
public abstract class THTemplate implements THSensible {

    /** Intake data holding either a date, err, "T", "H", or a reading value (double) */
    protected List<String> sensorData = new LinkedList<>();

    /** Temperatures encountered so far in Fahrenheit*/
    protected List<Double> temperatures = new LinkedList<>();
    /** Humidity values encountered so far (0.0% - 100.0%) */
    protected List<Double> humidities = new LinkedList<>();

    /**
     * Adds the incoming data, split by " ", to the intake state, then calls postCollect()
     * @param data the space separated data
     */
    public void collect(String data){
        sensorData.addAll(Arrays.asList(data.split(" ")));
        this.postCollect();
    }

    /**
     * The operations that should happen after data is collected.
     */
    protected abstract void postCollect();

    /**
     * The operations that should happen before each query
     */
    protected abstract void preQuery();

    /**
     * Removes dates and errors from intake
     */
    protected void clean() {
        List<String> cleaned = new LinkedList<>();
        for(String s : this.sensorData){
            if((! s.equals("Err")) && (s.length() != 8)){
                cleaned.add(s);
            }
        }
        this.sensorData = cleaned;
    }

    /**
     * Removes data from intake and puts it in the appropriate list (temps, humids)
     * Sorts the temperature and humidity lists.
     */
    protected void parse() {
        for(int i = 0; i < this.sensorData.size(); i += 2){
            if(this.sensorData.get(i).equals("T")){
                this.temperatures.add(Double.parseDouble(this.sensorData.get(i+1)));
            } else if(this.sensorData.get(i).equals("H")){
                this.humidities.add(Double.parseDouble(this.sensorData.get(i+1)));
            }
        }
        this.temperatures.sort(Double::compareTo);
        this.humidities.sort(Double::compareTo);
        this.sensorData.clear();
    }

    /**
     * (exclusive) and processes the preQuery() before running.
     * @param lo a low temperature in F
     * @param hi a higher temperature in F
     * @return the count of how many temperatures fall outside of the range
     */
    public int tempsOutsideRange(double lo, double hi){
        this.preQuery();
        int count = 0;
        for(Double t : this.temperatures){
            if(t < lo || t > hi){
                count++;
            }
        }
        return count;
    }

    /**
     * runs preQuery() before processing
     * @return the smallest humidity in the list of humidities (or 0 if none)
     */
    public double minHumidity(){
        this.preQuery();
        if(this.humidities.isEmpty()){
            return 0;
        }
        return this.humidities.get(0);
    }

    /**
     * runs preQuery() before processing
     * @return the largest humidity in the list of humidities (or 0 if none)
     */
    public double maxHumidity(){
        this.preQuery();
        if(this.humidities.isEmpty()){
            return 0;
        }
        return this.humidities.get(this.humidities.size()-1);
    }

    /**
     * runs preQuery() before processing
     * @return the average humidity (or 0 if none)
     */
    public double avgHumidity(){
        this.preQuery();
        if(this.humidities.isEmpty()){
            return 0;
        }
        double total = 0;
        for(Double h : this.humidities){
            total += h;
        }
        return total/this.humidities.size();
    }



}
