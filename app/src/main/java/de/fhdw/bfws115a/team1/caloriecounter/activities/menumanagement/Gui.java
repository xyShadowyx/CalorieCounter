package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private EditText mSelectMenuName;
    private EditText mSelectPortionSize;

    private ImageView mDeleteGrocery;
    private ImageView mAddNewGrocery;

    private TextView mAddedGrocery;

    private Button mAddMenu;

    private ListView mListView;

    public Gui(Init activity) {
        activity.setContentView(R.layout.menumanagement);

        /* IDs müssen noch auf das passende Layout referenziert werden! Erledigt*/
        mSelectMenuName = (EditText) activity.findViewById(R.id.idMenuManagementSelectMenuName);
        mSelectPortionSize = (EditText) activity.findViewById(R.id.idMenuManagementSelectPortionSize);

        mDeleteGrocery = (ImageView) activity.findViewById(R.id.idMenuManagementDeleteGrocery);
        mAddNewGrocery = (ImageView) activity.findViewById(R.id.idMenuManagementAddNewGrocery);

        mAddedGrocery = (TextView) activity.findViewById(R.id.idMenuManagementAddedGrocery);

        mAddMenu = (Button) activity.findViewById(R.id.idMenuManagementAddMenu);

        mListView = (ListView) activity.findViewById(R.id.idMenuMangementList);
    }

    /* Getter methods */
    public EditText getSelectMenuName() {
        return mSelectMenuName;
    }

    public EditText getSelectPortionSize() {
        return mSelectPortionSize;
    }

    public ImageView getDeleteGrocery() {
        return mDeleteGrocery;
    }

    public ImageView getAddNewGrocery() {
        return mAddNewGrocery;
    }

    public TextView getAddedGroceries() {
        return mAddedGrocery;
    }

    public Button getAddMenu() {
        return mAddMenu;
    }

    public ListView getListView() {
        return mListView;
    }
    /* Methods to change view attributes */
}
