package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;

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
        mGui.getListView().setAdapter(mData.getListAdapter());
    }

    private void initListener() {
        TextListener tl = new TextListener(this);
        mGui.getSearchView().setOnQueryTextListener(tl);
    }

    public void filterListByName(String name) {
        mData.getListAdapter().getFilter().filter(name);
    }
}
