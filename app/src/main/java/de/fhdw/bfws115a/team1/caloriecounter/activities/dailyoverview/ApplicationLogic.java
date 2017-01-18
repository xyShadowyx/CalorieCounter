package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Intent;
import android.util.Log;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceryEntry;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseMenuEntry;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

public class ApplicationLogic {

    /* Member variables */
    private Data mData;
    private Gui mGui;

    private ListAdapter mListAdapter;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initAdapter();
        initListener();
    }

    /**
     * Initialization.
     */
    private void initGui() {
        mGui.setDate(mData.getSelectedDay(), mData.getSelectedMonth(), mData.getSelectedYear());
        mGui.setUsedCalories(mData.getUsedCalories());
        mGui.setMaxCalories(mData.getMaxCalories());
        mGui.getEntryListView().setEmptyView(mGui.getEmptyListTextView());
        calculateCalories();
    }

    private void calculateCalories() {
        mData.setUsedCalories(0);
        for (DatabaseEntry databaseEntry : mData.getDatabaseEntryList()) {
            mData.setUsedCalories(databaseEntry.getCalories() + mData.getUsedCalories());
        }
        mGui.setUsedCalories(mData.getUsedCalories());
        mData.setLeftCalories(mData.getMaxCalories() - mData.getUsedCalories());
        mGui.setLeftCalories(mData.getLeftCalories());
    }

    /**
     * Initialization.
     */
    private void initListener() {
        ButtonClickListener bcl;
        bcl = new ButtonClickListener(this);

        mGui.getTodayDateText().setOnClickListener(bcl);
        mGui.getGroceryButton().setOnClickListener(bcl);
        mGui.getMenuButton().setOnClickListener(bcl);
        mGui.getNewEntryButton().setOnClickListener(bcl);
        mGui.getUnitQuantityButton().setOnClickListener(bcl);
        mGui.getMaxCalories().addTextChangedListener(new TextChangeListener(this, mGui.getMaxCalories()));
    }

    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getEntryListView().setAdapter(mListAdapter);
    }

    /**
     * Redirects to 'quantityunitmanagement'-activity.
     */
    public void onClickUnitQuantityButton() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.Init.class);
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    /**
     * Redirects to 'grocerysearchoverview'-activity.
     */
    public void onClickMenuButton() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_MENU.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    /**
     * Redirects to 'grocerysearchoverview'-activity.
     */
    public void onClickGroceryButton() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_GROCERY.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    /**
     * Redirects to 'calendar'-activity.
     */
    public void onClickChangeDate() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.calendar.Init.class);
        intent.putExtra("day", mData.getSelectedDay());
        intent.putExtra("month", mData.getSelectedMonth());
        intent.putExtra("year", mData.getSelectedYear());
        mData.getActivity().startActivityForResult(intent, ResultCodes.CALENDAR_RESULT);
    }

    /**
     * Triggered when the current date is changed. Contains operations for changing the date consistently.
     *
     * @param data The data containing information about the current date.
     */
    public void onDateChanged(Intent data) {
        Intent changedIntent;

        int day = data.getIntExtra("day", mData.getSelectedDay());
        int month = data.getIntExtra("month", mData.getSelectedMonth());
        int year = data.getIntExtra("year", mData.getSelectedYear());

        changedIntent = mData.getActivity().getIntent();
        changedIntent.putExtra("day", day);
        changedIntent.putExtra("month", month);
        changedIntent.putExtra("year", year);
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }

    /**
     * Redirects to 'grocerysearchoverview'-activity.
     */
    public void onClickAddEntry() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ALL.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NEWENTRY_RESULT);
    }

    /**
     * Creates entry and binds it to a specific date. The entry is therefore saved in personal database.
     *
     * @param data
     */
    public void onEntrySelected(Intent data) {
        GroceriesEntity groceriesEntity;
        DatabaseEntityManager databaseEntityManager;

        groceriesEntity = (GroceriesEntity) data.getSerializableExtra("groceriesEntity");
        databaseEntityManager = mData.getDatabaseEntityManager();

        if (groceriesEntity instanceof FixGrocery) {
            FixGrocery fixGrocery;
            GroceryEntry groceryEntry;
            fixGrocery = (FixGrocery) groceriesEntity;
            groceryEntry = new GroceryEntry(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay(), fixGrocery);
            databaseEntityManager.createGroceryEntry(groceryEntry);
            Log.d("CreateNewEntry", groceryEntry.toString());
        } else if (groceriesEntity instanceof Menu) {
            Menu menu;
            MenuEntry menuEntry;
            menu = (Menu) groceriesEntity;
            menuEntry = new MenuEntry(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay(), menu);
            databaseEntityManager.createMenuEntry(menuEntry);
            Log.d("CreateNewEntry", menuEntry.toString());
        }
        reload();
    }

    /**
     * Reloads the current activity.
     */
    public void reload() {
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }

    public void deleteItem(DatabaseEntry databaseEntry) {
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();
        if (databaseEntry instanceof DatabaseGroceryEntry) {
            mData.getDatabaseEntityManager().deleteGroceryEntry((DatabaseGroceryEntry) databaseEntry);
        } else if (databaseEntry instanceof DatabaseMenuEntry) {
            mData.getDatabaseEntityManager().deleteMenuEntry((DatabaseMenuEntry) databaseEntry);
        }
        mData.getDatabaseEntryList().remove(databaseEntry);
        mListAdapter.notifyDataSetChanged();
        calculateCalories();
    }

    public void onSelectCopyItem(DatabaseEntry databaseEntry) {
        mData.setEntryToCopy(databaseEntry);

        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.calendar.Init.class);
        intent.putExtra("day", mData.getSelectedDay());
        intent.putExtra("month", mData.getSelectedMonth());
        intent.putExtra("year", mData.getSelectedYear());
        mData.getActivity().startActivityForResult(intent, ResultCodes.COPYTODATE);
    }

    public void copyItemTo(int year, int month, int day) {
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();
        DatabaseEntry databaseEntry = mData.getEntryToCopy();
        databaseEntry.setDate(year, month, day);
        if (databaseEntry instanceof DatabaseMenuEntry) {
            databaseEntityManager.createMenuEntry(new MenuEntry((MenuEntry) databaseEntry));
        } else if (databaseEntry instanceof DatabaseGroceryEntry) {
            databaseEntityManager.createGroceryEntry(new GroceryEntry((GroceryEntry) databaseEntry));
        }
    }

    public void onCopyDateSelected(Intent data) {
        Intent changedIntent;

        int day = data.getIntExtra("day", mData.getSelectedDay());
        int month = data.getIntExtra("month", mData.getSelectedMonth());
        int year = data.getIntExtra("year", mData.getSelectedYear());

        copyItemTo(year, month, day);

        changedIntent = mData.getActivity().getIntent();
        changedIntent.putExtra("day", day);
        changedIntent.putExtra("month", month);
        changedIntent.putExtra("year", year);
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }

    public void onEditEntry(DatabaseEntry databaseEntry) {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount.Init.class);

        if (databaseEntry instanceof DatabaseMenuEntry) {
            DatabaseMenuEntry databaseMenuEntry = (DatabaseMenuEntry) databaseEntry;
            intent.putExtra("groceriesEntity", databaseMenuEntry.getMenu());
        } else if (databaseEntry instanceof DatabaseGroceryEntry) {
            DatabaseGroceryEntry databaseGroceryEntry = (DatabaseGroceryEntry) databaseEntry;
            intent.putExtra("groceriesEntity", databaseGroceryEntry.getFixGrocery());
        } else {
            return;
        }
        mData.setEntryToEdit(databaseEntry);
        mData.getActivity().startActivityForResult(intent, ResultCodes.EDITENTRY);
    }

    public void onEntryEdited(Intent data) {
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();
        double selectedAmount = data.getDoubleExtra("amount", 0.0);
        DatabaseEntry databaseEntry = mData.getEntryToEdit();

        if (databaseEntry instanceof DatabaseMenuEntry) {
            databaseEntry.setAmount(selectedAmount);
            databaseEntityManager.saveMenuEntry((DatabaseMenuEntry) databaseEntry);
        } else if (databaseEntry instanceof DatabaseGroceryEntry) {
            databaseEntry.setAmount(selectedAmount);
            databaseEntityManager.saveGroceryEntry((DatabaseGroceryEntry) databaseEntry);
        }
        calculateCalories();
    }

    public void onCaloriesLimitChanged(String s) {
        try {
            mData.setMaxCalories(Integer.valueOf(s));
        } catch (Exception e) {
            mData.setMaxCalories(0);
        }
        calculateCalories();
    }
}
