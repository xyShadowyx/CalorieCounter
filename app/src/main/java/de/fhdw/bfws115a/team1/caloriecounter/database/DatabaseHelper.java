package de.fhdw.bfws115a.team1.caloriecounter.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

/**
 * Created by Viktor on 15.11.2016.
 */



public class DatabaseHelper {
    private ConcurrentHashMap<Integer, Map.Entry> mEntries;
    private ConcurrentHashMap<Integer, Unit> mUnits;
    private ConcurrentHashMap<Integer, Menu> mMenus;
    private ConcurrentHashMap<Integer, Grocery> mGroceries;
}
