package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {

    private EditText mGroceryName;
    private EditText mSelectedAmount;
    private EditText mKiloCalories;

    private Spinner mSpinner;

    private ImageView mAddNewQuantity;
    private ImageView mDeleteQuantity;

    private Button mSaveGrocery;


    public Gui(Init activity) {
        activity.setContentView(R.layout.quantityunitmanagement);

        mGroceryName = (EditText) activity.findViewById(R.id.idGroceryManagementGroceryName);
        mSelectedAmount = (EditText) activity.findViewById(R.id.idGroceryManagementSelectedAmount);
        mKiloCalories = (EditText) activity.findViewById(R.id.idGroceryManagementKiloCalories);

        mSpinner = (Spinner) activity.findViewById(R.id.idGroceryManagementSpinner);

        mAddNewQuantity = (ImageView) activity.findViewById(R.id.idAddNewQuantity);
        mDeleteQuantity = (ImageView) activity.findViewById(R.id.idDeleteQuantity);

        mSaveGrocery = (Button) activity.findViewById(R.id.idSaveGrocery);
    }

    /* Getter methods */
    public Spinner getSpinner() {
        return mSpinner;
    }

    public ImageView getAddNewQuantity() {
        return mAddNewQuantity;
    }

    public ImageView getDeleteQuantity() {
        return mDeleteQuantity;
    }

    public Button getSaveGrocery() {
        return mSaveGrocery;
    }

    /* Setter methods */
}
