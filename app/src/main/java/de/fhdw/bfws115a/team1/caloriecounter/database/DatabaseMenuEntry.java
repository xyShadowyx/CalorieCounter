package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.MenuEntry;

/**
 * This class represents a menu entry in database.
 *
 * @author Viktor Schroeder
 */
public class DatabaseMenuEntry extends MenuEntry implements DatabaseEntry {
    /* Member variables */
    private long mId;

    /**
     * Constructor
     * Is package-private to prevent wrong usage.
     *
     * @param year year of entry
     * @param month month of entry
     * @param day day of month of entry
     * @param menu menu of entry
     * @param id id of entry in database
     */
    DatabaseMenuEntry(int year, int month, int day, Menu menu, long id) {
        super(year, month, day, menu);
        mId = id;
    }


    /**
     * Get the ID of unit in database.
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
        return "DatabaseMenuEntry(Id: " + getId() +", MenuEntry: " + super.toString() + ")";
    }

    /**
     * Get the name of menu.
     *
     * @return menu name
     */
    @Override
    public String getName() {
        return this.getMenu().getName();
    }

    /**
     * Get the portion size of menu.
     *
     * @return menu portion size
     */
    @Override
    public double getAmount() {
        return this.getMenu().getAmount();
    }

    /**
     * Get unit name.
     *
     * @return unit name
     */
    @Override
    public String getUnitName() {
        return "Port.";
    }

    /**
     * Set portion size.
     *
     * @param amount new size
     */
    @Override
    public void setAmount(double amount) {
        this.getMenu().setAmount(amount);
    }

    /**
     * Get Calories.
     *
     * @return calories amount
     */
    @Override
    public int getCalories() {
        return this.getMenu().getKcal();
    }

    /**
     * Compare for sorting.
     *
     * @param databaseEntry other DatabaseEntry
     * @return true
     */
    @Override
    public int compareTo(DatabaseEntry databaseEntry) {
        return (int)databaseEntry.getId();
    }
}
