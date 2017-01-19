package de.fhdw.bfws115a.team1.caloriecounter.database;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

/**
 * This class represents a unit in database.
 *
 * @author Viktor Schroeder
 */
public class DatabaseUnit extends Unit implements DatabaseEntity {
    /* Member variables */
    private long mId;

    /**
     * Constructor
     * Is package-private to prevent wrong usage
     *
     * @param name name of unit
     * @param id id of unit in database
     */
    DatabaseUnit(String name, long id) {
        super(name);
        mId = id;
    }

    /**
     * Get the ID of unit in database.
     *
     * @return ID
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Converts this object to a readable output
     *
     * @return this object as a text
     */
    public String toString() {
        return "DatabaseUnit(Id: " + getId() +", Unit: " + super.toString() + ")";
    }
}
