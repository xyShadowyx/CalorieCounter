package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private TextView mPickedGrocery;

    private EditText mSelectAmount;

    private Spinner mSpinner;

    private Button mAddAmount;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_main);

        /* IDs müssen noch auf das passende Layout referenziert werden!
        mPickedGrocery = (TextView) activity.findViewById(R.id.idPickedGrocery);

        mSelectAmount = (EditText) activity.findViewById(R.id.idSelectAmount);

        mSpinner = activity.findViewById(R.id.idSpinnerMenu);

        mAddAmount = activity.findViewById(R.id.idAddAmount); */
    }

    /* Getter methods */
    public TextView getPickedGrocery() {
        return mPickedGrocery;
    }

    public EditText getSelectAmount() {
        return mSelectAmount;
    }

    public Spinner getDropDown() {
        return mSpinner;
    }

    public Button getAddAmount() {
        return mAddAmount;
    }
}
