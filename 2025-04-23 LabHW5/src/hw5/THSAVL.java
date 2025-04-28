package hw5;

import hw3.THRTPDate;
import hw4.BST;
import hw4.IBinTree;
import hw4.StrategyAVL;
import hw4.ValidatorBTDefault;
import java.util.Optional;

/**
 * a THStorable implementation using a self-balancing BST (AVL tree) to store THRTPDate objects
 * @author graham simons
 */
public class THSAVL extends BST<THRTPDate> implements THStorable {

    /**
     * 0-arg constructor
     */
    public THSAVL() {
        super();
        this.setStrategy(new StrategyAVL<>());
        this.setValidator(new ValidatorBTDefault<>());
    }

    /**
     * checks if data exists for a given date
     * @param yyyymmdd the date string to check
     * @return true if data exists, false otherwise
     * @runtime O(log d)
     */
    @Override
    public boolean checkDateForData(String yyyymmdd) {
        return this.search(new THRTPDate(yyyymmdd)).isPresent();
    }

    /**
     * gets the data associated with a given date
     * @param yyyymmdd the date string to retrieve data for
     * @return an Optional containing the THRTPDate if found, otherwise empty
     * @runtime O(log d)
     */
    @Override
    public Optional<THRTPDate> getDataFromDate(String yyyymmdd) {
        return this.search(new THRTPDate(yyyymmdd));
    }

    /**
     * removes data associated with a given date
     * @param yyyymmdd the date string to remove data for
     * @runtime O(log d)
     */
    @Override
    public void removeDataOnDate(String yyyymmdd) {
        this.removeElt(new THRTPDate(yyyymmdd));
    }

    /**
     * adds sensor data for a given date
     * @param yyyymmdd the date string associated with the data
     * @param sensorData the sensor reading to add
     * @runtime O(log d)
     */
    @Override
    public void addDataToDate(String yyyymmdd, String sensorData) {
        Optional<THRTPDate> maybeEntry = this.search(new THRTPDate(yyyymmdd));
        if (maybeEntry.isPresent()) {
            maybeEntry.get().collect(sensorData);
        } else {
            THRTPDate newEntry = new THRTPDate(yyyymmdd);
            newEntry.collect(sensorData);
            this.addElt(newEntry);
        }
    }

    /**
     * transfers all data from this store to another store
     * @param otherStorable the target store to receive the data
     * @runtime if m is the cost of adding to otherStorable: O(d*m)
     */
    @Override
    public void transferDataTo(THStorable otherStorable) {
        transferHelper(this.data, otherStorable);
    }

    /**
     * helper method to transfer all data recursively from the tree
     */
    private void transferHelper(IBinTree<THRTPDate> tree, THStorable otherStorable) {
        if (!tree.isEmpty()) {
            THRTPDate rootData = tree.getRoot();
            Optional<THRTPDate> maybeEntry = otherStorable.getDataFromDate(rootData.toString());
            if (maybeEntry.isPresent()) {
                maybeEntry.get().addAll(rootData);
            } else {
                // create empty date as placeholder
                otherStorable.addDataToDate(rootData.toString(), "T 0.0");

                // merge real data to that date
                Optional<THRTPDate> created = otherStorable.getDataFromDate(rootData.toString());
                if (created.isPresent()) {
                    created.get().addAll(rootData);
                }
            }

            transferHelper(tree.getLeft(), otherStorable);
            transferHelper(tree.getRight(), otherStorable);
        }
    }




}
