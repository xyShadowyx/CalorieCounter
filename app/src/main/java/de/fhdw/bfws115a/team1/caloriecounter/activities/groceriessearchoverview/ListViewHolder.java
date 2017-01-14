package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

public class ListViewHolder {
    private ApplicationLogic mApplicationLogic;
    private ListButtonClickListener mListButtonClickListener;

    private TextView mNameText;
    private ImageView mDeleteImage;
    private ImageView mEditImage;

    private GroceriesEntity mGroceriesEntity;

    public ListViewHolder(View view, ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
        mGroceriesEntity = null;

        mNameText = (TextView) view.findViewById(R.id.idGroceriesSearchOverviewGrocery);
        mDeleteImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewDeleteButton);
        mEditImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewSettingButton);

        mListButtonClickListener = new ListButtonClickListener(mApplicationLogic, mGroceriesEntity);
        mDeleteImage.setOnClickListener(mListButtonClickListener);
        mEditImage.setOnClickListener(mListButtonClickListener);
    }

    public void setGroceriesEntity(GroceriesEntity groceriesEntity) {
        mListButtonClickListener.setGroceriesEntity(groceriesEntity);
    }

    public TextView getNameText() {
        return mNameText;
    }
}
