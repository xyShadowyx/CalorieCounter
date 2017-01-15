package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.util.Log;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement.ListViewHolder;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {

    private EditText mGroceryName;
    private EditText mNewUnitAmount;
    private Spinner mUnitSpinner;
    private EditText mGroceryCalories;
    private ListView mGroceryUnitsList;

    private ImageView mAddNewQuantity;

    private Button mSaveGrocery;


    public Gui(Init activity) {
        activity.setContentView(R.layout.grocerymanagement);

        mGroceryName = (EditText) activity.findViewById(R.id.idGroceryManagementGroceryName);
        mNewUnitAmount = (EditText) activity.findViewById(R.id.idGroceryManagementSelectedAmount);
        mGroceryCalories = (EditText) activity.findViewById(R.id.idGroceryManagementKiloCalories);

        mUnitSpinner = (Spinner) activity.findViewById(R.id.idGroceryManagementSpinner);

        mGroceryUnitsList = (ListView) activity.findViewById(R.id.idGroceryManagementListView);

        mAddNewQuantity = (ImageView) activity.findViewById(R.id.idGroceryManagementAddAmount);
        mSaveGrocery = (Button) activity.findViewById(R.id.idGroceryManagementSaveGrocery);
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

    public Button getSaveGrocery() {
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
}
