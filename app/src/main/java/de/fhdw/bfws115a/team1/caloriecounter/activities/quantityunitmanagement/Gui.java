package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {

    private LinearLayout mLayout;

    private EditText mEditNewQuantityunit;// abfangen wann etwas geändert wird

    private TextView mQuantityunit;

    private ImageView mAddNewQuantityunit;
    private ImageView mDeleteQuantityunit;


    public Gui(Init activity) {
        /* ID´s müssen noch vom Layout zugewiesen werden!
        activity.setContentView(R.layout.quantityunitmanagement);

        mLayout = (LinearLayout) activity.findViewById(R.id.idLinearLayout);
        mEditNewQuantityunit = (EditText) activity.findViewById(R.id.idEditNewQuantityunit);

        mQuantityunit = activity.findViewById(R.id.idQuantityunit);

        mAddNewQuantityunit = (ImageView) activity.findViewById(R.id.idAddQuantityunit);
        mDeleteQuantityunit = (ImageView) activity.findViewById(R.id.idDeleteQuantityunit);
        */
    }

    /* Getter methods */
    public LinearLayout getLayout() {
        return mLayout;
    }

    public EditText getEditNewQuantityunit() {
        return mEditNewQuantityunit;
    }

    public ImageView getAddNewQuantityunit() {
        return mAddNewQuantityunit;
    }

    public ImageView getDeleteQuantityunit() {
        return mDeleteQuantityunit;
    }

    //methods
}


