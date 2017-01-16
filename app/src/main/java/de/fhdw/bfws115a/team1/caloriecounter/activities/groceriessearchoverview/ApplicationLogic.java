package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.app.Activity;
import android.content.Intent;
import de.fhdw.bfws115a.team1.caloriecounter.database.*;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;

public class ApplicationLogic {

    /* Member variables */
    private Data mData;
    private Gui mGui;

    private ListAdapter mListAdapter;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;

        initGui();
        initAdapter();
        initListener();
    }

    /**
     * Initialization.
     */
    private void initGui() {
        ArrayList<DatabaseGroceriesEntity> mDatabaseGroceriesEntityList;
        mDatabaseGroceriesEntityList = mData.getDatabaseGroceriesEntityList();
        mGui.getListView().setEmptyView(mGui.getEmptyListTextView());
    }

    /**
     * Initialization.
     */
    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
    }

    /**
     * Initialization.
     */
    private void initListener() {
        ClickListener cl = new ClickListener(this);
        TextListener tl = new TextListener(this);

        mGui.getListView().setOnItemClickListener(mListAdapter);

        mGui.getSearchView().setOnQueryTextListener(tl);
        mGui.getAddGroceryButton().setOnClickListener(cl);
        mGui.getAddMenuButton().setOnClickListener(cl);
    }

    /**
     * Reloads the activity.
     */
    public void reload() {
        mData.getActivity().finish();
        mData.getActivity().startActivity(mData.getActivity().getIntent());
    }

    /**
     * Filters a list according to a name.
     *
     * @param name A name to filter the list.
     */
    public void filterListByName(String name) {
        mListAdapter.getFilter().filter(name);
    }

    public void deleteItem(DatabaseGroceriesEntity databaseGroceriesEntity) {
        DatabaseEntityManager databaseEntityManager = mData.getDatabaseEntityManager();
        if(databaseGroceriesEntity instanceof DatabaseMenu) {
            databaseEntityManager.deleteMenu((DatabaseMenu)databaseGroceriesEntity);
        } else if (databaseGroceriesEntity instanceof DatabaseGrocery) {
            databaseEntityManager.deleteGrocery((DatabaseGrocery)databaseGroceriesEntity);
        }
        mData.getDatabaseGroceriesEntityList().remove(databaseGroceriesEntity);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     * Redirects to 'selectamount'-activity after an item is selected.
     *
     * @param groceriesEntity The selected item (GroceryEntity).
     */
    public void onItemSelected(GroceriesEntity groceriesEntity) {
        mData.setSelectedEntity(groceriesEntity);
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount.Init.class);
        intent.putExtra("groceriesEntity", mData.getSelectedEntity());
        mData.getActivity().startActivityForResult(intent, ResultCodes.SELECT_AMOUNT);
    }

    /**
     * Returns a GroceryEntity after it was selected and added with an additional amount.
     *
     * @param data The current data containing information about the selected unit and amount.
     */
    public void onSelectAmountResult(Intent data) {
        Unit selectedUnit;
        GroceriesEntity groceriesEntity;
        Intent resultIntent;
        double selectedAmount;

        selectedUnit = (Unit) data.getSerializableExtra("unit");
        selectedAmount = data.getDoubleExtra("amount", 0.0);
        groceriesEntity = null;

        if (mData.getSelectedEntity() instanceof Grocery) {
            Grocery selectedGrocery;
            GroceryUnit groceryUnit;
            selectedGrocery = (Grocery) mData.getSelectedEntity();
            groceryUnit = null;

            for (GroceryUnit gu : selectedGrocery.getGroceryUnits()) {
                if (gu.getUnit().getName().equals(selectedUnit.getName())) {
                    groceryUnit = gu;
                    break;
                }
            }

            if (groceryUnit != null) {
                groceriesEntity = new FixGrocery(
                        mData.getSelectedEntity().getName(),
                        groceryUnit.getUnit(),
                        selectedAmount,
                        (int) Math.round((selectedGrocery.getKcal() / groceryUnit.getAmount()) * selectedAmount)
                );
            }
        } else if (mData.getSelectedEntity() instanceof Menu) {
            Menu selectedMenu = (Menu) mData.getSelectedEntity();
            // TODO: check calculation of menu kcal with set amount
            selectedMenu.setAmount(selectedAmount);
            groceriesEntity = selectedMenu;
        }
        resultIntent = new Intent();
        resultIntent.putExtra("groceriesEntity", groceriesEntity);
        mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
        mData.getActivity().finish();
    }

    /**
     * Redirects to 'grocerymanagement'-activity.
     */
    public void onCreateNewGroceryClicked() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement.Init.class);
        mData.getActivity().startActivityForResult(intent, ResultCodes.RELOAD);
    }

    /**
     * Redirects to 'menumanagement'-activity.
     */
    public void onCreateNewMenuClicked() {
        Intent intent;
        intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement.Init.class);
        mData.getActivity().startActivityForResult(intent, ResultCodes.RELOAD);
    }

    public void editItem(DatabaseGroceriesEntity databaseGroceriesEntity) {
        Intent intent;
        if(databaseGroceriesEntity instanceof DatabaseMenu) {
            intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement.Init.class);
            intent.putExtra("databaseMenu", (DatabaseMenu) databaseGroceriesEntity);
        }
        else if(databaseGroceriesEntity instanceof DatabaseGrocery) {
            intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement.Init.class);
            intent.putExtra("databaseGrocery", (DatabaseGrocery) databaseGroceriesEntity);
        } else {
            return; // prevent crashes
        }
        mData.getActivity().startActivityForResult(intent, ResultCodes.RELOAD);
    }
}
