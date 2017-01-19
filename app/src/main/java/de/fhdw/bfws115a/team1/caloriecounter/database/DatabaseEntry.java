package de.fhdw.bfws115a.team1.caloriecounter.database;


/**
 * This is a interface for entries in database
 *
 * @author Viktor Schroeder
 */
public interface DatabaseEntry extends DatabaseEntity, Comparable<DatabaseEntry> {
    String getName();

    double getAmount();

    void setAmount(double amount);

    String getUnitName();

    int getCalories();

    int getYear();

    int getMonth();

    int getDay();

    void setDate(int year, int month, int day);
}
