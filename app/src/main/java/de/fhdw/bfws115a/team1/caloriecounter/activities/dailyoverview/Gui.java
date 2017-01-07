package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.fhdw.bfws115a.team1.caloriecounter.R;

import java.util.List;

public class Gui {
    private TextView mTodayDateText;
    private ImageView mPrevDayButton;
    private ImageView mNextDayButton;
    private ImageView mUnitQuantityButton;
    private ImageView mMenuButton;
    private ImageView mGroceryButton;
    private ListView mEntryListView;

    public Gui(Init activity) {
        activity.setContentView(R.layout.dailyoverview_listview);

        mTodayDateText = (TextView) activity.findViewById(R.id.date);
        mPrevDayButton = (ImageView) activity.findViewById(R.id.previousDay);
        mNextDayButton = (ImageView) activity.findViewById(R.id.nextDay);

        mUnitQuantityButton = (ImageView) activity.findViewById(R.id.spoonButton);
        mMenuButton = (ImageView) activity.findViewById(R.id.menuButton);
        mGroceryButton = (ImageView) activity.findViewById(R.id.groceryButton);

        mEntryListView = (ListView) activity.findViewById(R.id.list);
    }

    public TextView getTodayDateText() {
        return mTodayDateText;
    }

    public ImageView getPrevDayButton() {
        return mPrevDayButton;
    }

    public ImageView getNextDayButton() {
        return mNextDayButton;
    }

    public ImageView getUnitQuantityButton() {
        return mUnitQuantityButton;
    }

    public ImageView getMenuButton() {
        return mMenuButton;
    }

    public ImageView getGroceryButton() {
        return mGroceryButton;
    }

    public ListView getEntryListView() {
        return mEntryListView;
    }

    public void setDate(int day, int month, int year) {
        mTodayDateText.setText(day+"."+(month+1)+"."+year);
    }
}
