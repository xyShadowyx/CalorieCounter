package de.fhdw.bfws115a.team1.caloriecounter.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Unit implements Serializable {
    private String mName;

    public Unit(String name) {
        mName = name;
    }

    public Unit(Unit unit) {
        this(unit.getName());
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String toString() {
        return "Unit(Name: " + getName() + ")";
    }
}
