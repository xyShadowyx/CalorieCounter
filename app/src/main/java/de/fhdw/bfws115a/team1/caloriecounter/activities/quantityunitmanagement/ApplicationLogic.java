package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

/**
 * Created by Florian on 08.11.2016.
 */
public class ApplicationLogic {

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

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getAddNewQuantityUnit().setOnClickListener(cl);
    }

    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
        TextChangeListener textListener = new TextChangeListener(this, mGui);
        mGui.getNewQuantityUnitName().addTextChangedListener(textListener);
    }

    private void initGui() {

    }

    public void onQuantityUnitNameChanged(String newName) {
        mData.setNewQuantityUnitName(newName);
    }

    /**
     * If called, it creates a new quantity unit which will be saved in the personal database.
     * A Validation checker controls if the input has a valid length and
     * is not already saved in the personal database.
     */
    public void onAddNewQuantityUnitClicked() {
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();

        /* --- First validation --- */
        if (!Validation.checkIfEmpty(mData.getNewQuantityUnitName())) {
            /* --- Second validation --- */
            if (Validation.checkLenght(DatabaseHelper.SHORT_NAME_LENGTH, mData.getNewQuantityUnitName())) {

            /* --- Third validation --- */
                if (databaseEntityManager.isUnitNameAvailable(mData.getNewQuantityUnitName())) {
            /* Creates a new quantity unit and writes it in personal database. */
                    Unit newQuantity = new Unit(mData.getNewQuantityUnitName());
                    DatabaseUnit databaseUnit = databaseEntityManager.createUnit(newQuantity);

            /* Update list */
                    mData.getQuantityUnits().add(databaseUnit);
                    mListAdapter.notifyDataSetChanged();

            /* Clears the input edit text for a new quantity unit. */
                    mData.setNewQuantityUnitName("");
                    mGui.getNewQuantityUnitName().setText("");
                } else {
                    Context context = mData.getActivity().getApplicationContext();
                    Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunittoast, Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                Context context = mData.getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunitnamelengthtoast, Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_emptyfield, Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    public void onDeleteQuantityUnitClicked(DatabaseUnit databaseUnit) {
        mData.getQuantityUnits().remove(databaseUnit);
        mData.getDatabaseEntityManager().deleteUnit(databaseUnit);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     * If called, it deletes the selected quantity unit in the list of quantity units.
     * Furthermore it deletes the quantity unit in the personal database.
     */
}
