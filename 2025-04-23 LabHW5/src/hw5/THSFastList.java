package hw5;

import hw3.THRTPDate;
import java.util.LinkedList;
import java.util.Optional;

/**
 * a THStorable implementation that uses a LinkedList and caching to store THRTPDate objects efficiently
 * @author graham simons
 */
public class THSFastList implements THStorable {

    private LinkedList<THRTPDate> store = new LinkedList<>();
    private THRTPDate lastAddedEntry;

    /**
     * 0-arg constructor
     */
    public THSFastList() {}

    /**
     * {@inheritDoc}
     * @runtime O(1) if the date is the most recently added, otherwise O(d)
     */
    @Override
    public boolean checkDateForData(String yyyymmdd) {
        if (lastAddedEntry != null && lastAddedEntry.toString().equals(yyyymmdd)) {
            return true;
        }
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @runtime O(1) if the date is the most recently added, otherwise O(d)
     */
    @Override
    public Optional<THRTPDate> getDataFromDate(String yyyymmdd) {
        if (lastAddedEntry != null && lastAddedEntry.toString().equals(yyyymmdd)) {
            return Optional.of(lastAddedEntry);
        }
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                return Optional.of(dateEntry);
            }
        }
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     * @runtime O(1) if the date is the most recently added and removed immediately, otherwise O(d)
     */
    @Override
    public void removeDataOnDate(String yyyymmdd) {
        if (lastAddedEntry != null && lastAddedEntry.toString().equals(yyyymmdd)) {
            store.remove(lastAddedEntry);
            lastAddedEntry = null;
            return;
        }

        THRTPDate toRemove = null;
        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                toRemove = dateEntry;
                break;
            }
        }
        if (toRemove != null) {
            store.remove(toRemove);
            if (toRemove == lastAddedEntry) {
                lastAddedEntry = null;
            }
        }
    }

    /**
     * {@inheritDoc}
     * @runtime O(1) if adding to the most recently added date, otherwise O(d)
     */
    @Override
    public void addDataToDate(String yyyymmdd, String sensorData) {
        if (lastAddedEntry != null && lastAddedEntry.toString().equals(yyyymmdd)) {
            lastAddedEntry.collect(sensorData);
            return;
        }

        for (THRTPDate dateEntry : store) {
            if (dateEntry.toString().equals(yyyymmdd)) {
                dateEntry.collect(sensorData);
                lastAddedEntry = dateEntry;
                return;
            }
        }

        // No existing entry, create a new one
        THRTPDate newDateEntry = new THRTPDate(yyyymmdd);
        newDateEntry.collect(sensorData);
        store.add(newDateEntry);
        lastAddedEntry = newDateEntry;
    }

    /**
     * {@inheritDoc}
     * properly transfers all temperature and humidity data
     */
    @Override
    public void transferDataTo(THStorable otherStorable) {
        for (THRTPDate dateEntry : store) {
            Optional<THRTPDate> maybeEntry = otherStorable.getDataFromDate(dateEntry.toString());
            if (maybeEntry.isPresent()) {
                maybeEntry.get().addAll(dateEntry);
            } else {
                if (otherStorable instanceof THSDefault) {
                    ((THSDefault) otherStorable).addDirect(dateEntry);
                } else if (otherStorable instanceof THSFastList) {
                    ((THSFastList) otherStorable).addDirect(dateEntry);
                } else {
                    // fallback for unknown stores: slow but safe
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
