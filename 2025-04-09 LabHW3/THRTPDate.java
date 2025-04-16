import java.util.ArrayList;
import java.util.List;

/**
 * a real-time processor that only works on a given date
 * @author graham simons
 */
public class THRTPDate extends THRTP implements THSensible, Comparable<THRTPDate> {
    String date;

    /**
     * @param date the given date in format yyyymmdd
     */
    public THRTPDate(String date) {
        this.date = date;
    }

    /**
     * removes data not from the given date
     */
    @Override
    protected void clean() {
        List<String> trimmed = new ArrayList<>();
        boolean keepFollowingData = false;

        for (int i = 0; i < sensorData.size(); i++) {
            String value = sensorData.get(i);
            if (value.length() == 8 && value.chars().allMatch(Character::isDigit)) {
                if (value.equals(date)){
                    keepFollowingData = true;
                }
            } else if (keepFollowingData) {
                trimmed.add(value);
            }
        }

        sensorData = trimmed;
        super.clean(); // remove dates & errors
    }

    /**
     * @param o object to compare to
     * @return true if the other onject is a THRTPDate with the same date
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof THRTPDate){
            return date.equals(((THRTPDate) o).date);
        } else {
            return false;
        }
    }

    /**
     * @param o the object to be compared.
     * @return comparison between the two dates
     */
    @Override
    public int compareTo(THRTPDate o) {
        return date.compareTo(o.date);
    }
}
