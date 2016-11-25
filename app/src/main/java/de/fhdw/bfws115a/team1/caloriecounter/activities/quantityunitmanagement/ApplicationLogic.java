package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.validation;

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
        mGui.getAddNewQuantityUnit().setOnClickListener(cl);
        mGui.getDeleteQuantityUnit().setOnClickListener(cl);
    }

    private void initGui() {

    }

    /**
     * If called, it creates a new quantity unit which will be saved in the personal database.
     * A validation checker controls if the input has a valid length and
     * is not already saved in the personal database.
     */
    public void onAddNewQuantityUnitClicked() {
        //prüfen ob es diese Einheit schon gibt (Datenbankabfrage) -- toast message "Einheit ist bereits vorhanden"
        if (validation.checkLenght(DatabaseHelper.SHORT_NAME_LENGTH, mData.getNewQuantityUnitName())
                && mDatabaseEntityManager.isQuanitityUnitNameAvailable(mData.getNewQuantityUnitName())) {

            //erstellen + abspeichern in der DB
            Unit newQuantity = new Unit(mData.getNewQuantityUnitName());
            mDatabaseEntityManager.createUnit(newQuantity);

            // Liste aktualisieren

            mData.setNewQuantityUnitName(""); // Methode leert das Textfeld!

        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunittoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * If called, it deletes the selected quantity unit in the list of quantity units.
     * Furthermore it deletes the quantity unit in the personal database.
     */
    public void onDeleteQuantityUnitClicked() {
    }
}
