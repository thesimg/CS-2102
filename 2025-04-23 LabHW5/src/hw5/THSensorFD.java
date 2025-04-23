package hw5;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** A class that simulates a THSensor as a File Descriptor (FD) like one found plugged into a raspberry pi*/
public class THSensorFD {

    private List<String> readings;
    private int curr = 0;
    public THSensorFD(String filename) {
        try {
            readings = Files.lines(Paths.get(filename)).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a temperature and humidity reading from the sensor file
     * @param isWet adjusts the humidity simulation based on wetness state at reading time
     * @param isSunny adjusts the temperature simulation based on sunniness state at reading time
     * @return a reading in "T %d H %d" format
     */
    public String getReading(boolean isWet, boolean isSunny){
        int humidBoost = isWet ? 2 : 0;
        int tempBoost = isSunny ? 5 : 0;
        String[] reading = readings.get(curr).split(" ");

        // advance cursor
        curr++;
        if(curr >= readings.size()){
            curr = 0;
        }

        if(reading.length == 4) {

            double temp = Double.parseDouble(reading[1]) + tempBoost;
            double humid = Double.parseDouble(reading[3]) + humidBoost;

            return String.format("T %.1f H %.1f", temp, humid);
        } else {
            return "Err";
        }

    }

}
