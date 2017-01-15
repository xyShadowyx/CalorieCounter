package de.fhdw.bfws115a.team1.caloriecounter.database;


/**
 * Created by xySha on 23.11.2016.
 */
public interface DatabaseEntry extends DatabaseEntity, Comparable<DatabaseEntry> {
    String getName();
    double getAmount();
    int getCalories();

    int getYear();
    int getMonth();
    int getDay();

    void setDate(int year, int month, int day);

    int compareTo(DatabaseEntry databaseEntry);
}
