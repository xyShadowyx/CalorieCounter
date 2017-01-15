package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;

/**
 * Created by xySha on 18.11.2016.
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
        return "DatabaseGrocery(Id: " + getId() +", Grocery: " + super.toString() + ")";
    }
}
