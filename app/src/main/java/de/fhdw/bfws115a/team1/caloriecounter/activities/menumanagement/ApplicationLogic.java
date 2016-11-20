package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.validation;

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

    }

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getSelectMenuName().setOnClickListener(cl);
        mGui.getSelectPortionSize().setOnClickListener(cl);
        mGui.getDeleteGrocery().setOnClickListener(cl);
        mGui.getAddNewGrocery().setOnClickListener(cl);
        mGui.getAddMenu().setOnClickListener(cl);
    }

    public void onDeleteGroceryClicked() {
        /* Löscht ein hinzugefügtes Lebensmittel aus dem Menü! */
    }

    public void onAddNewGroceryClicked() {
        /* Öffnet/Verweist die Activity 'groceriessearchoverview', um dem Menü neue Lebensmittel hinzuzufügen! */

    }

    public void onAddMenuClicked() {
        if (validation.checkLenght(DatabaseHelper.medium_name_length, mData.getSelectMenuName())
                && /* Ist bereits in der DB vorhanden? */) {
            if (validation.checkNumberValue(mData.getSelectPortionSize())) {
                //abspeichern in der DB }
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
        /* Menüname + Portionsgröße + hinzugefügte Lebensmittel werden als Menü zusammengefasst in die Datenbank geschrieben
        * Menüname und Portionsgröße müssen überprüft werden hinsichtlich Eingabe
        * Überlegung Strings allgemeiner zu fassen oder umzubenennen toast_xxx
        * */
    }
}
