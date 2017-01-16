package de.fhdw.bfws115a.team1.caloriecounter.database;

import android.content.Context;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 18.11.2016.
 */
public class DatabaseEntityManager {
    private DatabaseHelper mDatabaseHelper;

    public DatabaseEntityManager(Context context) {
        mDatabaseHelper = new DatabaseHelper(context);
    }

    /* Manage Groceries */
    public DatabaseGrocery createGrocery(Grocery grocery) {
        return mDatabaseHelper.createGrocery(grocery);
    }

    public boolean saveGrocery(DatabaseGrocery databaseGrocery) {
        return mDatabaseHelper.saveGrocery(databaseGrocery);
    }

    public boolean deleteGrocery(DatabaseGrocery databaseGrocery) {
        return mDatabaseHelper.deleteGrocery(databaseGrocery);
    }

    public DatabaseGrocery getGrocery(long groceryId) {
        return mDatabaseHelper.loadGrocery(groceryId);
    }

    public List<DatabaseGrocery> getAllGroceries() {
        return mDatabaseHelper.getAllGroceries();
    }

    public List<DatabaseGrocery> getGroceriesContains(String name) {
        return mDatabaseHelper.getGroceriesContains(name);
    }

    public boolean isGroceryNameAvailable(String name) {
        return mDatabaseHelper.isGroceryNameAvailable(name);
    }


    /* Manage GroceryEntries */
    public DatabaseGroceryEntry createGroceryEntry(GroceryEntry groceryEntry) {
        return mDatabaseHelper.createGroceryEntry(groceryEntry);
    }

    public boolean saveGroceryEntry(DatabaseGroceryEntry databaseGroceryEntry) {
        return mDatabaseHelper.saveGroceryEntry(databaseGroceryEntry);
    }

    public boolean deleteGroceryEntry(DatabaseGroceryEntry databaseGroceryEntry) {
        return mDatabaseHelper.deleteGroceryEntry(databaseGroceryEntry);
    }

    public DatabaseGroceryEntry getGroceryEntry(long groceryEntryId) {
        return mDatabaseHelper.loadGroceryEntry(groceryEntryId);
    }

    public List<DatabaseGroceryEntry> getAllGroceryEntries() {
        return mDatabaseHelper.getAllGroceryEntries();
    }

    public List<DatabaseGroceryEntry> getGroceryEntriesOf(int year, int month, int day) {
        return mDatabaseHelper.getGroceryEntriesOf(year, month, day);
    }

    /* Menu */
    public DatabaseMenu createMenu(Menu menu) {
        return mDatabaseHelper.createMenu(menu);
    }

    public boolean saveMenu(DatabaseMenu databaseMenu) {
        return mDatabaseHelper.saveMenu(databaseMenu);
    }

    public boolean deleteMenu(DatabaseMenu databaseMenu) {
        return mDatabaseHelper.deleteMenu(databaseMenu);
    }

    public DatabaseMenu getMenu(long menuId) {
        return mDatabaseHelper.loadMenu(menuId);
    }

    public List<DatabaseMenu> getAllMenus() {
        return mDatabaseHelper.getAllMenus();
    }

    public List<DatabaseMenu> getMenusContains(String name) {
        return mDatabaseHelper.getMenusContains(name);
    }

    public boolean isMenuNameAvailable(String name) {
        return mDatabaseHelper.isMenuNameAvailable(name);
    }

    /* Manage MenuEntries */
    public DatabaseMenuEntry createMenuEntry(MenuEntry menuEntry) {
        return mDatabaseHelper.createMenuEntry(menuEntry);
    }

    public boolean saveMenuEntry(DatabaseMenuEntry databaseMenuEntry) {
        return mDatabaseHelper.saveMenuEntry(databaseMenuEntry);
    }

    public boolean deleteMenuEntry(DatabaseMenuEntry databaseMenuEntry) {
        return mDatabaseHelper.deleteMenuEntry(databaseMenuEntry);
    }

    public DatabaseMenuEntry getMenuEntry(long menuEntryId) {
        return mDatabaseHelper.loadMenuEntry(menuEntryId);
    }

    public List<DatabaseMenuEntry> getAllMenuEntries() {
        return mDatabaseHelper.getAllMenuEntries();
    }

    public List<DatabaseMenuEntry> getMenuEntriesOf(int year, int month, int day) {
        return mDatabaseHelper.getMenuEntriesOf(year, month, day);
    }

    /* Manage Units */
    public DatabaseUnit createUnit(Unit unit) {
        return mDatabaseHelper.createUnit(unit);
    }

    public boolean saveUnit(DatabaseUnit databaseUnit) {
        return mDatabaseHelper.saveUnit(databaseUnit);
    }

    public boolean deleteUnit(DatabaseUnit databaseUnit) {
        return mDatabaseHelper.deleteUnit(databaseUnit);
    }

    public DatabaseUnit getUnit(long unitId) {
        return mDatabaseHelper.loadUnit(unitId);
    }

    public List<DatabaseUnit> getAllUnits() {
        return mDatabaseHelper.getAllUnits();
    }

    public boolean isUnitNameAvailable(String name) {
        return mDatabaseHelper.isUnitNameAvailable(name);
    }

    /* Get Entiries*/
    public ArrayList<DatabaseEntry> getEntriesOf(int year, int month, int day)  {
        return mDatabaseHelper.getEntriesOf(year, month, day);
    }
}
