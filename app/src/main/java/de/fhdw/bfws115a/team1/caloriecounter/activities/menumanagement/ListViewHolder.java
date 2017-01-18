package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
public class ListViewHolder {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;
    private TextView mNameText;
    private TextView mAmountText;
    private TextView mCaloriesText;
    private ImageView mDeleteImage;
    private FixGrocery mFixGrocery;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mFixGrocery = null;
        mNameText = (TextView) view.findViewById(R.id.idMenuManagementRowGrocery);
        mAmountText = (TextView) view.findViewById(R.id.idMenuManagementRowAmount);
        mCaloriesText = (TextView) view.findViewById(R.id.idMenuManagementRowCalories);
        mDeleteImage = (ImageView) view.findViewById(R.id.idMenuManagementRowDeleteGrocery);
        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mFixGrocery);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
    }

    /**
     * Sets a FixGrocery.
     *
     * @param fixGrocery The FixGrocery which should be set.
     */
    public void setFixGroceryEntity(FixGrocery fixGrocery) {
        mListButtonClickListener.setFixGrocery(fixGrocery);
    }

    /* Getter methods */
    public TextView getNameText() {
        return mNameText;
    }

    public TextView getCaloriesText() {
        return mCaloriesText;
    }

    public TextView getAmountText() {
        return mAmountText;
    }

    public ImageView getDeleteImage() {
        return mDeleteImage;
    }
}