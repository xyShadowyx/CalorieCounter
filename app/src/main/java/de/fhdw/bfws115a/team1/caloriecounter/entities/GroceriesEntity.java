package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * Created by xySha on 23.11.2016.
 */
public abstract class GroceriesEntity {
    private String mName;

    public GroceriesEntity(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
