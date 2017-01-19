package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;

/**
 * This class represents a grocery
 */
public class DatabaseGrocery extends Grocery implements DatabaseGroceriesEntity {
    /* Member variables */
    private long mId;

    /**
     * Constructor
     * Is package-private to prevent wrong usage.
     *
     * @param name grocery name
     * @param kcal grocery calories
     * @param id grocery database id
     */
    public DatabaseGrocery(String name, int kcal, long id) {
        super(name, kcal);
        mId = id;
    }

    /**
     * Get grocery database ID
     *
     * @return databse id
     */
    @Override
    public long getId() {
        return mId;
    }


    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        return "DatabaseGrocery(Id: " + getId() +", Grocery: " + super.toString() + ")";
    }
}
