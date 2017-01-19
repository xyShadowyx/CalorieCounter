package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
public class ApplicationLogic {

    /* Member variables */
    private Data mData;
    private Gui mGui;
    private ListAdapter mListAdapter;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
        initAdapter();
    }

    /**
     * Initialization.
     */
    private void initGui() {
        mGui.setMenuNameText(mData.getMenuName());
        mGui.setPortionSizeAmount(mData.getPortionSize());
        mGui.getListView().setEmptyView(mGui.getEmptyListTextView());
    }

    /**
     * Initialization.
     */
    private void initListener() {
        ClickListener cl;
        cl = new ClickListener(this);

        mGui.getAddNewGrocery().setOnClickListener(cl);
        mGui.getAddMenu().setOnClickListener(cl);
        mGui.getMenuName().addTextChangedListener(new TextChangeListener(this, mGui.getMenuName()));
        mGui.getPortionSize().addTextChangedListener(new TextChangeListener(this, mGui.getPortionSize()));
    }

    /**
     * Initialization.
     */
    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
    }

    /**
     * Redirects to 'groceriessearchoverview'-activity.
     */
    public void onAddNewGroceryClicked() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview.Init.class);
        intent.putExtra("searchSettings", SearchSettings.DISPLAY_ONLY_GROCERY.ordinal());
        mData.getActivity().startActivityForResult(intent, ResultCodes.SELECT_GROCERY);
    }

    /**
     * Adds a GroceryEntity to a list of FixGrocery items.
     *
     * @param data Information about the specific GroceryEntity.
     */
    public void onFixGrocerySelected(Intent data) {
        GroceriesEntity groceriesEntity;
        groceriesEntity = (GroceriesEntity) data.getSerializableExtra("groceriesEntity");

        if (groceriesEntity instanceof FixGrocery) {
            mData.getMenuFixGroceries().add((FixGrocery) groceriesEntity);
            mListAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Sets a new name of a Menu.
     *
     * @param newName The new name of the menu.
     */
    public void onMenuNameChanged(String newName) {
        mData.setMenuName(newName);
    }

    /**
     * Sets a new portion size.
     *
     * @param newPortion The new portion size.
     */
    public void onPortionSizeChanged(String newPortion) {
        try {
            mData.setPortionSize(Double.valueOf(newPortion));
        } catch (Exception e) {
        }
    }

    /**
     * Adds respectively edits a menu and stores it in personal database.
     */
    public void onAddMenuClicked() {
        if (mData.getInputMenu() == null) {
            createNewMenu();
        } else {
            editMenu();
        }
    }

    /**
     * Removes an added grocery from the menu list.
     *
     * @param fixGrocery The grocery item the user wants to delete.
     */
    public void onDeleteGroceryClicked(FixGrocery fixGrocery) {
        mData.getMenuFixGroceries().remove(fixGrocery);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     * Creates an new menu and saves it in the personal database.
     */
    public void createNewMenu() {
        DatabaseEntityManager databaseEntityManager;
        Context context;

        databaseEntityManager = mData.getDatabaseEntityManager();
        context = mData.getActivity().getApplicationContext();

        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getMenuName())
                && databaseEntityManager.isMenuNameAvailable(mData.getMenuName())) {

            if (Validation.checkNumberValue(mData.getPortionSize()) && !Validation.checkIfEmpty(mData.getMenuName())) {
                Menu newMenu;
                newMenu = new Menu(mData.getMenuName(), mData.getPortionSize());
                for (FixGrocery fg : mData.getMenuFixGroceries()) {
                    newMenu.addGrocery(new FixGrocery(fg));
                }
                databaseEntityManager.createMenu(newMenu);
                Toast.makeText(context, R.string.menumanagement_addedtodb, Toast.LENGTH_SHORT).show();

                mData.getActivity().setResult(Activity.RESULT_OK);
                mData.getActivity().finish();
            } else {
                Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(context, R.string.menumanagement_existingmenuindbtoast, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Edits a menu which is already stored in the personal database.
     */
    public void editMenu() {
        DatabaseEntityManager databaseEntityManager;
        Context context;

        databaseEntityManager = mData.getDatabaseEntityManager();
        context = mData.getActivity().getApplicationContext();

        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getMenuName()) &&
                (mData.getInputMenu().getName() == mData.getMenuName() || databaseEntityManager.isMenuNameAvailable(mData.getMenuName()))) {

            if (Validation.checkNumberValue(mData.getPortionSize()) && !Validation.checkIfEmpty(mData.getMenuName())) {
                mData.getInputMenu().removeAllGrocery();
                mData.getInputMenu().setName(mData.getMenuName());
                mData.getInputMenu().setAmount(mData.getPortionSize());
                for (FixGrocery fg : mData.getMenuFixGroceries()) {
                    mData.getInputMenu().addGrocery(new FixGrocery(fg));
                }
                databaseEntityManager.saveMenu(mData.getInputMenu());
                Toast.makeText(context, R.string.menumanagement_updatedindb, Toast.LENGTH_SHORT).show();

                mData.getActivity().setResult(Activity.RESULT_OK);
                mData.getActivity().finish();
            } else {
                Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(context, R.string.menumanagement_existingmenuindbtoast, Toast.LENGTH_SHORT).show();
        }
    }
}