package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;
    private ImageView mEditImage;

    private DatabaseGroceriesEntity mDatabaseGroceriesEntity;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mDatabaseGroceriesEntity = null;

        mNameText = (TextView) view.findViewById(R.id.idGroceriesSearchOverviewGrocery);
        mDeleteImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewDeleteButton);
        mEditImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewSettingButton);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mDatabaseGroceriesEntity);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
        mEditImage.setOnClickListener(mListButtonClickListener);
    }

    public void setDatabaseGroceriesEntity(DatabaseGroceriesEntity databaseGroceriesEntity) {
        mListButtonClickListener.setDatabaseGroceriesEntity(databaseGroceriesEntity);
    }

    public TextView getNameText() {
        return mNameText;
    }
}
