package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private TextView mAmountText;
    private TextView mCaloriesText;
    private ImageView mCopyImage;
    private ImageView mDeleteImage;
    private ImageView mEditImage;

    private DatabaseEntry mDatabaseEntry;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mDatabaseEntry = null;

        mNameText = (TextView) view.findViewById(R.id.idDailyoverviewRowGrocery);
        mAmountText = (TextView) view.findViewById(R.id.idDailyoverviewRowAmount);
        mCaloriesText = (TextView) view.findViewById(R.id.idDailyoverviewRowCalories);
        mCopyImage = (ImageView) view.findViewById(R.id.idDailyoverviewRowCopyButton);
        mEditImage = (ImageView) view.findViewById(R.id.idDailyoverviewRowSettingButton);
        mDeleteImage = (ImageView) view.findViewById(R.id.idDailyoverviewRowDeleteButton);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mDatabaseEntry);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
        mEditImage.setOnClickListener(mListButtonClickListener);
        mCopyImage.setOnClickListener(mListButtonClickListener);
    }

    public void setDatabaseEntry(DatabaseEntry databaseEntry) {
        mListButtonClickListener.setDatabaseEntry(databaseEntry);
    }

    public TextView getNameText() {
        return mNameText;
    }

    public TextView getAmountText() {
        return mAmountText;
    }

    public TextView getCaloriesText() {
        return mCaloriesText;
    }
}
