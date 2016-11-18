package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

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
        mGui.getSaveGrocerie().setOnClickListener(cl);

        //dropdown??
        mGui.getDropDowm().setOnClickListener(cl);
    }

    private void initGui() {

    }


}