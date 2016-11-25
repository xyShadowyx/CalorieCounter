package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.validation;

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

    /**
     * If called, it deletes the selected grocery entity.
     * Furthermore it deletes the specific grocery entity of the selected menu.
     */
    public void onDeleteGroceryClicked() {
        /* Löscht ein hinzugefügtes Lebensmittel aus dem Menü! */
    }

    /**
     * If called, it invokes 'groceriessearchoverview'.
     */
    public void onAddNewGroceryClicked() {
        /* Öffnet/Verweist die Activity 'groceriessearchoverview', um dem Menü neue Lebensmittel hinzuzufügen! */

    }

    /**
     * If called, the validation checker checks the input length respectively the portion size value and
     * if the menu name is not already saved in the personal database.
     */
    public void onAddMenuClicked() {
        /* Neues Menü anlegen und in der Datenbank speichern */
        if (validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getSelectMenuName())
                && mDatabaseEntityManager.isMenuNameAvailable(mData.getSelectMenuName())) { /* Wird bearbeitet oder nicht */
            if (validation.checkNumberValue(mData.getSelectPortionSize())) {
                Menu newMenu = new Menu(mData.getSelectMenuName(), mData.getSelectPortionSize());
                for (FixGrocery fg : mData.getmMenuFixGroceries()) {
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

        /* Menüname + Portionsgröße + hinzugefügte Lebensmittel werden als Menü zusammengefasst in die Datenbank geschrieben
        * Menüname und Portionsgröße müssen überprüft werden hinsichtlich Eingabe
        * Überlegung Strings allgemeiner zu fassen oder umzubenennen toast_xxx
        * */
    }
}
