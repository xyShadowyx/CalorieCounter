package de.fhdw.bfws115a.team1.caloriecounter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Viktor on 15.11.2016.
 *
 * DatabaseHelper handles the database
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * TODO: add close method after using cursor
     * TODO: comprimize getAll methods by adding where clause
     */

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "database.db";

    public final static int SHORT_NAME_LENGTH = 16;
    public final static int MEDIUM_NAME_LENGTH = 32;
    public final static int LONG_NAME_LENGTH = 64;

    private final static String TABLE_GROCERY = "grocery";
    private final static String GROCERY_ID = "id";
    private final static String GROCERY_NAME = "name";
    private final static String GROCERY_KCAL = "kcal";

    private final static String TABLE_GROCERY_UNITS = "grocery_units";
    private final static String GROCERY_UNITS_GROCERY_ID = "grocery_id";
    private final static String GROCERY_UNITS_UNIT = "unit";
    private final static String GROCERY_UNITS_AMOUNT = "amount";

    private final static String TABLE_GROCERY_ENTRY = "grocery_entry";
    private final static String GROCERY_ENTRY_ID = "id";
    private final static String GROCERY_ENTRY_NAME = "name";
    private final static String GROCERY_ENTRY_DATE = "date";
    private final static String GROCERY_ENTRY_UNIT = "unit";
    private final static String GROCERY_ENTRY_AMOUNT = "amount";
    private final static String GROCERY_ENTRY_KCAL = "kcal";

    private final static String TABLE_MENU = "menu";
    private final static String MENU_ID = "id";
    private final static String MENU_NAME = "name";
    private final static String MENU_PORTIONS = "portions";

    private final static String TABLE_MENU_GROCERY = "menu_grocery";
    private final static String MENU_GROCERY_ID = "id";
    private final static String MENU_GROCERY_MENU_ID = "menu_id";
    private final static String MENU_GROCERY_NAME = "name";
    private final static String MENU_GROCERY_UNIT = "unit";
    private final static String MENU_GROCERY_AMOUNT = "amount";
    private final static String MENU_GROCERY_KCAL = "kcal";

    private final static String TABLE_MENU_ENTRY = "menu_entry";
    private final static String MENU_ENTRY_ID = "id";
    private final static String MENU_ENTRY_NAME = "name";
    private final static String MENU_ENTRY_DATE = "date";
    private final static String MENU_ENTRY_PORTIONS = "portions";

    private final static String TABLE_MENU_ENTRY_GROCERY = "menu_entry_grocery";
    private final static String MENU_ENTRY_GROCERY_ID = "id";
    private final static String MENU_ENTRY_GROCERY_MENU_ENTRY_ID = "menu_entry_id";
    private final static String MENU_ENTRY_GROCERY_NAME = "name";
    private final static String MENU_ENTRY_GROCERY_UNIT = "unit";
    private final static String MENU_ENTRY_GROCERY_AMOUNT = "amount";
    private final static String MENU_ENTRY_GROCERY_KCAL = "kcal";

    private final static String TABLE_UNIT = "unit";
    private final static String UNIT_ID = "id";
    private final static String UNIT_NAME = "name";

    private static final String CREATE_TABLE_GROCERY = "CREATE TABLE "
            + TABLE_GROCERY + "("
            + GROCERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + GROCERY_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + GROCERY_KCAL + " INTEGER"
            + ");";

    private static final String CREATE_TABLE_GROCERY_UNITS = "CREATE TABLE "
            + TABLE_GROCERY_UNITS + "("
            + GROCERY_UNITS_GROCERY_ID + " INTEGER,"
            + GROCERY_UNITS_UNIT + " VARCHAR (" + SHORT_NAME_LENGTH + "),"
            + GROCERY_UNITS_AMOUNT + " DOUBLE,"
            + "PRIMARY KEY (" + GROCERY_UNITS_GROCERY_ID
            + "," + GROCERY_UNITS_UNIT
            + "," + GROCERY_UNITS_AMOUNT
            + "));";

    private static final String CREATE_TABLE_GROCERY_ENTRY = "CREATE TABLE "
            + TABLE_GROCERY_ENTRY + "("
            + GROCERY_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + GROCERY_ENTRY_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + GROCERY_ENTRY_DATE + " DATE,"
            + GROCERY_ENTRY_UNIT + " VARCHAR (" + SHORT_NAME_LENGTH + "),"
            + GROCERY_ENTRY_AMOUNT + " DOUBLE,"
            + GROCERY_ENTRY_KCAL + " INTEGER"
            + ");";

    private static final String CREATE_TABLE_MENU = "CREATE TABLE "
            + TABLE_MENU + "("
            + MENU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MENU_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + MENU_PORTIONS + " DOUBLE"
            + ");";

    private static final String CREATE_TABLE_MENU_GROCERY = "CREATE TABLE "
            + TABLE_MENU_GROCERY + "("
            + MENU_GROCERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MENU_GROCERY_MENU_ID + " INTEGER REFERENCES " + TABLE_MENU + " (" + MENU_ID + "),"
            + MENU_GROCERY_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + MENU_GROCERY_UNIT + " VARCHAR (" + SHORT_NAME_LENGTH + "),"
            + MENU_GROCERY_AMOUNT + " DOUBLE,"
            + MENU_GROCERY_KCAL + " INTEGER"
            + ");";

    private static final String CREATE_TABLE_MENU_ENTRY = "CREATE TABLE "
            + TABLE_MENU_ENTRY + "("
            + MENU_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MENU_ENTRY_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + MENU_ENTRY_DATE + " DATE,"
            + MENU_ENTRY_PORTIONS + " DOUBLE"
            + ");";

    private static final String CREATE_TABLE_MENU_ENTRY_GROCERY = "CREATE TABLE "
            + TABLE_MENU_ENTRY_GROCERY + "("
            + MENU_ENTRY_GROCERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MENU_ENTRY_GROCERY_MENU_ENTRY_ID + " INTEGER REFERENCES " + TABLE_MENU_ENTRY + " (" + MENU_ENTRY_ID + "),"
            + MENU_ENTRY_GROCERY_NAME + " VARCHAR (" + MEDIUM_NAME_LENGTH + "),"
            + MENU_ENTRY_GROCERY_UNIT + " VARCHAR (" + SHORT_NAME_LENGTH + "),"
            + MENU_ENTRY_GROCERY_AMOUNT + " DOUBLE,"
            + MENU_ENTRY_GROCERY_KCAL + " INTEGER"
            + ");";

    private static final String CREATE_TABLE_UNIT = "CREATE TABLE "
            + TABLE_UNIT + "("
            + UNIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UNIT_NAME + " VARCHAR (" + SHORT_NAME_LENGTH + ")"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_GROCERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_GROCERY_UNITS);
        sqLiteDatabase.execSQL(CREATE_TABLE_GROCERY_ENTRY);
        sqLiteDatabase.execSQL(CREATE_TABLE_MENU);
        sqLiteDatabase.execSQL(CREATE_TABLE_MENU_GROCERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_MENU_ENTRY);
        sqLiteDatabase.execSQL(CREATE_TABLE_MENU_ENTRY_GROCERY);
        sqLiteDatabase.execSQL(CREATE_TABLE_UNIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_UNITS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GROCERY_ENTRY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU_GROCERY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU_ENTRY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU_ENTRY_GROCERY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIT);

        onCreate(sqLiteDatabase);
    }

    /* Grocery Methods */
    public DatabaseGrocery createGrocery(Grocery grocery) {
        SQLiteDatabase database;
        ContentValues values;
        long groceryId;
        DatabaseGrocery databaseGrocery;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(GROCERY_NAME, grocery.getName());
        values.put(GROCERY_KCAL, grocery.getKcal());

        groceryId = database.insert(TABLE_GROCERY, null, values);

        databaseGrocery = new DatabaseGrocery(
                grocery.getName(),
                grocery.getKcal(),
                groceryId
        );

        for (GroceryUnit gu : grocery.getGroceryUnits()) {
            values = new ContentValues();
            values.put(GROCERY_UNITS_GROCERY_ID, databaseGrocery.getId());
            values.put(GROCERY_UNITS_UNIT, gu.getUnit().getName());
            values.put(GROCERY_UNITS_AMOUNT, gu.getAmount());

            database.insert(TABLE_GROCERY_UNITS, null, values);
            databaseGrocery.addGroceryUnit(new GroceryUnit(gu));
        }

        return databaseGrocery;
    }

    public boolean saveGrocery(DatabaseGrocery databaseGrocery) {
        SQLiteDatabase database;
        ContentValues values;

        database = this.getWritableDatabase();
        database.delete(
                TABLE_GROCERY_UNITS,
                GROCERY_UNITS_GROCERY_ID + " = ?",
                new String[]{String.valueOf(databaseGrocery.getId())}
        );

        for (GroceryUnit gu : databaseGrocery.getGroceryUnits()) {
            values = new ContentValues();
            values.put(GROCERY_UNITS_GROCERY_ID, databaseGrocery.getId());
            values.put(GROCERY_UNITS_UNIT, gu.getUnit().getName());
            values.put(GROCERY_UNITS_AMOUNT, gu.getAmount());

            database.insert(TABLE_GROCERY_UNITS, null, values);
        }

        values = new ContentValues();
        values.put(GROCERY_NAME, databaseGrocery.getName());
        values.put(GROCERY_KCAL, databaseGrocery.getKcal());
        return database.update(TABLE_GROCERY, values, GROCERY_ID + "=" + databaseGrocery.getId(), null) > 0;
    }

    public DatabaseGrocery loadGrocery(long groceryId) {
        SQLiteDatabase database;
        String selectQuery;
        Cursor cursor;
        DatabaseGrocery databaseGrocery;

        database = this.getReadableDatabase();

        selectQuery = "SELECT * FROM " + TABLE_GROCERY + " WHERE " + GROCERY_ID + " = " + groceryId;
        cursor = database.rawQuery(selectQuery, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        databaseGrocery = new DatabaseGrocery(
                cursor.getString(cursor.getColumnIndex(GROCERY_NAME)),
                cursor.getInt(cursor.getColumnIndex(GROCERY_KCAL)),
                cursor.getInt(cursor.getColumnIndex(GROCERY_ID))
        );
        cursor.close();

        selectQuery = "SELECT * FROM " + TABLE_GROCERY_UNITS + " WHERE " + GROCERY_UNITS_GROCERY_ID + " = " + databaseGrocery.getId();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    databaseGrocery.addGroceryUnit(
                            new GroceryUnit(
                                    new Unit(cursor.getString(cursor.getColumnIndex(GROCERY_UNITS_UNIT))),
                                    cursor.getDouble(cursor.getColumnIndex(GROCERY_UNITS_AMOUNT))
                            )
                    );
                } while (cursor.moveToNext());
            }
        }
        return databaseGrocery;
    }

    public boolean deleteGrocery(DatabaseGrocery databaseGrocery) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(
                TABLE_GROCERY_UNITS,
                GROCERY_UNITS_GROCERY_ID + " = ?",
                new String[]{String.valueOf(databaseGrocery.getId())});

        return database.delete(
                TABLE_GROCERY,
                GROCERY_ID + " = ?",
                new String[]{String.valueOf(databaseGrocery.getId())}
        ) > 0;
    }

    public List<DatabaseGrocery> getGroceries(String whereClause) {
        List<DatabaseGrocery> databaseGroceries;
        String selectQuery;
        SQLiteDatabase database;
        Cursor cursor;
        Cursor cursorGroceryUnits;

        DatabaseGrocery databaseGrocery;

        databaseGroceries = new ArrayList<DatabaseGrocery>();
        selectQuery = "SELECT  * FROM " + TABLE_GROCERY;

        if (whereClause.length() > 0) selectQuery += " WHERE " + whereClause;

        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                databaseGrocery = new DatabaseGrocery(
                        cursor.getString(cursor.getColumnIndex(GROCERY_NAME)),
                        cursor.getInt(cursor.getColumnIndex(GROCERY_KCAL)),
                        cursor.getInt(cursor.getColumnIndex(GROCERY_ID)));

                selectQuery = "SELECT * FROM " + TABLE_GROCERY_UNITS + " WHERE " + GROCERY_UNITS_GROCERY_ID + " = " + databaseGrocery.getId();
                cursorGroceryUnits = database.rawQuery(selectQuery, null);

                if (cursorGroceryUnits.moveToFirst()) {
                    do {
                        databaseGrocery.addGroceryUnit(new GroceryUnit(
                                new Unit(cursorGroceryUnits.getString(cursorGroceryUnits.getColumnIndex(GROCERY_UNITS_UNIT))),
                                cursorGroceryUnits.getDouble(cursorGroceryUnits.getColumnIndex(GROCERY_UNITS_AMOUNT))
                        ));
                    }while (cursorGroceryUnits.moveToNext());
                }
                databaseGroceries.add(databaseGrocery);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return databaseGroceries;
    }

    public List<DatabaseGrocery> getAllGroceries() {
        return getGroceries("");
    }

    public List<DatabaseGrocery> getGroceriesContains(String name) {
        return getGroceries(GROCERY_NAME + " LIKE " + DatabaseUtils.sqlEscapeString("%" + name + "%"));
    }

    public boolean isGroceryNameAvailable(String name) {
        return getGroceries(GROCERY_NAME + " = " + DatabaseUtils.sqlEscapeString(name)).size() == 0;
    }

    /* GroceryEntry Methods */
    public DatabaseGroceryEntry createGroceryEntry(GroceryEntry groceryEntry) {
        SQLiteDatabase database;
        ContentValues values;
        long groceryEntryId;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(GROCERY_ENTRY_NAME, groceryEntry.getFixGrocery().getName());
        values.put(GROCERY_ENTRY_DATE, groceryEntry.getYear() + "-" + groceryEntry.getMonth() + "-" + groceryEntry.getDay());
        values.put(GROCERY_ENTRY_UNIT, groceryEntry.getFixGrocery().getUnit().getName());
        values.put(GROCERY_ENTRY_AMOUNT, groceryEntry.getFixGrocery().getAmount());
        values.put(GROCERY_ENTRY_KCAL, groceryEntry.getFixGrocery().getKcal());

        groceryEntryId = database.insert(TABLE_GROCERY_ENTRY, null, values);
        return new DatabaseGroceryEntry(
                groceryEntry.getYear(),
                groceryEntry.getMonth(),
                groceryEntry.getDay(),
                new FixGrocery(groceryEntry.getFixGrocery()),
                groceryEntryId
        );
    }

    public boolean saveGroceryEntry(DatabaseGroceryEntry databaseGroceryEntry) {
        SQLiteDatabase database;
        ContentValues values;

        database = this.getWritableDatabase();
        values = new ContentValues();

        values.put(GROCERY_ENTRY_NAME, databaseGroceryEntry.getFixGrocery().getName());
        values.put(GROCERY_ENTRY_DATE, databaseGroceryEntry.getYear() + "-" + databaseGroceryEntry.getMonth() + "-" + databaseGroceryEntry.getDay());
        values.put(GROCERY_ENTRY_UNIT, databaseGroceryEntry.getFixGrocery().getUnit().getName());
        values.put(GROCERY_ENTRY_AMOUNT, databaseGroceryEntry.getFixGrocery().getAmount());
        values.put(GROCERY_ENTRY_KCAL, databaseGroceryEntry.getFixGrocery().getKcal());

        return database.update(TABLE_GROCERY_ENTRY, values, GROCERY_ENTRY_ID + "=" + databaseGroceryEntry.getId(), null) > 0;
    }

    public DatabaseGroceryEntry loadGroceryEntry(long groceryEntryId) {
        SQLiteDatabase database;
        String selectQuery;
        Cursor cursor;
        String[] dateSplit;
        int year, month, day;
        DatabaseGroceryEntry databaseGroceryEntry;

        database = this.getReadableDatabase();
        selectQuery = "SELECT * FROM " + TABLE_GROCERY_ENTRY + " WHERE " + GROCERY_ENTRY_ID + " = " + groceryEntryId;
        cursor = database.rawQuery(selectQuery, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        dateSplit = cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_DATE)).split("-", 3);
        year = Integer.parseInt(dateSplit[0]);
        month = Integer.parseInt(dateSplit[1]);
        day = Integer.parseInt(dateSplit[2]);

        databaseGroceryEntry = new DatabaseGroceryEntry(
                year,
                month,
                day,
                new FixGrocery(
                        cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_NAME)),
                        new Unit(cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_UNIT))),
                        cursor.getDouble(cursor.getColumnIndex(GROCERY_ENTRY_AMOUNT)),
                        cursor.getInt(cursor.getColumnIndex(GROCERY_ENTRY_KCAL))
                ),
                groceryEntryId
        );

        cursor.close();
        return databaseGroceryEntry;
    }

    public boolean deleteGroceryEntry(DatabaseGroceryEntry databaseGroceryEntry) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_GROCERY_ENTRY,
                GROCERY_ENTRY_ID + " = ?",
                new String[]{String.valueOf(databaseGroceryEntry.getId())}
        ) > 0;
    }

    public List<DatabaseGroceryEntry> getGroceryEntries(String whereClause) {
        List<DatabaseGroceryEntry> databaseGroceryEntries;
        String selectQuery;
        SQLiteDatabase database;
        Cursor cursor;
        String[] dateSplit;
        int year, month, day;

        databaseGroceryEntries = new ArrayList<DatabaseGroceryEntry>();
        selectQuery = "SELECT  * FROM " + TABLE_GROCERY_ENTRY;
        if (whereClause.length() > 0) selectQuery += " WHERE " + whereClause;

        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                dateSplit = cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_DATE)).split("-", 3);
                year = Integer.parseInt(dateSplit[0]);
                month = Integer.parseInt(dateSplit[1]);
                day = Integer.parseInt(dateSplit[2]);

                databaseGroceryEntries.add(
                        new DatabaseGroceryEntry(
                                year,
                                month,
                                day,
                                new FixGrocery(
                                        cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_NAME)),
                                        new Unit(cursor.getString(cursor.getColumnIndex(GROCERY_ENTRY_UNIT))),
                                        cursor.getDouble(cursor.getColumnIndex(GROCERY_ENTRY_AMOUNT)),
                                        cursor.getInt(cursor.getColumnIndex(GROCERY_ENTRY_KCAL))
                                ),
                                cursor.getInt(cursor.getColumnIndex(GROCERY_ENTRY_ID))
                        )
                );
            } while (cursor.moveToNext());
        }

        cursor.close();
        return databaseGroceryEntries;
    }

    public List<DatabaseGroceryEntry> getAllGroceryEntries() {
        return getGroceryEntries("");
    }

    public List<DatabaseGroceryEntry> getGroceryEntriesOf(int year, int month, int day) {
        return getGroceryEntries(GROCERY_ENTRY_DATE + " = '" + year + "-" + month + "-" + day + "'");
    }

    /* Menu Methods */
    public DatabaseMenu createMenu(Menu menu) {
        SQLiteDatabase database;
        ContentValues values;
        DatabaseMenu databaseMenu;
        long menuId;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(MENU_NAME, menu.getName());
        values.put(MENU_PORTIONS, menu.getAmount());

        menuId = database.insert(TABLE_MENU, null, values);

        databaseMenu = new DatabaseMenu(menu.getName(), menu.getAmount(), menuId);
        for (FixGrocery fg : menu.getFixGroceries()) {
            values = new ContentValues();
            values.put(MENU_GROCERY_MENU_ID, menuId);
            values.put(MENU_GROCERY_NAME, fg.getName());
            values.put(MENU_GROCERY_UNIT, fg.getUnit().getName());
            values.put(MENU_GROCERY_AMOUNT, fg.getAmount());
            values.put(MENU_GROCERY_KCAL, fg.getKcal());

            database.insert(TABLE_MENU_GROCERY, null, values);
            databaseMenu.addGrocery(new FixGrocery(fg));
        }
        return databaseMenu;
    }

    public DatabaseMenu loadMenu(long menuId) {
        SQLiteDatabase database;
        String selectQuery;
        Cursor cursor;
        DatabaseMenu databaseMenu;

        database = this.getReadableDatabase();

        selectQuery = "SELECT * FROM " + TABLE_MENU + " WHERE " + MENU_ID + " = " + menuId;
        cursor = database.rawQuery(selectQuery, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        databaseMenu = new DatabaseMenu(
                cursor.getString(cursor.getColumnIndex(MENU_NAME)),
                cursor.getDouble(cursor.getColumnIndex(MENU_PORTIONS)),
                cursor.getInt(cursor.getColumnIndex(MENU_ID))
        );

        selectQuery = "SELECT * FROM " + TABLE_MENU_GROCERY + " WHERE " + MENU_GROCERY_MENU_ID + " = " + databaseMenu.getId();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                databaseMenu.addGrocery(
                        new FixGrocery(
                                cursor.getString(cursor.getColumnIndex(MENU_GROCERY_NAME)),
                                new Unit(cursor.getString(cursor.getColumnIndex(MENU_GROCERY_UNIT))),
                                cursor.getInt(cursor.getColumnIndex(MENU_GROCERY_AMOUNT)),
                                cursor.getInt(cursor.getColumnIndex(MENU_GROCERY_KCAL))
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        return databaseMenu;
    }

    public boolean saveMenu(DatabaseMenu databaseMenu) {
        SQLiteDatabase database;
        ContentValues values;
        int result;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(MENU_NAME, databaseMenu.getName());
        values.put(MENU_PORTIONS, databaseMenu.getAmount());

        result = database.update(TABLE_MENU, values, MENU_ID + "=" + databaseMenu.getId(), null);
        if (result == 0) return false;

        database.delete(TABLE_MENU_GROCERY, MENU_GROCERY_MENU_ID + " = ?", new String[]{String.valueOf(databaseMenu.getId())});
        for (FixGrocery fg : databaseMenu.getFixGroceries()) {
            values = new ContentValues();
            values.put(MENU_GROCERY_MENU_ID, databaseMenu.getId());
            values.put(MENU_GROCERY_NAME, fg.getName());
            values.put(MENU_GROCERY_UNIT, fg.getUnit().getName());
            values.put(MENU_GROCERY_AMOUNT, fg.getAmount());
            values.put(MENU_GROCERY_KCAL, fg.getKcal());

            database.insert(TABLE_MENU_GROCERY, null, values);
        }
        return result > 0;
    }

    public boolean deleteMenu(DatabaseMenu databaseMenu) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_MENU_GROCERY, MENU_GROCERY_MENU_ID + " = ?", new String[]{String.valueOf(databaseMenu.getId())});
        return database.delete(
                TABLE_MENU,
                MENU_ID + " = ?",
                new String[]{String.valueOf(databaseMenu.getId())}
        ) > 0;
    }

    public List<DatabaseMenu> getMenus(String whereClause) {
        List<DatabaseMenu> databaseMenus = new ArrayList<DatabaseMenu>();
        String selectQuery = "SELECT  * FROM " + TABLE_MENU;
        if (whereClause.length() > 0) selectQuery += " WHERE " + whereClause;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        DatabaseMenu databaseMenu;
        Cursor menuGroceriesCursor;
        if (cursor.moveToFirst()) {
            do {
                databaseMenu = new DatabaseMenu(
                        cursor.getString(cursor.getColumnIndex(MENU_NAME)),
                        cursor.getDouble(cursor.getColumnIndex(MENU_PORTIONS)),
                        cursor.getInt(cursor.getColumnIndex(MENU_ID))
                );

                selectQuery = "SELECT * FROM " + TABLE_MENU_GROCERY + " WHERE " + MENU_GROCERY_MENU_ID + " = " + databaseMenu.getId();
                menuGroceriesCursor = database.rawQuery(selectQuery, null);

                if (menuGroceriesCursor.moveToFirst()) {
                    do {
                        databaseMenu.addGrocery(
                                new FixGrocery(
                                        menuGroceriesCursor.getString(menuGroceriesCursor.getColumnIndex(MENU_GROCERY_NAME)),
                                        new Unit(menuGroceriesCursor.getString(menuGroceriesCursor.getColumnIndex(MENU_GROCERY_UNIT))),
                                        menuGroceriesCursor.getInt(menuGroceriesCursor.getColumnIndex(MENU_GROCERY_AMOUNT)),
                                        menuGroceriesCursor.getInt(menuGroceriesCursor.getColumnIndex(MENU_GROCERY_KCAL))
                                )
                        );
                    } while (menuGroceriesCursor.moveToNext());
                }

                databaseMenus.add(databaseMenu);
            } while (cursor.moveToNext());
        }

        return databaseMenus;
    }

    public List<DatabaseMenu> getAllMenus() {
        return getMenus("");
    }

    public List<DatabaseMenu> getMenusContains(String name) {
        return getMenus(MENU_NAME + " = " + DatabaseUtils.sqlEscapeString(name));
    }

    public boolean isMenuNameAvailable(String name) {
        return getMenus(MENU_NAME + " = " + DatabaseUtils.sqlEscapeString(name)).size() == 0;
    }

    /* MenuEntry Methods */
    public DatabaseMenuEntry createMenuEntry(MenuEntry menuEntry) {
        SQLiteDatabase database;
        ContentValues values;
        DatabaseMenuEntry databaseMenuEntry;
        long menuEntryId;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(MENU_ENTRY_NAME, menuEntry.getMenu().getName());
        values.put(MENU_ENTRY_DATE, menuEntry.getYear() + "-" + menuEntry.getMonth() + "-" + menuEntry.getDay());
        values.put(MENU_ENTRY_PORTIONS, menuEntry.getMenu().getAmount());

        menuEntryId = database.insert(TABLE_MENU_ENTRY, null, values);
        databaseMenuEntry = new DatabaseMenuEntry(menuEntry.getYear(), menuEntry.getMonth(), menuEntry.getDay(), new Menu(menuEntry.getMenu()), menuEntryId);
        for (FixGrocery fg : menuEntry.getMenu().getFixGroceries()) {
            values = new ContentValues();
            values.put(MENU_ENTRY_GROCERY_MENU_ENTRY_ID, menuEntryId);
            values.put(MENU_ENTRY_GROCERY_NAME, fg.getName());
            values.put(MENU_ENTRY_GROCERY_UNIT, fg.getUnit().getName());
            values.put(MENU_ENTRY_GROCERY_AMOUNT, fg.getAmount());
            values.put(MENU_ENTRY_GROCERY_KCAL, fg.getKcal());

            database.insert(TABLE_MENU_ENTRY_GROCERY, null, values);
            databaseMenuEntry.getMenu().addGrocery(new FixGrocery(fg));
        }
        return databaseMenuEntry;
    }

    public boolean saveMenuEntry(DatabaseMenuEntry databaseMenuEntry) {
        SQLiteDatabase database;
        ContentValues values;
        int result;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(MENU_ENTRY_NAME, databaseMenuEntry.getMenu().getName());
        values.put(MENU_ENTRY_DATE, databaseMenuEntry.getYear() + "-" + databaseMenuEntry.getMonth() + "-" + databaseMenuEntry.getDay());
        values.put(MENU_ENTRY_PORTIONS, databaseMenuEntry.getMenu().getAmount());

        result = database.update(TABLE_MENU_ENTRY, values, MENU_ENTRY_ID + "=" + databaseMenuEntry.getId(), null);
        if (result == 0) return false;

        database.delete(
                TABLE_MENU_ENTRY_GROCERY,
                MENU_ENTRY_GROCERY_MENU_ENTRY_ID + " = ?",
                new String[]{String.valueOf(databaseMenuEntry.getId())}
        );
        for (FixGrocery fg : databaseMenuEntry.getMenu().getFixGroceries()) {
            values = new ContentValues();
            values.put(MENU_ENTRY_GROCERY_MENU_ENTRY_ID, databaseMenuEntry.getId());
            values.put(MENU_ENTRY_GROCERY_NAME, fg.getName());
            values.put(MENU_ENTRY_GROCERY_UNIT, fg.getUnit().getName());
            values.put(MENU_ENTRY_GROCERY_AMOUNT, fg.getAmount());
            values.put(MENU_ENTRY_GROCERY_KCAL, fg.getKcal());

            database.insert(TABLE_MENU_ENTRY_GROCERY, null, values);
        }
        return true;
    }

    public boolean deleteMenuEntry(DatabaseMenuEntry databaseMenuEntry) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_MENU_ENTRY_GROCERY, MENU_ENTRY_GROCERY_MENU_ENTRY_ID + " = ?", new String[]{String.valueOf(databaseMenuEntry.getId())});
        return database.delete(
                TABLE_MENU_ENTRY,
                MENU_ENTRY_ID + " = ?",
                new String[]{String.valueOf(databaseMenuEntry.getId())}
        ) > 0;
    }

    public DatabaseMenuEntry loadMenuEntry(long menuEntryId) {
        SQLiteDatabase database;
        String selectQuery;
        Cursor cursor;
        String[] dateSplit;
        int year, month, day;
        DatabaseMenuEntry databaseMenuEntry;

        database = this.getReadableDatabase();

        selectQuery = "SELECT * FROM " + TABLE_MENU_ENTRY + " WHERE " + MENU_ENTRY_ID + " = " + menuEntryId;
        cursor = database.rawQuery(selectQuery, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        dateSplit = cursor.getString(cursor.getColumnIndex(MENU_ENTRY_DATE)).split("-", 3);
        year = Integer.parseInt(dateSplit[0]);
        month = Integer.parseInt(dateSplit[1]);
        day = Integer.parseInt(dateSplit[2]);

        databaseMenuEntry = new DatabaseMenuEntry(
                year,
                month,
                day,
                new Menu(
                        cursor.getString(cursor.getColumnIndex(MENU_ENTRY_NAME)),
                        cursor.getDouble(cursor.getColumnIndex(MENU_ENTRY_PORTIONS))
                ),
                cursor.getInt(cursor.getColumnIndex(MENU_ENTRY_ID))
        );
        cursor.close();

        selectQuery = "SELECT * FROM " + TABLE_MENU_ENTRY_GROCERY + " WHERE " + MENU_ENTRY_GROCERY_MENU_ENTRY_ID + " = " + databaseMenuEntry.getId();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                databaseMenuEntry.getMenu().addGrocery(
                        new FixGrocery(
                                cursor.getString(cursor.getColumnIndex(MENU_ENTRY_GROCERY_NAME)),
                                new Unit(cursor.getString(cursor.getColumnIndex(MENU_ENTRY_GROCERY_UNIT))),
                                cursor.getInt(cursor.getColumnIndex(MENU_ENTRY_GROCERY_AMOUNT)),
                                cursor.getInt(cursor.getColumnIndex(MENU_ENTRY_GROCERY_KCAL))
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        return databaseMenuEntry;
    }

    public List<DatabaseMenuEntry> getMenuEntries(String whereClause) {
        List<DatabaseMenuEntry> databaseMenuEntries;
        String selectQuery;
        SQLiteDatabase database;
        Cursor cursor;

        DatabaseMenuEntry databaseMenuEntry;
        Cursor menuEntryGroceriesCursor;

        String[] dateSplit;
        int year, month, day;

        databaseMenuEntries = new ArrayList<DatabaseMenuEntry>();
        selectQuery = "SELECT  * FROM " + TABLE_MENU_ENTRY;
        if (whereClause.length() > 0) selectQuery += " WHERE " + whereClause;

        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                dateSplit = cursor.getString(cursor.getColumnIndex(MENU_ENTRY_DATE)).split("-", 3);
                year = Integer.parseInt(dateSplit[0]);
                month = Integer.parseInt(dateSplit[1]);
                day = Integer.parseInt(dateSplit[2]);

                databaseMenuEntry = new DatabaseMenuEntry(
                        year,
                        month,
                        day,
                        new Menu(
                                cursor.getString(cursor.getColumnIndex(MENU_ENTRY_NAME)),
                                cursor.getDouble(cursor.getColumnIndex(MENU_ENTRY_PORTIONS))
                        ),
                        cursor.getInt(cursor.getColumnIndex(MENU_ENTRY_ID))
                );

                selectQuery = "SELECT * FROM " + TABLE_MENU_ENTRY_GROCERY + " WHERE " + MENU_ENTRY_GROCERY_MENU_ENTRY_ID + " = " + databaseMenuEntry.getId();
                menuEntryGroceriesCursor = database.rawQuery(selectQuery, null);

                if (menuEntryGroceriesCursor.moveToFirst()) {
                    do {
                        databaseMenuEntry.getMenu().addGrocery(
                                new FixGrocery(
                                        menuEntryGroceriesCursor.getString(menuEntryGroceriesCursor.getColumnIndex(MENU_GROCERY_NAME)),
                                        new Unit(menuEntryGroceriesCursor.getString(menuEntryGroceriesCursor.getColumnIndex(MENU_GROCERY_UNIT))),
                                        menuEntryGroceriesCursor.getInt(menuEntryGroceriesCursor.getColumnIndex(MENU_GROCERY_AMOUNT)),
                                        menuEntryGroceriesCursor.getInt(menuEntryGroceriesCursor.getColumnIndex(MENU_GROCERY_KCAL))
                                )
                        );
                    } while (menuEntryGroceriesCursor.moveToNext());
                }

                databaseMenuEntries.add(databaseMenuEntry);
            } while (cursor.moveToNext());
        }

        return databaseMenuEntries;
    }

    public List<DatabaseMenuEntry> getAllMenuEntries() {
        return getMenuEntries("");
    }

    public List<DatabaseMenuEntry> getMenuEntriesOf(int year, int month, int day) {
        return getMenuEntries(MENU_ENTRY_DATE + " = '" + year + "-" + month + "-" + day + "'");
    }

    /* Unit Methods */
    public DatabaseUnit createUnit(Unit unit) {
        SQLiteDatabase database;
        ContentValues values;
        long unitId;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(UNIT_NAME, unit.getName());

        unitId = database.insert(TABLE_UNIT, null, values);
        return new DatabaseUnit(unit.getName(), unitId);
    }

    public DatabaseUnit loadUnit(long unitId) {
        SQLiteDatabase database;
        String selectQuery;
        Cursor cursor;
        DatabaseUnit databaseUnit;

        database = this.getReadableDatabase();

        selectQuery = "SELECT * FROM " + TABLE_UNIT + " WHERE " + UNIT_ID + " = " + unitId;
        cursor = database.rawQuery(selectQuery, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        databaseUnit = new DatabaseUnit(
                cursor.getString(cursor.getColumnIndex(UNIT_NAME)),
                cursor.getInt(cursor.getColumnIndex(UNIT_ID))
        );

        cursor.close();
        return databaseUnit;
    }

    public boolean saveUnit(DatabaseUnit unit) {
        SQLiteDatabase database;
        ContentValues values;

        database = this.getWritableDatabase();

        values = new ContentValues();
        values.put(UNIT_NAME, unit.getName());

        return database.update(
                TABLE_UNIT,
                values,
                UNIT_ID + "=" + unit.getId(),
                null
        ) > 0;
    }

    public List<DatabaseUnit> getUnits(String whereClause) {
        List<DatabaseUnit> databaseUnits;
        String selectQuery;
        SQLiteDatabase database;
        Cursor cursor;

        databaseUnits = new ArrayList<DatabaseUnit>();
        selectQuery = "SELECT  * FROM " + TABLE_UNIT;
        if (whereClause.length() > 0) selectQuery += " WHERE " + whereClause;

        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                databaseUnits.add(new DatabaseUnit(cursor.getString(cursor.getColumnIndex(UNIT_NAME)),
                        cursor.getInt(cursor.getColumnIndex(UNIT_ID))));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return databaseUnits;
    }

    public List<DatabaseUnit> getAllUnits() {
        return getUnits("");
    }

    public boolean deleteUnit(DatabaseUnit databaseUnit) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(
                TABLE_UNIT,
                UNIT_ID + " = ?",
                new String[]{String.valueOf(databaseUnit.getId())}
        ) > 0;
    }

    public boolean isUnitNameAvailable(String name) {
        return getUnits(UNIT_NAME + " = " + DatabaseUtils.sqlEscapeString(name)).size() == 0;
    }

    /* Entries */
    public ArrayList<DatabaseEntry> getEntriesOf(int year, int month, int day) {
        ArrayList<DatabaseEntry> entries = new ArrayList<DatabaseEntry>();
        entries.addAll(getMenuEntriesOf(year, month, day));
        entries.addAll(getGroceryEntriesOf(year, month, day));
        return entries;
    }
}