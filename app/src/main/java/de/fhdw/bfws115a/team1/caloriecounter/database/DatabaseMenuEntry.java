package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.MenuEntry;

/**
 * @author Viktor Schroeder.
 */
public class DatabaseMenuEntry extends MenuEntry implements DatabaseEntry {
    private long mId;

    public DatabaseMenuEntry(int year, int month, int day, Menu menu, long id) {
        super(year, month, day, menu);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }

    public String toString() {
        return "DatabaseMenuEntry(Id: " + getId() + ", MenuEntry: " + super.toString() + ")";
    }

    @Override
    public String getName() {
        return this.getMenu().getName();
    }

    @Override
    public double getAmount() {
        return this.getMenu().getAmount();
    }

    @Override
    public String getUnitName() {
        return "Port.";
    }

    @Override
    public void setAmount(double amount) {
        this.getMenu().setAmount(amount);
    }

    @Override
    public int getCalories() {
        return this.getMenu().getKcal();
    }

    @Override
    public int compareTo(DatabaseEntry databaseEntry) {
        return (int) databaseEntry.getId();
    }
}
