package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private DatabaseEntityManager mDatabaseEntityManager;

    private ListAdapter mListAdapter;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        mDatabaseEntityManager = mData.getDatabaseEntityManager();
        initGui();
        initListener();
        initAdapter();
    }

    private void initGui() {

    }

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getAddNewGrocery().setOnClickListener(cl);
        mGui.getAddMenu().setOnClickListener(cl);
        mGui.getMenuName().addTextChangedListener(new TextChangeListener(this, mGui.getMenuName()));
        mGui.getPortionSize().addTextChangedListener(new TextChangeListener(this, mGui.getPortionSize()));
    }

    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
    }

    /**
     * If called, it invokes 'groceriessearchoverview'.
     */
    public void onAddNewGroceryClicked() {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_GROCERY.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.SELECT_GROCERY);
    }

    public void onFixGrocerySelected(Intent data) {
        GroceriesEntity groceriesEntity = (GroceriesEntity) data.getSerializableExtra("groceriesEntity");
        if (groceriesEntity instanceof FixGrocery) {
            mData.getMenuFixGroceries().add((FixGrocery) groceriesEntity);
            mListAdapter.notifyDataSetChanged();
        }
    }

    public void onMenuNameChanged(String newName) {
        mData.setMenuName(newName);
    }

    public void onPortionSizeChanged(String newPortion) {
        try {
            int newPortionSize = Integer.valueOf(newPortion);
            mData.setPortionSize(newPortionSize);
        } catch (Exception e) {
        }
    }

    /**
     * If called, the Validation checker checks the input length respectively the portion size value and
     * if the menu name is not already saved in the personal database.
     */
    public void onAddMenuClicked() {
        if (mData.getInputMenu() != null) {
            editMenu();
        } else {
            createNewMenu();
        }
    }

    public void onDeleteGroceryClicked(FixGrocery fixGrocery) {
        mData.getMenuFixGroceries().remove(fixGrocery);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     *
     */
    public void createNewMenu() {
        /* Neues Menü anlegen und in der Datenbank speichern */
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getMenuName())
                && mDatabaseEntityManager.isMenuNameAvailable(mData.getMenuName())) {

            if (Validation.checkNumberValue(mData.getPortionSize())) {
                Menu newMenu = new Menu(mData.getMenuName(), mData.getPortionSize());
                for (FixGrocery fg : mData.getMenuFixGroceries()) {
                    newMenu.addGrocery(new FixGrocery(fg));
                }
                mDatabaseEntityManager.createMenu(newMenu);
            } else {
                Context context = mData.getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
                toast.show();
            }

        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.menumanagement_existingmenuindbtoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void editMenu() {
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getMenuName()) &&
                (mData.getInputMenu().getName() == mData.getMenuName() || mDatabaseEntityManager.isMenuNameAvailable(mData.getMenuName()))) {

            if (Validation.checkNumberValue(mData.getPortionSize())) {
                mData.getInputMenu().removeAllGrocery();
                mData.getInputMenu().setName(mData.getMenuName());
                mData.getInputMenu().setAmount(mData.getPortionSize());

                for (FixGrocery fg : mData.getMenuFixGroceries()) {
                    mData.getInputMenu().addGrocery(new FixGrocery(fg));
                }
                mDatabaseEntityManager.saveMenu(mData.getInputMenu());
            } else {
                Context context = mData.getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
                toast.show();
            }

        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.menumanagement_existingmenuindbtoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
