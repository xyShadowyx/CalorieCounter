package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

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
        /* Menüname + Portionsgröße + hinzugefügte Lebensmittel werden als Menü zusammengefasst in die Datenbank geschrieben
        * Menüname und Portionsgröße müssen überprüft werden hinsichtlich Eingabe
        * */
    }
}
