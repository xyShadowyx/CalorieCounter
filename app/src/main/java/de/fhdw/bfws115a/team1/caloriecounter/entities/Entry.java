package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is a generalisation class for entries to a specific date
 *
 * @author Viktor Schroeder
 */

public class Entry implements Serializable {
    /* Member variables */
    private int mYear;
    private int mMonth;
    private int mDay;

    /**
     * Constructor
     *
     * @param year year of entry
     * @param month month of entry
     * @param day day of month of entry
     */
    public Entry(int year, int month, int day) {
        mYear = year;
        mMonth = month;
        mDay = day;
    }

    /**
     * Constructor for copies
     *
     * @param entry to copy entry
     */
    public Entry(Entry entry) {
        this(entry.getYear(), entry.getMonth(), entry.getDay());
    }

    /**
     * Get the year of entry
     *
     * @return number of year
     */
    public int getYear() {
        return mYear;
    }

    /**
     * Get the month of entry
     *
     * @return number of month
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * Get the day of month of entry
     *
     * @return number of day of month
     */
    public int getDay() {
        return mDay;
    }

    /**
     * Set the date for entry
     *
     * @param year new year
     * @param month new month
     * @param day new day
     */
    public void setDate(int year, int month, int day) {
        mYear = year;
        mMonth = month;
        mDay = day;
    }

    /**
     * Converts this object to a readable output
     *
     * @return this object as a text
     */
    public String toString() {
        return "Entry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ")";
    }
}
