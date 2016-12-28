package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private EditText mMenuName;
    private EditText mPortionSize;

    private ImageView mAddNewGrocery;
    private Button mAddMenu;

    private ListView mListView;

    public Gui(Init activity) {
        activity.setContentView(R.layout.menumanagement);

        mMenuName = (EditText) activity.findViewById(R.id.idMenuManagementSelectMenuName);
        mPortionSize = (EditText) activity.findViewById(R.id.idMenuManagementSelectPortionSize);

        mAddNewGrocery = (ImageView) activity.findViewById(R.id.idMenuManagementAddNewGrocery);

        mAddMenu = (Button) activity.findViewById(R.id.idMenuManagementAddMenu);

        mListView = (ListView) activity.findViewById(R.id.idMenuMangementList);
    }

    /* Getter methods */
    public EditText getMenuName() {
        return mMenuName;
    }

    public EditText getPortionSize() {
        return mPortionSize;
    }

    public ImageView getAddNewGrocery() {
        return mAddNewGrocery;
    }

    public Button getAddMenu() {
        return mAddMenu;
    }

    public ListView getListView() {
        return mListView;
    }
}
