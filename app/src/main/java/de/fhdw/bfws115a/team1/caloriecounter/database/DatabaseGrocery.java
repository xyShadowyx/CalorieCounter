package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;

/**
 * @author Viktor Schroeder.
 */
public class DatabaseGrocery extends Grocery implements DatabaseGroceriesEntity {
    private long mId;

    public DatabaseGrocery(String name, int kcal, long id) {
        super(name, kcal);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }

    public String toString() {
        return "DatabaseGrocery(Id: " + getId() + ", Grocery: " + super.toString() + ")";
    }
}
