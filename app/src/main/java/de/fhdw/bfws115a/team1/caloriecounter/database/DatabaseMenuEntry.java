package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.MenuEntry;

/**
 * Created by xySha on 18.11.2016.
 */
public class DatabaseMenuEntry extends MenuEntry implements DatabaseEntity {
    private long mId;

    public DatabaseMenuEntry(int year, int month, int day, Menu menu, long id) {
        super(year, month, day, menu);
        mId = id;
    }

    @Override
    public long getId() {
        return mId;
    }
}
