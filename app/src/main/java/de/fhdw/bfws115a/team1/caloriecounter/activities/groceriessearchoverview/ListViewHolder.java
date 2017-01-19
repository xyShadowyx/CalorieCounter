package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

/**
 * @author Viktor Schroeder
 */
public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;
    private ImageView mEditImage;

    private DatabaseGroceriesEntity mDatabaseGroceriesEntity;

    /**
     * Connects view elements from frontend with backend variables.
     * Reasons are modifying options in backend later on.
     *
     * @param view             The view where the elements are in.
     * @param applicationLogic ApplicationLogic instance.
     */
    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mDatabaseGroceriesEntity = null;

        mNameText = (TextView) view.findViewById(R.id.idGroceriesSearchOverviewRowGrocery);
        mDeleteImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewRowDeleteButton);
        mEditImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewRowSettingButton);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mDatabaseGroceriesEntity);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
        mEditImage.setOnClickListener(mListButtonClickListener);
    }

    /* Setter methods */
    public void setDatabaseGroceriesEntity(DatabaseGroceriesEntity databaseGroceriesEntity) {
        mListButtonClickListener.setDatabaseGroceriesEntity(databaseGroceriesEntity);
    }

    /* Getter methods */
    public TextView getNameText() {
        return mNameText;
    }
}
