package hw5;

import hw3.THRTPDate;

import java.util.Optional;

public interface THStorable {
    boolean checkDateForData(String yyyymmdd);

    Optional<THRTPDate> getDataFromDate(String yyyymmdd);

    void removeDataOnDate(String yyyymmdd);

    void addDataToDate(String yyyymmdd);

    void transferDataTo(THStorable otherStorable);
}
