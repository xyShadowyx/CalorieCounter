package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Entry {
    private boolean mIsDatabaseObject;
    private int mId;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mOrderInDay;

    /* static functions */
    public static int getNextOrderInDay() {
        return 0;
    }

    public Entry(int year, int month, int day) {
        mYear = year;
        mMonth = month;
        mDay = day;
        mIsDatabaseObject = false;
    }

    public Entry(Entry entry) {
        this(entry.getYear(), entry.getMonth(), entry.getDay());
    }

    public int getYear() {
        return mYear;
    }

    public int getMonth() {
        return mMonth;
    }

    public int getDay() {
        return mDay;
    }

    private void setToDatabaseObject() {
        mIsDatabaseObject = true;
    }

    private void setOrderInDay(int order) {
        mOrderInDay = order;
    }

    public int getOrderInDay() {
        return mOrderInDay;
    }
}
