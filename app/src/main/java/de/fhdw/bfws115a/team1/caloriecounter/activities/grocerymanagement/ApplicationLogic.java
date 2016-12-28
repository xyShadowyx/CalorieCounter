package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

/**
 * Created by Florian on 08.11.2016.
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private DatabaseEntityManager mDatabaseEntityManager;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        mDatabaseEntityManager = mData.getDatabaseEntityManager();
        initGui();
        initListener();
    }

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getAddNewQuantity().setOnClickListener(cl);
        mGui.getDeleteQuantity().setOnClickListener(cl);
        mGui.getSaveGrocery().setOnClickListener(cl);

        //dropdown??
        mGui.getSpinner().setOnClickListener(cl);
    }

    private void initGui() {

    }

    /**
     * If called, it creates a new quantity unit of the selected grocery entity.
     * The added new quantity unit will also be saved in the personal database.
     */
    public void onAddNewQuantityClicked() {
        if (Validation.checkNumberValue(mData.getSelectedAmount())) {
            /* generiere neue Mengeneinheit im Layout */
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
    public void onDeleteQuantityClicked() {
        /* Lösche aus der DB! */
    }

    /**
     * If called, checks if grocery name, quantity unit(s) and KCAL-amount of the selected grocery entity are valid.
     * It also checks if the specific grocery entity is already saved in the personal database.
     * Otherwise saves a new grocery entity (with corresponding attributes) in the personal database.
     */
    public void onSaveGroceryClicked() {

        //prüfen ob es diese einheit schon gibt (Datenbankabfrage) -- toast message "Einheit ist bereits vorhanden"
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getGroceryName())
                && mDatabaseEntityManager.isGroceryNameAvailable(mData.getGroceryName())) {
            if (Validation.checkNumberValue(mData.getKiloCalories())) {
                //abspeichern in der DB }
            } else {
                Context context = mData.getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_existinggroceryindbtoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}