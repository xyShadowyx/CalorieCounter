package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.app.Activity;
import android.content.Intent;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

import java.util.ArrayList;

public class ApplicationLogic {

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

    private void initGui() {
        ArrayList<GroceriesEntity> mGroceriesEntityList = mData.getGroceriesEntityList();
        mGui.getListView().setEmptyView(mGui.getEmptyListTextView());
    }

    private void initAdapter() {
        mListAdapter = new ListAdapter(mData, this);
        mGui.getListView().setAdapter(mListAdapter);
    }

    private void initListener() {
        TextListener tl = new TextListener(this);
        mGui.getSearchView().setOnQueryTextListener(tl);
    }

    public void filterListByName(String name) {
        mListAdapter.getFilter().filter(name);
    }

    public void onItemSelected(GroceriesEntity groceriesEntity) {
        Intent intent = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount.Init.class);

        mData.getActivity().startActivityForResult(intent, ResultCodes.SELECT_AMOUNT);
    }

    public void onSelectAmountResult(Intent data) {
        Intent resultIntent = new Intent();
        //resultIntent.putExtra("groceriesEntity", groceriesEntity);
        mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
        mData.getActivity().finish();
    }
}
