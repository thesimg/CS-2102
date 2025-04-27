package hw5;

import hw3.THRTPDate;

import java.util.Optional;

/**
 * An Abstract Data Type for storing THRTPDate objects
 * @author graham simons
 */
public interface THStorable {

    /**
     * Checks if data exists for a given date
     * @param yyyymmdd the date string to check
     * @return true if data exists, false otherwise
     */
    boolean checkDateForData(String yyyymmdd);

    /**
     * Gets the data associated with a given date
     * @param yyyymmdd the date string to retrieve data for
     * @return an Optional containing the THRTPDate if found, otherwise empty
     */
    Optional<THRTPDate> getDataFromDate(String yyyymmdd);

    /**
     * Removes data associated with a given date
     * @param yyyymmdd the date string to remove data for
     */
    void removeDataOnDate(String yyyymmdd);

    /**
     * Adds data for a given date
     * (Implementation note: May need the THRTPDate object itself)
     * @param yyyymmdd the date string associated with the data
     */
    void addDataToDate(String yyyymmdd);

    /**
     * Transfers all data from this store to another store
     * @param otherStorable the target store to receive the data
     */
    void transferDataTo(THStorable otherStorable);
}