package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

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

    public void onAddNewQuantityunit() {
        //prüfen ob es diese einheit schon gibt
        mData.setNewQuantityunitName("");
        //abspeichern in der DB
    }

    public void onDeleteQuantityunit() {
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
