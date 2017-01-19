package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Niklas Lammers
 */
public class ApplicationLogic {

    /* Member variables */
    private Data mData;
    private Gui mGui;

    private ListAdapter mListAdapter;
    private ArrayAdapter<String> mSpinnerAdapter;

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
    private void initListener() {
        ClickListener cl = new ClickListener(this);
        mGui.getAddNewQuantityButton().setOnClickListener(cl);
        mGui.getSaveGrocery().setOnClickListener(cl);
        mGui.getGroceryName().addTextChangedListener(new TextChangeListener(this, mGui.getGroceryName()));
        mGui.getNewUnitAmount().addTextChangedListener(new TextChangeListener(this, mGui.getNewUnitAmount()));
        mGui.getGroceryCalories().addTextChangedListener(new TextChangeListener(this, mGui.getGroceryCalories()));

        mGui.getUnitSpinner().setOnItemSelectedListener(new SpinnerItemSelectListener(this, mData));
    }

    /**
     * Initialization.
     */
    private void initGui() {
        mGui.setGroceryNameText(mData.getGroceryName());
        mGui.setGroceryCaloriesAmount(mData.getGroceryCalories());
        mGui.getGroceryUnitsList().setEmptyView(mGui.getEmptyListTextView());
    }

    /**
     * Initialization.
     */
    private void initAdapter() {
        mSpinnerAdapter = new ArrayAdapter<String>(mData.getActivity(), android.R.layout.simple_list_item_1, mData.getUnitList());
        mGui.getUnitSpinner().setAdapter(mSpinnerAdapter);

        for(int i = 0; i < mData.getUnitList().size(); i++) {
            if(mData.getUnitList().get(i).equals(mData.getNewUnitName())) {
                mGui.getUnitSpinner().setSelection(i, false);
            }
        }

        mListAdapter = new ListAdapter(mData, this);
        mGui.getGroceryUnitsList().setAdapter(mListAdapter);
    }

    /**
     * If called, it creates a new quantity unit of the selected grocery entity.
     * The added new quantity unit will also be saved in the personal database.
     */
    public void onAddNewQuantityClicked() {
        if (Validation.checkNumberValue(mData.getNewUnitAmount()) && !Validation.checkIfEmpty(mData.getNewUnitName())) {
            mData.getGroceryUnits().add(new GroceryUnit(new Unit(mData.getNewUnitName()), mData.getNewUnitAmount()));
            mListAdapter.notifyDataSetChanged();

            mSpinnerAdapter.remove(mData.getNewUnitName());
            mSpinnerAdapter.notifyDataSetChanged();
            mGui.getUnitSpinner().setSelection(0, true);
            mData.setNewUnitName("");
            mGui.getNewUnitAmount().setText("");
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * If called, deletes the selected quantity unit.
     * It also deletes the selected quantity unit from the selected grocery entity.
     */
    public void onDeleteQuantityClicked(GroceryUnit groceryUnit) {
        mData.getGroceryUnits().remove(groceryUnit);
        mSpinnerAdapter.add(groceryUnit.getUnit().getName());

        mListAdapter.notifyDataSetChanged();
        mSpinnerAdapter.notifyDataSetChanged();
    }

    /**
     * If called, checks if grocery name, quantity unit(s) and KCAL-amount of the selected grocery entity are valid.
     * It also checks if the specific grocery entity is already saved in the personal database.
     * Otherwise saves a new grocery entity (with corresponding attributes) in the personal database.
     */
    public void onSaveGroceryClicked() {
        if (mData.getInputGrocery() == null) {
            createNewGrocery();
        } else {
            editGrocery();
        }
    }

    /**
     * Creates a new grocery and adds it to the personal database.
     */
    public void createNewGrocery() {
        DatabaseEntityManager databaseEntityManager;
        Context context;

        databaseEntityManager = mData.getDatabaseEntityManager();
        context = mData.getActivity().getApplicationContext();

        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getGroceryName())
                && databaseEntityManager.isGroceryNameAvailable(mData.getGroceryName())) {

            if (Validation.checkNumberValue(mData.getGroceryCalories()) && !Validation.checkIfEmpty(mData.getGroceryName())) {
                Grocery newGrocery;
                newGrocery = new Grocery(mData.getGroceryName(), mData.getGroceryCalories());
                newGrocery.getGroceryUnits().addAll(mData.getGroceryUnits());
                databaseEntityManager.createGrocery(newGrocery);

                Toast.makeText(context, R.string.grocerymanagement_addedtodb, Toast.LENGTH_SHORT).show();
                mData.getActivity().setResult(Activity.RESULT_OK);
                mData.getActivity().finish();
            } else {
                Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(context, R.string.quantityunitmanagement_existinggroceryindbtoast, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Edits an existing grocery and updates it in the personal database.
     */
    public void editGrocery() {
        DatabaseEntityManager databaseEntityManager;
        Context context;

        databaseEntityManager = mData.getDatabaseEntityManager();
        context = mData.getActivity().getApplicationContext();
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getGroceryName())
                && (mData.getInputGrocery().getName() == mData.getGroceryName()
                || (databaseEntityManager.isGroceryNameAvailable(mData.getGroceryName()) && mData.getInputGrocery().getName() != mData.getGroceryName()))) {

            if (Validation.checkNumberValue(mData.getGroceryCalories())) {
                mData.getInputGrocery().setName(mData.getGroceryName());
                mData.getInputGrocery().setKcal(mData.getGroceryCalories());

                mData.getInputGrocery().getGroceryUnits().clear();
                mData.getInputGrocery().getGroceryUnits().addAll(mData.getGroceryUnits());

                databaseEntityManager.saveGrocery(mData.getInputGrocery());
                Toast.makeText(context, R.string.grocerymanagement_updatedindb, Toast.LENGTH_SHORT).show();

                mData.getActivity().setResult(Activity.RESULT_OK);
                mData.getActivity().finish();
            } else {
                Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(context, R.string.quantityunitmanagement_existinggroceryindbtoast, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Allows to set the name of a grocery.
     *
     * @param name The new name the grocery should get.
     */
    public void onGroceryNameChanged(String name) {
        mData.setGroceryName(name);
    }

    /**
     * Allows to set the KCAL of a specific grocery.
     *
     * @param name The KCAl of a specific grocery.
     */
    public void onGroceryCaloriesChanged(String name) {
        try {
            mData.setGroceryCalories(Integer.parseInt(name));
        } catch (Exception e) {
            mData.setGroceryCalories(0);
        }
    }

    /**
     * Allows to set the name of a specific grocery.
     *
     * @param name The name of a specific grocery.
     */
    public void onNewUnitNameChanged(String name) {
        mData.setNewUnitName(name);
    }

    /**
     * Allows to set the unit amount of a specific grocery.
     *
     * @param amount The unit amount of a specific grocery.
     */
    public void onNewUnitAmountChanged(String amount) {
        try {
            mData.setNewUnitAmount(Double.parseDouble(amount));
        } catch (Exception e) {
            mData.setNewUnitAmount(0.0);
        }
    }
}