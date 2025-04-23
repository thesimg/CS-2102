package hw5;

import hw3.THRTPDate;

import java.util.ArrayList;
import java.util.LinkedList;

/** Logic for a greenhouse simulator which contains multiple temperature and humidity sensors */
public class GreenHouse {

    /** The simulated data store collected so far */
    private ArrayList<THRTPDate> storeByDate = new ArrayList<>();

    /** The sensors that can produce temperature and humidity values */
    private LinkedList<THSensorFD> sensors = new LinkedList<>();

    /* Simulation controls */
    private boolean sprinklersOn = false;
    private boolean lampsOn = false;

    /** The current date on the greenhouse's digital calendar */
    private GHCalendar currentDate;
    /** The last date successfully queried from the store */
    private String lastDateQueried;

    private double goodLoTemp = 60.0;
    private double goodHiTemp = 80.0;

    /**
     * Construct a smart greenhouse
     * @param ghCalendar the starting date for the greenhouse
     */
    public GreenHouse(GHCalendar ghCalendar) {
        currentDate = ghCalendar; // TODO: Fix me - Encapsulation Error!!!
        lastDateQueried = currentDate.toString(); // last date queried is the current date by default
        sensors.add(new THSensorFD("THSensorData1.txt"));
        sensors.add(new THSensorFD("THSensorData2.txt"));
        sensors.add(new THSensorFD("THSensorData3.txt"));
        sensors.add(new THSensorFD("THSensorBroken.txt"));
    }

    // SIMULATOR CONTROLLER

    /**
     * turns the sprinklers on/off
     * @return this greenhouse object for method chaining
     */
    public GreenHouse toggleSprinkler(){
        sprinklersOn = !sprinklersOn;
        return this;
    }
    /**
     * turns the heat lamps on/off
     * @return this greenhouse object for method chaining
     */
    public GreenHouse toggleLamp(){
        lampsOn = !lampsOn;
        return this;
    }

    public GreenHouse adjustLowTemp(double newLo){
        goodLoTemp = newLo;
        return this;
    }

    public GreenHouse adjustHiTemp(double newHi){
        goodHiTemp = newHi;
        return this;
    }

    /**
     * polls each of the sensors, adding their data to the store under todays date
     * @return this greenhouse for method chaining
     */
    public GreenHouse pollSensors(){
        String date = currentDate.toString();
        StringBuilder sensorData = new StringBuilder(date);
        for(THSensorFD sensor : sensors){
            sensorData.append(" ").append(sensor.getReading(sprinklersOn, lampsOn));
        }

        boolean foundIt = false;
        for(THRTPDate store : storeByDate){
            if(store.compareTo(new THRTPDate(date)) == 0){
                foundIt = true;
                store.collect(sensorData.toString());
            }
        }
        if(!foundIt){
            THRTPDate store = new THRTPDate(date);
            store.collect(sensorData.toString());
            storeByDate.add(store);
        }
        return this;
    }

    /**
     * Moves the date forward in time by a day
     * @return this greenhouse for method chaining
     */
    public GreenHouse advance(){
        this.currentDate.addDay();
        return this;
    }

    /**
     * Removes the data for the current date and rolls back the date to yesterday
     * @return this greenhouse for method chaining
     */
    public GreenHouse undo(){
        // Remove the data for today
        this.storeByDate.remove(new THRTPDate(this.currentDate.toString()));
        // roll back the calendar
        this.currentDate.minusDay();
        return this;
    }

    // QUERIES

    /**
     * @return the current "yyyymmdd" for the calendar (used for debugging)
     */
    public String currentYYYYMMDD(){
        return this.currentDate.toString();
    }

    /**
     * Generates a report for the last THRTPDate that was queried previously
     * Note: new sensor data may have been collected since the last report was generated
     * @return a report like {20250421 | abnormal temps: 13 | humidity: 33.5 40.0 53.7}
     */
    public String generateReport(){
        return this.generateReport(lastDateQueried);
    }

    /**
     * Generates a report for a particular date
     * @param yyyymmdd a date string in yyyymmdd format like "20250421"
     * @return a report like {20250421 | abnormal temps: 13 | humidity: 33.5 40.0 53.7}
     */
    public String generateReport(String yyyymmdd){
        this.lastDateQueried = yyyymmdd;
        THRTPDate currStore = new THRTPDate(yyyymmdd);
        for(THRTPDate store : storeByDate){
            if(store.compareTo(currStore) == 0){
                currStore = store;
            }
        }
        return String.format("{%s | abnormal temps: %d | humidity: %.1f %.1f %.1f}",
                yyyymmdd,
                currStore.tempsOutsideRange(goodLoTemp, goodHiTemp),
                currStore.minHumidity(),
                currStore.avgHumidity(),
                currStore.maxHumidity());
    }

    /**
     * Generates a report aggregating all THRTPDate objects stored between the date ranges (inclusively)
     * @param beginDate in yyyymmdd format like "20250421"
     * @param endDate in yyyymmdd format like "20250501"
     * @return a report like {20250421 - 20250501 | abnormal temps: 13 | humidity: 33.5 40.0 53.7}
     */
    public String generateReport(String beginDate, String endDate){
        if(beginDate.compareTo(endDate) > 0){
            throw new RuntimeException("beginDate cannot be after endDate");
        }

        GHCalendar beginCalendar = new GHCalendar(beginDate);
        GHCalendar endCalendar = new GHCalendar(endDate);
        int totalTemperatureCount = 0;
        double totalMinHumidity = 0;
        double totalAvgHumidity = 0;
        double totalMaxHumidity = 0;
        int countDaysHit = 0;
        while(beginCalendar.compareTo(endCalendar) <= 0){
            String yyyymmdd = beginCalendar.toString();
            THRTPDate currStore = new THRTPDate(yyyymmdd);
            this.lastDateQueried = yyyymmdd;
            for(THRTPDate store : this.storeByDate){
                if(store.compareTo(currStore) == 0){
                    totalTemperatureCount += store.tempsOutsideRange(goodLoTemp, goodHiTemp);
                    totalMinHumidity += store.minHumidity();
                    totalAvgHumidity += store.avgHumidity();
                    totalMaxHumidity += store.maxHumidity();
                    countDaysHit++;
                }
            }
            beginCalendar.addDay();
        }
        return String.format("{%s - %s | abnormal temps: %d | humidity: %.1f %.1f %.1f}",
                beginDate, endDate,
                totalTemperatureCount,
                totalMinHumidity / Math.max(1,countDaysHit), // avoid divide-by-zero
                totalAvgHumidity / Math.max(1,countDaysHit),
                totalMaxHumidity / Math.max(1,countDaysHit));
    }



    /**
     * For debugging purposes
     * @return a string representation of the greenhouse
     */
    public String toString(){
        return  String.format("GreenHouse [%s]%n", currentDate.toString()) +
                String.format("sensors: %d%n", sensors.size()) +
                String.format("sprinklers: %s | lamps: %s%n", sprinklersOn, lampsOn);
    }


}
