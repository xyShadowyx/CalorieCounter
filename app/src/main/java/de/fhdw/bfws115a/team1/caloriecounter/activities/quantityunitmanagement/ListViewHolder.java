package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;

    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;

    private DatabaseUnit mDatabaseUnit;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mDatabaseUnit = null;

        mNameText = (TextView) view.findViewById(R.id.idMenuManagementLastAdd);
        mDeleteImage = (ImageView) view.findViewById(R.id.idQuantityUnitManagementDeleteQuantityUnit);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mDatabaseUnit);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
    }

    public void setDatabaseUnit(DatabaseUnit databseUnit) {
        mListButtonClickListener.setDatabaseUnit(databseUnit);
    }

    public TextView getNameText() {
        return mNameText;
    }

    public ImageView getDeleteImage() {
        return mDeleteImage;
    }
}
