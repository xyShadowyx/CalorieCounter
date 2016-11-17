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
        mGui.getDeleteGroceries().setOnClickListener(cl);
        mGui.getOpenGroceriesSearchOverview().setOnClickListener(cl);
        mGui.getAddMenu().setOnClickListener(cl);
    }

    public void onSelectMenuNameClicked() {

    }

    public void onSelectPortionSizeClicked() {

    }

    public void onDeleteGroceriesClicked() {

    }

    public void onOpenGroceriesSearchOverviewClicked() {

    }

    public void onAddMenuClicked() {

    }
}
