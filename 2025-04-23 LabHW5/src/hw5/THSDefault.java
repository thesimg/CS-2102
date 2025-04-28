package hw5;

import hw3.THRTPDate;
import java.util.ArrayList;
import java.util.Optional;

/**
 * a THStorable implementation that uses an ArrayList to store THRTPDate objects
 * @author graham simons
 */
public class THSDefault implements THStorable {

    private ArrayList<THRTPDate> store = new ArrayList<>();

    /**
     * 0-arg constructor
     */
    public THSDefault() {}

    /**
     * {@inheritDoc}
     * @runtime O(d) where d is the number of dates stored
     */
    @Override
    public boolean checkDateForData(String yyyymmdd) {
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @runtime O(d) where d is the number of dates stored
     */
    @Override
    public Optional<THRTPDate> getDataFromDate(String yyyymmdd) {
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                return Optional.of(dateEntry);
            }
        }
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     * @runtime O(d) where d is the number of dates stored
     */
    @Override
    public void removeDataOnDate(String yyyymmdd) {
        THRTPDate toRemove = null;
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                toRemove = dateEntry;
                break;
            }
        }
        if (toRemove != null) {
            store.remove(toRemove);
        }
    }

    /**
     * {@inheritDoc}
     * @runtime O(d) where d is the number of dates stored
     */
    @Override
    public void addDataToDate(String yyyymmdd, String sensorData) {
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                dateEntry.collect(sensorData);
                return;
            }
        }
        // no existing entry found, so create a new one
        THRTPDate newDateEntry = new THRTPDate(yyyymmdd);
        newDateEntry.collect(sensorData);
        store.add(newDateEntry);
    }

    /**
     * {@inheritDoc}
     * corrects transferDataTo logic
     */
    @Override
    public void transferDataTo(THStorable otherStorable) {
        for (THRTPDate dateEntry : store) {
            Optional<THRTPDate> maybeEntry = otherStorable.getDataFromDate(dateEntry.toString());
            if (maybeEntry.isPresent()) {
                // date already exists, merge
                maybeEntry.get().addAll(dateEntry);
            } else {
                // insert a real copy of the dateEntry
                if (otherStorable instanceof THSDefault) {
                    ((THSDefault) otherStorable).addDirect(dateEntry);
                } else if (otherStorable instanceof THSFastList) {
                    ((THSFastList) otherStorable).addDirect(dateEntry);
                } else {
                    // fallback if other store is unknown: create minimal version
                    otherStorable.addDataToDate(dateEntry.toString(), "");
                    otherStorable.getDataFromDate(dateEntry.toString()).ifPresent(newEntry -> newEntry.addAll(dateEntry));
                }
            }
        }
    }

    /**
     * helper to directly add a THRTPDate to the store
     * @param dateEntry the THRTPDate to add
     */
    void addDirect(THRTPDate dateEntry) {
        store.add(dateEntry);
    }
}
