package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    /* Member variables */
    private TextView mTodayDateText;
    private ImageView mPrevDayButton;
    private ImageView mNextDayButton;
    private ImageView mUnitQuantityButton;
    private ImageView mMenuButton;
    private ImageView mGroceryButton;
    private ImageView mNewEntryButton;
    private ListView mEntryListView;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.dailyoverview);

        mTodayDateText = (TextView) activity.findViewById(R.id.idDailyoverviewDate);
        mPrevDayButton = (ImageView) activity.findViewById(R.id.idDailyOverviewPreviousday);
        mNextDayButton = (ImageView) activity.findViewById(R.id.idDailyoverviewNextday);
        mUnitQuantityButton = (ImageView) activity.findViewById(R.id.idDailyoverviewSpoonButton);
        mMenuButton = (ImageView) activity.findViewById(R.id.idDailyoverviewMenuButton);
        mGroceryButton = (ImageView) activity.findViewById(R.id.idDailyoverviewGroceryButton);
        mEntryListView = (ListView) activity.findViewById(R.id.idDailyoverviewList);

        mNewEntryButton = (ImageView) activity.findViewById(R.id.idDailyoverviewAddNewEntry);
    }

    /* Getter methods*/
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

    public ImageView getNewEntryButton() {
        return mNewEntryButton;
    }

    /* Setter methods */
    public void setDate(int day, int month, int year) {
        mTodayDateText.setText(day + "." + (month + 1) + "." + year);
    }
}