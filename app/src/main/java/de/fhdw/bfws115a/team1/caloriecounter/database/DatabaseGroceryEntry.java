package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryEntry;

/**
 * @author Viktor Schroeder.
 */
public class DatabaseGroceryEntry extends GroceryEntry implements DatabaseEntry {
    private long mId;

    public DatabaseGroceryEntry(int year, int month, int day, FixGrocery fixGrocery, long id) {
        super(year, month, day, fixGrocery);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }

    public String toString() {
        return "DatabaseGroceryEntry(Id: " + getId() + ", GroceryEntry: " + super.toString() + ")";
    }

    @Override
    public String getName() {
        return this.getFixGrocery().getName();
    }

    @Override
    public double getAmount() {
        return this.getFixGrocery().getAmount();
    }

    @Override
    public String getUnitName() {
        return this.getFixGrocery().getUnit().getName();
    }

    @Override
    public int getCalories() {
        return this.getFixGrocery().getKcal();
    }

    @Override
    public void setAmount(double amount) {
        this.getFixGrocery().setAmount(amount);
    }

    @Override
    public int compareTo(DatabaseEntry databaseEntry) {
        return (int) databaseEntry.getId();
    }
}
