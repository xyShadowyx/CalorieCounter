package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;

/**
 * This class represents a menu in database.
 *
 * @author Viktor Schroeder
 */
public class DatabaseMenu extends Menu implements DatabaseGroceriesEntity {
    /* Member variables */
    private long mId;

    /**
     * Constructor
     * Is package-private to prevent wrong usage.
     *
     * @param name menu name
     * @param portions menu portion
     * @param id menu id in database
     */
    DatabaseMenu(String name, double portions, long id) {
        super(name, portions);
        mId = id;
    }

    /**
     * Get menu id from database.
     *
     * @return menu id
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
        return "DatabaseMenu(Id: " + getId() +", Menu: " + super.toString() + ")";
    }
}
