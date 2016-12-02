package de.fhdw.bfws115a.team1.caloriecounter.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This class represents a QuantityUnit object.
 */

public class Unit implements Serializable {
    private String mName;

    /**
     * Constructor
     *
     * @param name
     */
    public Unit(String name) {
        mName = name;
    }

    /**
     * Constructor for copies
     *
     * @param unit
     */
    public Unit(Unit unit) {
        this(unit.getName());
    }

    /**
     * Get name of this unit
     *
     * @return name of unit
     */
    public String getName() {
        return mName;
    }

    /**
     * Set name of this unit
     *
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Converts this object to a readable output
     *
     * @return this object as a text
     */
    public String toString() {
        return "Unit(Name: " + getName() + ")";
    }
}
