package de.fhdw.bfws115a.team1.caloriecounter.database;


/**
 * This is a interface for entries in database
 *
 * @author Viktor Schroeder
 */
public interface DatabaseEntry extends DatabaseEntity, Comparable<DatabaseEntry> {
    String getName();
    double getAmount();
    String getUnitName();
    void setAmount(double amount);
    int getCalories();

    int getYear();
    int getMonth();
    int getDay();

    void setDate(int year, int month, int day);
}
