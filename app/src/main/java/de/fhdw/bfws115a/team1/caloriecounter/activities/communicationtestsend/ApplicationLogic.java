package de.fhdw.bfws115a.team1.caloriecounter.activities.communicationtestsend;

import android.content.Intent;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
        doSmth();
    }

    private void initGui() {

    }

    private void initListener() {

    }

    private void doSmth() {
        Intent i = new Intent(mData.getActivity(), de.fhdw.bfws115a.team1.caloriecounter.activities.communicationtestreceive.Init.class);
        i.putExtra("unit", new Unit("TestUnit"));
        mData.getActivity().startActivity(i);
    }
}
