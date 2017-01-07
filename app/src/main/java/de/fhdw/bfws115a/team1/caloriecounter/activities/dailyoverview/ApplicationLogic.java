package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Intent;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {
        mGui.setDate(mData.getSelectedDay(), mData.getSelectedMonth(), mData.getSelectedYear());
    }

    private void initListener() {
        ButtonClickListener bcl = new ButtonClickListener(this);

        mGui.getTodayDateText().setOnClickListener(bcl);
        mGui.getGroceryButton().setOnClickListener(bcl);
        mGui.getMenuButton().setOnClickListener(bcl);
        mGui.getUnitQuantityButton().setOnClickListener(bcl);
    }

    public void onClickUnitQuantityButton() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.Init.class);
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    public void onClickMenuButton() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_GROCERY.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    public void onClickGroceryButton() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_GROCERY.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NO_RETURN);
    }

    public void onClickChangeDate() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.calendar.Init.class);
        intent.putExtra("day", mData.getSelectedDay());
        intent.putExtra("month", mData.getSelectedMonth());
        intent.putExtra("year", mData.getSelectedYear());
        mData.getActivity().startActivityForResult(intent, ResultCodes.CALENDAR_RESULT);
    }

    public void onDateChanged(Intent data) {
        int day = data.getIntExtra("day", mData.getSelectedDay());
        int month = data.getIntExtra("month", mData.getSelectedMonth());
        int year = data.getIntExtra("year", mData.getSelectedYear());

        Intent changedIntent = mData.getActivity().getIntent();
        changedIntent.putExtra("day", day);
        changedIntent.putExtra("month", month);
        changedIntent.putExtra("year", year);
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }

    public void onClickAddEntry() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ALL.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.NEWENTRY_RESULT);
    }

    public void onEntrySelected(Intent data) {
        GroceriesEntity groceriesEntity = (GroceriesEntity) data.getSerializableExtra("groceriesEntity");
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();

        if (groceriesEntity instanceof FixGrocery) {
            FixGrocery fixGrocery = (FixGrocery) groceriesEntity;
            GroceryEntry groceryEntry = new GroceryEntry(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay(), fixGrocery);
            databaseEntityManager.createGroceryEntry(groceryEntry);

        } else if (groceriesEntity instanceof Menu) {
            Menu menu = (Menu) groceriesEntity;
            MenuEntry menuEntry = new MenuEntry(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay(), menu);
            databaseEntityManager.createMenuEntry(menuEntry);
        }
        reload();
    }

    public void reload() {
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }
}
