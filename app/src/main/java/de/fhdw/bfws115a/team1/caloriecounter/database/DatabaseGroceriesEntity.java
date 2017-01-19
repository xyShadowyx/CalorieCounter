package de.fhdw.bfws115a.team1.caloriecounter.database;


/**
 * This is a generalisation class to handle DatabaseGrocery and DatabaseMenu together.
 *
 * @author Viktor Schroeder
 */
public interface DatabaseGroceriesEntity extends DatabaseEntity {
    /**
     * Get the name.
     * @return name
     */
    String getName();
}
