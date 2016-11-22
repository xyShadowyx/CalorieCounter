package de.fhdw.bfws115a.team1.caloriecounter.activities.databasetest;

import android.util.Log;
import de.fhdw.bfws115a.team1.caloriecounter.database.*;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();

        testEditEntitiestabase();
    }

    private void initGui() {

    }

    private void initListener() {

    }

    public void testAddEntitiestabase() {
        /* Print existing Entities in Database*/
        DatabaseEntityManager dem = mData.getDatabaseEntityManager();
        Log.d("DATABSETEST", "Database: ");
        printExtistUnits();
        printExtistGroceries();
        printExtistGroceryEntries();
        printExtistMenus();
        printExtistMenuEntries();

        /* add unit */
        dem.createUnit(new Unit("Schl."));

        /* add grocery */
        Grocery carrot = new Grocery("Carrot", new Unit("g"), 2.0, 120);
        dem.createGrocery(carrot);
        dem.createGrocery(new Grocery("Banana", new Unit("g"), 2.0, 403));

        /* add groceryentry */
        dem.createGroceryEntry(new GroceryEntry(2016, 11, 22, carrot));
        dem.createGroceryEntry(new GroceryEntry(2016, 11, 22, new Grocery("Banana", new Unit("g"), 2.0, 403)));

        /* add menu */
        Menu mcMenu = new Menu("MCMenu", 1.0);
        mcMenu.addGrocery(new Grocery("Cola", new Unit("ml"), 500.0, 350));
        mcMenu.addGrocery(new Grocery("Burger", new Unit("g"), 200.0, 602));
        mcMenu.addGrocery(new Grocery("Pommes", new Unit("g"), 150.0, 402));

        dem.createMenu(mcMenu);

        /* add menu entry */
        dem.createMenuEntry(new MenuEntry(2016, 11, 22, mcMenu));

        /* Print existing Entities in Database*/
        Log.d("DATABSETEST", "Database: ");
        printExtistUnits();
        printExtistGroceries();
        printExtistGroceryEntries();
        printExtistMenus();
        printExtistMenuEntries();
    }

    public void testEditEntitiestabase() {
        /* Print existing Entities in Database*/
        DatabaseEntityManager dem = mData.getDatabaseEntityManager();
        Log.d("DATABSETEST", "Database: ");
        printExtistUnits();
        printExtistGroceries();
        printExtistGroceryEntries();
        printExtistMenus();
        printExtistMenuEntries();

        /* add unit */
        DatabaseUnit unit1 = dem.getUnit(1L);
        unit1.setName("Edited Unit");
        dem.saveUnit(unit1);

        /* add grocery */
        DatabaseGrocery groc1 = dem.getGrocery(1);
        groc1.setName("Edited Groc1");
        groc1.setAmount(4000);
        groc1.setKcal(1200000);
        dem.saveGrocery(groc1);

        /* add groceryentry */
        DatabaseGroceryEntry grocEntry1 = dem.getGroceryEntry(1);
        grocEntry1.setGrocery(groc1);
        grocEntry1.setDate(1999, 10, 10);
        dem.saveGroceryEntry(grocEntry1);

        /* add menu */
        DatabaseMenu menu1 = dem.getMenu(1);
        menu1.setName("Edited Menu");
        menu1.getGroceries().get(1).setName("Edited!");
        dem.saveMenu(menu1);

        /* add menu entry */
        DatabaseMenuEntry menuEntry1 = dem.getMenuEntry(1);
        menuEntry1.setMenu(menu1);
        menuEntry1.setDate(1994, 10, 11);
        dem.saveMenuEntry(menuEntry1);

        /* Print existing Entities in Database*/
        Log.d("DATABSETEST", "Database: ");
        printExtistUnits();
        printExtistGroceries();
        printExtistGroceryEntries();
        printExtistMenus();
        printExtistMenuEntries();
    }

    public void printExtistUnits() {
        for(DatabaseUnit dbu : mData.getDatabaseEntityManager().getAllUnits()) {
            Log.d("DATABSETEST", dbu.toString());
        }
    }

    public void printExtistGroceries() {
        for(DatabaseGrocery dbg : mData.getDatabaseEntityManager().getAllGroceries()) {
            Log.d("DATABSETEST", dbg.toString());
        }
    }

    public void printExtistGroceryEntries() {
        for(DatabaseGroceryEntry dbge : mData.getDatabaseEntityManager().getAllGroceryEntries()) {
            Log.d("DATABSETEST", dbge.toString());
        }
    }

    public void printExtistMenus() {
        for(DatabaseMenu dbm : mData.getDatabaseEntityManager().getAllMenus()) {
            Log.d("DATABSETEST", dbm.toString());
        }
    }

    public void printExtistMenuEntries() {
        for(DatabaseMenuEntry dbme : mData.getDatabaseEntityManager().getAllMenuEntries()) {
            Log.d("DATABSETEST", dbme.toString());
        }
    }
}
