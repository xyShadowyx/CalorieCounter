package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;

/**
 * @author Viktor Schroeder.
 */
public class DatabaseMenu extends Menu implements DatabaseGroceriesEntity {
    private long mId;

    public DatabaseMenu(String name, double portions, long id) {
        super(name, portions);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }

    public String toString() {
        return "DatabaseMenu(Id: " + getId() + ", Menu: " + super.toString() + ")";
    }
}
