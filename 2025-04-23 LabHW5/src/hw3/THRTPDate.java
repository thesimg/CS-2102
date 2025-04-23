package hw3;

import java.util.LinkedList;
import java.util.List;

/** Specializes RPT implementation to only process data for a particular date */
public class THRTPDate extends THRTP implements Comparable<THRTPDate> {

    /** The date for this */
    protected String date;

    /**
     * Constructs a TH processor for a particular date string
     * @param date yyyymmdd format
     */
    public THRTPDate(String date) {
        this.date = date;
    }

    @Override
    protected void clean(){
        List<String> cleaned = new LinkedList<>();
        boolean keep = false;
        for(String s : this.sensorData){
            if(s.length() == 8 && s.equals(this.date)){
                keep = true;
            } else if (s.length() == 8){
                keep = false;
            }

            if (keep){
                cleaned.add(s);
            }
        }
        this.sensorData = cleaned;
        super.clean();
    }

    @Override
    public int compareTo(THRTPDate s) {
        return (int) Math.signum(this.date.compareTo(s.date));
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof THRTPDate th){
            return this.date.equals(th.date);
        }
        return false;
    }

    // Added for HW5:

    /**
     * adds all the data from another THRTPDate object into this one
     * @param fromAnother another THRTPDate object
     * @return true if the dates were the same
     */
    public boolean addAll(THRTPDate fromAnother){
        if(this.date.equals(fromAnother.date)){
            this.temperatures.addAll(fromAnother.temperatures);
            this.humidities.addAll(fromAnother.humidities);
            this.parse(); //sorts if necessary
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return this.date;
    }
}
