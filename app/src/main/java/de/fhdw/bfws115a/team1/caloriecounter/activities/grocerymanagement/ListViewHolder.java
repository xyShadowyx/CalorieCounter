package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;

    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;

    private GroceryUnit mGroceryUnit;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mGroceryUnit = null;

        mNameText = (TextView) view.findViewById(R.id.idGroceryManagementListrowAmount);
        mDeleteImage = (ImageView) view.findViewById(R.id.idGroceryManagementDeleteAmount);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mGroceryUnit);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
    }

    public void setGroceryUnit(GroceryUnit groceryUnit) {
        mListButtonClickListener.setGroceryUnit(groceryUnit);
    }

    public TextView getNameText() {
        return mNameText;
    }

    public ImageView getDeleteImage() {
        return mDeleteImage;
    }
}
