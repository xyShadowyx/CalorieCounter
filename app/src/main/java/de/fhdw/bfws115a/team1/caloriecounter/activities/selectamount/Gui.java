package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.widget.*;

import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Niklas Lammers.
 */
public class Gui {

    /* Member variables */
    private TextView mPickedGrocery;
    private EditText mSelectedAmount;
    private Spinner mSpinner;
    private ImageView mAddAmount;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.selectamount);

        mPickedGrocery = (TextView) activity.findViewById(R.id.idSelectAmountPickedGrocery);
        mSelectedAmount = (EditText) activity.findViewById(R.id.idSelectAmountSelectedAmount);
        mSpinner = (Spinner) activity.findViewById(R.id.idSelectAmountSpinner);
        mAddAmount = (ImageView) activity.findViewById(R.id.idSelectAmountAddAmount);
    }

    /* Getter methods */
    public TextView getPickedGrocery() {
        return mPickedGrocery;
    }

    public EditText getSelectedAmount() {
        return mSelectedAmount;
    }

    public Spinner getSpinner() {
        return mSpinner;
    }

    public ImageView getAddAmount() {
        return mAddAmount;
    }
}