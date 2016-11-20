package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {

    private LinearLayout mLayout;

    private EditText mEditNewQuantityUnit;// abfangen wann etwas geändert wird

    private TextView mQuantityUnit;

    private ImageView mAddNewQuantityUnit;
    private ImageView mDeleteQuantityUnit;


    public Gui(Init activity) {
        /* ID´s müssen noch vom Layout zugewiesen werden!
        activity.setContentView(R.layout.quantityunitmanagement);

        mLayout = (LinearLayout) activity.findViewById(R.id.idLinearLayout);
        mEditNewQuantityUnit = (EditText) activity.findViewById(R.id.idEditNewQuantityUnit);

        mQuantityUnit = activity.findViewById(R.id.idQuantityUnit);

        mAddNewQuantityUnit = (ImageView) activity.findViewById(R.id.idAddQuantityUnit);
        mDeleteQuantityUnit = (ImageView) activity.findViewById(R.id.idDeleteQuantityUnit);
        */
    }

    /* Getter methods */
    public LinearLayout getLayout() {
        return mLayout;
    }

    public EditText getEditNewQuantityUnit() {
        return mEditNewQuantityUnit;
    }

    public ImageView getAddNewQuantityUnit() {
        return mAddNewQuantityUnit;
    }

    public ImageView getDeleteQuantityUnit() {
        return mDeleteQuantityUnit;
    }

    /* Other methods */
}


