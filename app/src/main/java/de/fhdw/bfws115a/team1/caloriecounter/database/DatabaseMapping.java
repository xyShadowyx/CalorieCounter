package de.fhdw.bfws115a.team1.caloriecounter.database;

import java.util.concurrent.ConcurrentHashMap;

import de.fhdw.bfws115a.team1.caloriecounter.entities.Entry;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryEntry;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.MenuEntry;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

/**
 * Created by Viktor on 16.11.2016.
 */

public class DatabaseMapping {
    private static ConcurrentHashMap<Integer, GroceryEntry> mGroceryEntries;
    private static int mGroceryEntriesIncrement;

    private static ConcurrentHashMap<Integer, MenuEntry> mMenuEntries;
    private static int mMenuEntriesIncrement;

    private static ConcurrentHashMap<Integer, Unit> mUnits;
    private static int mUnitsIncrement;

    private static ConcurrentHashMap<Integer, Menu> mMenus;
    private static int mMenusIncrement;

    private static ConcurrentHashMap<Integer, Grocery> mGroceries;
    private static int mGroceriesIncrement;

    public static void initialize() {
        mGroceryEntries = new ConcurrentHashMap<Integer, GroceryEntry>();
        mGroceryEntriesIncrement = 0;

        mMenuEntries = new ConcurrentHashMap<Integer, MenuEntry>();
        mMenuEntriesIncrement = 0;

        mUnits = new ConcurrentHashMap<Integer, Unit>();
        mUnitsIncrement = 0;

        mMenus = new ConcurrentHashMap<Integer, Menu>();
        mMenusIncrement = 0;

        mGroceries = new ConcurrentHashMap<Integer, Grocery>();
        mGroceriesIncrement = 0;
    }

    public static int insertGroceryEntry(GroceryEntry groceryEntry) {
        mGroceryEntries.put(++mGroceryEntriesIncrement, groceryEntry);
        return mGroceryEntriesIncrement;
    }

    public static int insertMenuEntry(MenuEntry menuEntry) {
        mMenuEntries.put(++mMenuEntriesIncrement, new MenuEntry(menuEntry));
        return mMenuEntriesIncrement;
    }

    public static int insertUnit(Unit unit) {
        mUnits.put(++mUnitsIncrement, new Unit(unit));
        return mUnitsIncrement;
    }

    public static int insertMenu(Menu menu) {
        mMenus.put(++mMenusIncrement, new Menu(menu));
        return mMenusIncrement;
    }

    public static int insertGrocery(Grocery grocery) {
        mGroceries.put(++mMenusIncrement, new Grocery(grocery));
        return mGroceriesIncrement;
    }
}
