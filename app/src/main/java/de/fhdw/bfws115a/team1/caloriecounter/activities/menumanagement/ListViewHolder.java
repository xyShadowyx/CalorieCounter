package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;

public class ListViewHolder {

    private FixGrocery mFixGrocery;
    private ApplicationLogic mApplicationLogic;

    private TextView mNameText;
    private ImageView mDeleteImage;

    public ListViewHolder(View view, ApplicationLogic applicationLogic, FixGrocery fixGrocery) {
        mApplicationLogic = applicationLogic;
        mFixGrocery = fixGrocery;

        mNameText = (TextView) view.findViewById(R.id.idMenuManagementLastAdd);
        mDeleteImage = (ImageView) view.findViewById(R.id.idMenuManagementDeleteGrocery);

        initListener();
    }

    private void initListener(){
        ListButtonClickListener lbcl = new ListButtonClickListener(mApplicationLogic, mFixGrocery);
        mDeleteImage.setOnClickListener(lbcl);
    }

    public FixGrocery getFixGrocery() {
        return mFixGrocery;
    }

    public TextView getNameText() {
        return mNameText;
    }
}
