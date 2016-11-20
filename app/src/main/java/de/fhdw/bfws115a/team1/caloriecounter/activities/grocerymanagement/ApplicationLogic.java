package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.validation;

/**
 * Created by Florian on 08.11.2016.
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
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

    public void onAddNewQuantityClicked() {
        if (validation.checkNumberValue(mData.getSelectedAmount())) {
            /* generiere neue Mengeneinheit im Layout */
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onDeleteQuantityClicked() {
        /* Lösche aus der DB! */
    }

    public void onSaveGroceryClicked() {
        //prüfen ob es diese einheit schon gibt (Datenbankabfrage) -- toast message "Einheit ist bereits vorhanden"
        if (validation.checkLenght(DatabaseHelper.medium_name_length, mData.getGroceryName())
                && /* Ist bereits in der DB vorhanden? */) {
            if (validation.checkNumberValue(mData.getKiloCalories())) {
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