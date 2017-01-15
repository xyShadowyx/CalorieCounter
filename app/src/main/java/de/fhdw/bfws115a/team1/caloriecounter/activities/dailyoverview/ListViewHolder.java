package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntity;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mCopyImage;
    private ImageView mMoveImage;
    private ImageView mDeleteImage;
    private ImageView mEditImage;

    private DatabaseEntry mDatabaseEntry;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mDatabaseEntry = null;

        mNameText = (TextView) view.findViewById(R.id.idDailyoverviewGrocery);
        mCopyImage = (ImageView) view.findViewById(R.id.idDailyoverviewCopyButton);
        mMoveImage = (ImageView) view.findViewById(R.id.idDailyoverviewCopyButton);
        mEditImage = (ImageView) view.findViewById(R.id.idDailyoverviewSettingButton);
        mDeleteImage = (ImageView) view.findViewById(R.id.idDailyoverviewDeleteButton);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mDatabaseEntry);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
        mEditImage.setOnClickListener(mListButtonClickListener);
    }

    public void setDatabaseEntry(DatabaseEntry databaseEntry) {
        mListButtonClickListener.setDatabaseEntry(databaseEntry);
    }

    public TextView getNameText() {
        return mNameText;
    }
}
