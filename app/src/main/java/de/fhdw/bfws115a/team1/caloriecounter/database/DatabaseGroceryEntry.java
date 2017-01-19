package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryEntry;

/**
 * This class represents a grocery entry.
 *
 * @authpr Viktor Schroeder
 */
public class DatabaseGroceryEntry extends GroceryEntry implements DatabaseEntry {
    /* Member variables */
    private long mId;

    /**
     * Constructor
     * Is package-private to prevent wrong usage.
     *
     * @param year       year of entry
     * @param month      month of entry
     * @param day        day of month of entry
     * @param fixGrocery fix grocery of entry
     * @param id         id of entry in database
     */
    DatabaseGroceryEntry(int year, int month, int day, FixGrocery fixGrocery, long id) {
        super(year, month, day, fixGrocery);
        mId = id;
    }

    /**
     * Get grocery entry ID from database.
     *
     * @return ID
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        return "DatabaseGroceryEntry(Id: " + getId() + ", GroceryEntry: " + super.toString() + ")";
    }

    /**
     * Get name of grocery.
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.getFixGrocery().getName();
    }

    /**
     * Get amount of grocery.
     *
     * @return amount
     */
    @Override
    public double getAmount() {
        return this.getFixGrocery().getAmount();
    }

    /**
     * Set new amount
     *
     * @param amount new amount
     */
    @Override
    public void setAmount(double amount) {
        this.getFixGrocery().setAmount(amount);
    }

    /**
     * Get unit name of grocery.
     *
     * @return unit name
     */
    @Override
    public String getUnitName() {
        return this.getFixGrocery().getUnit().getName();
    }

    /**
     * Get calories of grocery.
     *
     * @return calories amount.
     */
    @Override
    public int getCalories() {
        return this.getFixGrocery().getKcal();
    }

    /**
     * Compare for sorting.
     *
     * @param databaseEntry other DatabaseEntry
     * @return true
     */
    @Override
    public int compareTo(DatabaseEntry databaseEntry) {
        return (int) databaseEntry.getId();
    }
}
