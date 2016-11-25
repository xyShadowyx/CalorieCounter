package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

/**
 * Created by xySha on 18.11.2016.
 */
public class DatabaseGrocery extends Grocery implements DatabaseEntity {
    private long mId;

    public DatabaseGrocery(String name, Unit unit, double amount, int kcal, long id) {
        super(name, unit, amount, kcal);
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
