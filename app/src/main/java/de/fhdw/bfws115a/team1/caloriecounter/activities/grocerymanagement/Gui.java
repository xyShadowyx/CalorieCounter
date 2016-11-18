package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.Init;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {


    private LinearLayout mLayout;


    private EditText mGrocerieName;// abfangen wann etwas geändert wird
    private EditText mQuantity;
    private EditText mKiloCalories;

    private Spinner mDropDowm;

    private ImageView mAddNewQuantity;
    private ImageView mDeleteQuantity;

    private Button mSaveGrocerie;


    public Gui(Init activity) {
        activity.setContentView(R.layout.quantityunitmanagement);

        mLayout = (LinearLayout) activity.findViewById(R.id.idLinearLayout);


        mGrocerieName = (EditText) activity.findViewById(R.id.idEditNewGrocerieName);
        mQuantity = (EditText) activity.findViewById(R.id.idEditNewQuantity);
        mKiloCalories = (EditText) activity.findViewById(R.id.idEditNewKiloCalories);

        mDropDowm = activity.findViewById(R.id.idGrocerieunitDropDown);

        mAddNewQuantity = (ImageView) activity.findViewById(R.id.idAddQuantity);
        mDeleteQuantity = (ImageView) activity.findViewById(R.id.idDeleteQuantity);

        mSaveGrocerie = activity.findViewById(R.id.idSaveGrocerie);


    }

//getter

    public Spinner getDropDowm() {
        return mDropDowm;
    }

    public ImageView getAddNewQuantity() {
        return mAddNewQuantity;
    }

    public ImageView getDeleteQuantity() {
        return mDeleteQuantity;
    }

    public Button getSaveGrocerie() {
        return mSaveGrocerie;
    }


//methods


}
