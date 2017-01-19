package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.io.Serializable;

/**
 * This class represents a QuantityUnit object.
 *
 * @author Viktor Schroeder
 */

public class Unit implements Serializable {
    /* Member variables */
    private String mName;

    /**
     * Constructor
     *
     * @param name the name of the unit
     */
    public Unit(String name) {
        mName = name;
    }

    /**
     * Constructor for copies.
     *
     * @param unit the to copy unit
     */
    public Unit(Unit unit) {
        this(unit.getName());
    }

    /**
     * Get name of this unit.
     *
     * @return name of unit
     */
    public String getName() {
        return mName;
    }

    /**
     * Set name of this unit.
     *
     * @param name new name for unit
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        return "Unit(Name: " + getName() + ")";
    }
}
