package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private EditText mSelectMenuName;
    private EditText mSelectPortionSize;

    private ImageView mDeleteGroceries;
    private ImageView mOpenGroceriesSearchOverview;

    private TextView mAddedGroceries;

    private Button mAddMenu;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_main);

        /* IDs müssen noch auf das passende Layout referenziert werden!
        mSelectMenuName = (EditText) activity.findViewById(R.id.idSelectMenuName);
        mSelectPortionSize = (EditText) activity.findViewById(R.id.idSelectPortionSize);

        mDeleteGroceries = activity.findViewById(R.id.idDeleteGroceries);
        mOpenGroceriesSearchOverview = activity.findViewById(R.id.idOpenGroceriesSearchOverview);

        mAddedGroceries = activity.findViewById(R.id.idAddedGroceries);

        mAddMenu = activity.findViewById(R.id.idAddMenu); */
    }

    /* Getter methods */
    public EditText getSelectMenuName() {
        return mSelectMenuName;
    }

    public EditText getSelectPortionSize() {
        return mSelectPortionSize;
    }

    public ImageView getDeleteGroceries() {
        return mDeleteGroceries;
    }

    public ImageView getOpenGroceriesSearchOverview() {
        return mOpenGroceriesSearchOverview;
    }

    public TextView getAddedGroceries() {
        return mAddedGroceries;
    }

    public Button getAddMenu() {
        return mAddMenu;
    }

    /* Methods to change view attributes */
}
