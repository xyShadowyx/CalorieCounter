package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {

    private ImageView mAddNewQuantityUnit;
    private ListView mListView;
    private EditText mNewQuantityUnitName;


    public Gui(Init activity) {
        /* ID´s müssen noch vom Layout zugewiesen werden! */
        activity.setContentView(R.layout.quantityunitmanagment1);

        mAddNewQuantityUnit = (ImageView) activity.findViewById(R.id.idQuantityUnitManagementAddNewQuantityUnit);
        mListView = (ListView) activity.findViewById(R.id.idListQuantityUnitManagement);
        mNewQuantityUnitName = (EditText) activity.findViewById(R.id.idQuantityUnitManagementQuantityName);
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

    /* Other methods */
}


