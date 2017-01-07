package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;

    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;

    private FixGrocery mFixGrocery;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mFixGrocery = null;

        mNameText = (TextView) view.findViewById(R.id.idMenuManagementLastAdd);
        mDeleteImage = (ImageView) view.findViewById(R.id.idMenuManagementDeleteGrocery);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mFixGrocery);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
    }

    public void setFixGroceryEntity(FixGrocery fixGrocery) {
        mListButtonClickListener.setFixGrocery(fixGrocery);
    }

    public TextView getNameText() {
        return mNameText;
    }

    public ImageView getDeleteImage() {
        return mDeleteImage;
    }
}
