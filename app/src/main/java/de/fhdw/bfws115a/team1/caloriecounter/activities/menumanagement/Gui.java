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

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_main);

        /* IDs müssen noch auf das passende Layout referenziert werden! Erledigt*/
        mSelectMenuName = (EditText) activity.findViewById(R.id.idMenumanagementSelectMenuName);
        mSelectPortionSize = (EditText) activity.findViewById(R.id.idMenumanagementSelectPortionSize);

        mDeleteGrocery = (ImageView) activity.findViewById(R.id.idMenumanagementDeleteGrocery);
        mAddNewGrocery = (ImageView) activity.findViewById(R.id.idMenumanagementAddNewGrocery);

        mAddedGrocery = (TextView) activity.findViewById(R.id.idMenumanagementAddedGrocery);

        mAddMenu = (Button) activity.findViewById(R.id.idMenumanagementAddMenu);
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

    /* Methods to change view attributes */
}
