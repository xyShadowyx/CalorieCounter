package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Florian Obladen.
 */

public class Gui {

    /* Member Variables */
    private ImageView mAddNewQuantityUnit;
    private ListView mListView;
    private EditText mNewQuantityUnitName;
    private TextView mEmptyListTextView;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.quantityunitmanagement);

        mAddNewQuantityUnit = (ImageView) activity.findViewById(R.id.idQuantityUnitManagementAddNewQuantityUnit);
        mListView = (ListView) activity.findViewById(R.id.idQuantityUnitManagementList);
        mNewQuantityUnitName = (EditText) activity.findViewById(R.id.idQuantityUnitManagementQuantityName);
        mEmptyListTextView = (TextView) activity.findViewById(R.id.idQuantityUnitManagementNoResults);
    }

    /* Getter methods */
    public ImageView getAddNewQuantityUnit() {
        return mAddNewQuantityUnit;
    }

    public ListView getListView() {
        return mListView;
    }

    public EditText getNewQuantityUnitName() {
        return mNewQuantityUnitName;
    }

    public TextView getEmptyListTextView() {
        return mEmptyListTextView;
    }
}