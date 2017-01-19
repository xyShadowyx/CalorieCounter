package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.io.Serializable;

/**
 * This is a generalisation class for Grocery, FixGrocery and Menu to store and handle them together.
 *
 * @author Viktor Schroeder
 */
public abstract class GroceriesEntity implements Serializable {
    /* Member variables */
    private String mName;

    /**
     * Constructor
     *
     * @param name name of entity
     */
    public GroceriesEntity(String name) {
        mName = name;
    }

    /**
     * Get the name.
     *
     * @return name
     */
    public String getName() {
        return mName;
    }

    /**
     * Set the name.
     *
     * @param name new name
     */
    public void setName(String name) {
        mName = name;
    }
}
