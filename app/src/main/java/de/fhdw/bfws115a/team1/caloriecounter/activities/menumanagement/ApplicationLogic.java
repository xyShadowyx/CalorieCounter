package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private DatabaseEntityManager mDatabaseEntityManager;

    private ListAdapter mListAdapter;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        mDatabaseEntityManager = mData.getDatabaseEntityManager();
        initGui();
        initListener();
        initAdapter();
    }

    private void initGui() {

    }

    private void initListener() {
        /*ClickListener cl;

        cl = new ClickListener(this);
        mGui.getSelectMenuName().setOnClickListener(cl);
        mGui.getSelectPortionSize().setOnClickListener(cl);
        mGui.getDeleteGrocery().setOnClickListener(cl);
        mGui.getAddNewGrocery().setOnClickListener(cl);
        mGui.getAddMenu().setOnClickListener(cl);*/
    }

    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
    }

    /**
     * If called, it invokes 'groceriessearchoverview'.
     */
    public void onAddNewGroceryClicked() {
        /* Öffnet/Verweist die Activity 'groceriessearchoverview', um dem Menü neue Lebensmittel hinzuzufügen! */

    }

    /**
     * If called, the Validation checker checks the input length respectively the portion size value and
     * if the menu name is not already saved in the personal database.
     */
    public void onAddMenuClicked() {

    }

    public void onDeleteGroceryClicked(FixGrocery fixGrocery) {
        mData.getMenuFixGroceries().remove(fixGrocery);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     *
     */
    public void createNewMenu() {
        /* Neues Menü anlegen und in der Datenbank speichern */
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getSelectMenuName())
                && mDatabaseEntityManager.isMenuNameAvailable(mData.getSelectMenuName())) {

            if (Validation.checkNumberValue(mData.getSelectPortionSize())) {
                Menu newMenu = new Menu(mData.getSelectMenuName(), mData.getSelectPortionSize());
                for (FixGrocery fg : mData.getMenuFixGroceries()) {
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
    }

    public void editMenu() {
        if (Validation.checkLenght(DatabaseHelper.MEDIUM_NAME_LENGTH, mData.getSelectMenuName()) &&
                (mData.getInputMenu().getName() == mData.getSelectMenuName() || mDatabaseEntityManager.isMenuNameAvailable(mData.getSelectMenuName()))) {

            if (Validation.checkNumberValue(mData.getSelectPortionSize())) {
                mData.getInputMenu().removeAllGrocery();
                mData.getInputMenu().setName(mData.getSelectMenuName());
                mData.getInputMenu().setAmount(mData.getSelectPortionSize());

                for (FixGrocery fg : mData.getMenuFixGroceries()) {
                    mData.getInputMenu().addGrocery(new FixGrocery(fg));
                }
                mDatabaseEntityManager.saveMenu(mData.getInputMenu());
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
    }
}
