package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

/**
 * Created by xySha on 18.11.2016.
 */
public class DatabaseUnit extends Unit implements DatabaseEntity {
    private long mId;

    public DatabaseUnit(String name, long id) {
        super(name);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }

    public String toString() {
        return "DatabaseUnit(Id: " + getId() +", Unit: " + super.toString() + ")";
    }
}
