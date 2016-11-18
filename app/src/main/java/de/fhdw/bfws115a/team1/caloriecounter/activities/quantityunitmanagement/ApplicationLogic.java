package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

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
        mGui.getAddNewQuantityunit().setOnClickListener(cl);
        mGui.getDeleteQuantityunit().setOnClickListener(cl);
    }

    private void initGui() {

    }

    public void onAddNewQuantityUnit() {
        //prüfen ob es diese einheit schon gibt (Datenbankabfrage) -- toast message "Einheit ist bereits vorhanden"
        if (validation.checkLenght(DatabaseHelper.short_name_length, mData.getNewQuantityUnitName())
                && /* Ist bereits in der DB vorhanden? */) {
            mData.setNewQuantityunitName(""); // Methode leert das Textfeld!
            //abspeichern in der DB
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.quantityunitmanagement_incorrectquantityunittoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onDeleteQuantityUnit() {
    }

    public void onNewQuantityunitChanged() {
        //Textfeld füllen mit eingabe
        //Text in mData speichern
    }

    public void onAddNewQuantity() {

    }

    public void onDeleteQuantity() {

    }
}
