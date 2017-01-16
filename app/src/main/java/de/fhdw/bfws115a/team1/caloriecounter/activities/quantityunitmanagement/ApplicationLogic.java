package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

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
    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getAddNewQuantityUnit().setOnClickListener(cl);
    }

    /**
     * Initialization.
     */
    private void initAdapter() {
        TextChangeListener textListener;

        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
        textListener = new TextChangeListener(this, mGui);
        mGui.getNewQuantityUnitName().addTextChangedListener(textListener);
    }

    /**
     * Initialization.
     */
    private void initGui() {
    }

    /**
     * If called, changes the name of the selected quantity unit.
     *
     * @param newName The new name the quantity unit should get.
     */
    public void onQuantityUnitNameChanged(String newName) {
        mData.setNewQuantityUnitName(newName);
    }

    /**
     * If called, it creates a new quantity unit which will be saved in the personal database.
     * A Validation checker checks if the input is empty, has a valid length and
     * is not already saved in the personal database.
     */
    public void onAddNewQuantityUnitClicked() {
        DatabaseEntityManager databaseEntityManager;

        databaseEntityManager = mData.getDatabaseEntityManager();

        if (!Validation.checkIfEmpty(mData.getNewQuantityUnitName())) {

            if (Validation.checkLenght(DatabaseHelper.SHORT_NAME_LENGTH, mData.getNewQuantityUnitName())) {

                if (databaseEntityManager.isUnitNameAvailable(mData.getNewQuantityUnitName())) {
                    Unit newQuantity;
                    DatabaseUnit databaseUnit;

                    newQuantity = new Unit(mData.getNewQuantityUnitName());
                    databaseUnit = databaseEntityManager.createUnit(newQuantity);

                    mData.getQuantityUnits().add(databaseUnit);
                    mListAdapter.notifyDataSetChanged();

                    mData.setNewQuantityUnitName("");
                    mGui.getNewQuantityUnitName().setText("");
                } else {
                    Context context;
                    Toast toast;
                    context = mData.getActivity().getApplicationContext();
                    toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunittoast, Toast.LENGTH_SHORT);
                    toast.show();
                }

            } else {
                Context context;
                Toast toast;
                context = mData.getActivity().getApplicationContext();
                toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunitnamelengthtoast, Toast.LENGTH_SHORT);
                toast.show();
            }

        } else {
            Context context;
            Toast toast;
            context = mData.getActivity().getApplicationContext();
            toast = Toast.makeText(context, R.string.quantityunitmanagement_emptyfield, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * If called, it deletes the selected quantity unit in the list of quantity units.
     * Furthermore it deletes the quantity unit in the personal database.
     *
     * @param databaseUnit The database unit which should be deleted.
     */
    public void onDeleteQuantityUnitClicked(DatabaseUnit databaseUnit) {
        mData.getQuantityUnits().remove(databaseUnit);
        mData.getDatabaseEntityManager().deleteUnit(databaseUnit);
        mListAdapter.notifyDataSetChanged();
    }
}