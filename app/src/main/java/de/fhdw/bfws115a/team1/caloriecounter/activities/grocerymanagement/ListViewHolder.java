package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;

/**
 * @author Niklas Lammers.
 */
public class ListViewHolder {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;
    private TextView mNameText;
    private ImageView mDeleteImage;
    private GroceryUnit mGroceryUnit;

    /**
     * Connects view elements from frontend with backend variables.
     * Reasons are modifying options in backend later on.
     *
     * @param view             The view where the elements are in.
     * @param applicationLogic ApplicationLogic instance.
     */
    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mGroceryUnit = null;
        mNameText = (TextView) view.findViewById(R.id.idGroceryManagementListrowAmount);
        mDeleteImage = (ImageView) view.findViewById(R.id.idGroceryManagementDeleteAmount);
        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mGroceryUnit);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
    }

    /* Setter methods */
    public void setGroceryUnit(GroceryUnit groceryUnit) {
        mListButtonClickListener.setGroceryUnit(groceryUnit);
    }

    /* Getter methods */
    public TextView getNameText() {
        return mNameText;
    }

    public ImageView getDeleteImage() {
        return mDeleteImage;
    }
}