package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Niklas Lammers.
 */
public class Gui {

    /* Member variables */
    private EditText mGroceryName;
    private EditText mNewUnitAmount;
    private Spinner mUnitSpinner;
    private EditText mGroceryCalories;
    private ListView mGroceryUnitsList;
    private ImageView mAddNewQuantity;
    private ImageView mSaveGrocery;
    private TextView mEmptyListTextView;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.grocerymanagement);

        mGroceryName = (EditText) activity.findViewById(R.id.idGroceryManagementGroceryName);
        mNewUnitAmount = (EditText) activity.findViewById(R.id.idGroceryManagementSelectedAmount);
        mGroceryCalories = (EditText) activity.findViewById(R.id.idGroceryManagementCalories);
        mUnitSpinner = (Spinner) activity.findViewById(R.id.idGroceryManagementSpinner);
        mGroceryUnitsList = (ListView) activity.findViewById(R.id.idGroceryManagementListView);
        mAddNewQuantity = (ImageView) activity.findViewById(R.id.idGroceryManagementAddAmount);
        mSaveGrocery = (ImageView) activity.findViewById(R.id.idGroceryManagementSaveGrocery);
        mEmptyListTextView = (TextView) activity.findViewById(R.id.idGroceryManagementNoResults);
    }

    /* Getter methods */
    public Spinner getUnitSpinner() {
        return mUnitSpinner;
    }

    public EditText getGroceryName() {
        return mGroceryName;
    }

    public EditText getNewUnitAmount() {
        return mNewUnitAmount;
    }

    public ImageView getAddNewQuantityButton() {
        return mAddNewQuantity;
    }

    public EditText getGroceryCalories() {
        return mGroceryCalories;
    }

    public ImageView getSaveGrocery() {
        return mSaveGrocery;
    }

    public ListView getGroceryUnitsList() {
        return mGroceryUnitsList;
    }

    /* Setter methods */
    public void setGroceryNameText(String groceryName) {
        mGroceryName.setText(groceryName);
    }

    public void setGroceryCaloriesAmount(int groceryCalories) {
        mGroceryCalories.setText(String.valueOf(groceryCalories));
    }

    public TextView getEmptyListTextView() {
        return mEmptyListTextView;
    }
}