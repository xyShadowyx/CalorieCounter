package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private TextView mPickedGrocery;

    private EditText mSelectedAmount;

    private Spinner mSpinner;

    private Button mAddAmount;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_main);

        /* IDs müssen noch auf das passende Layout referenziert werden!
        mPickedGrocery = (TextView) activity.findViewById(R.id.idSelectAmountPickedGrocery);

        mSelectedAmount = (EditText) activity.findViewById(R.id.idSelectAmountSelectAmount);

        mSpinner = activity.findViewById(R.id.idSelectAmountSpinner);

        mAddAmount = activity.findViewById(R.id.idSelectAmountAddAmount); */
    }

    /* Getter methods */
    public TextView getPickedGrocery() {
        return mPickedGrocery;
    }

    public EditText getSelectedAmount() {
        return mSelectedAmount;
    }

    public Spinner getSpinnerStatus() {
        return mSpinner;
    }

    public Button getAddAmount() {
        return mAddAmount;
    }
}
