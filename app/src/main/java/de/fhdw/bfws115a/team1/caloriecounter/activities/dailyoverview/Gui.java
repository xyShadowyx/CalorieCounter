package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.fhdw.bfws115a.team1.caloriecounter.R;
import org.w3c.dom.Text;

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
    private TextView mEmptyListTextView;

    private EditText mMaxCalories;
    private TextView mUsedCalories;
    private TextView mLeftCalories;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.dailyoverview);

        mTodayDateText = (TextView) activity.findViewById(R.id.idDailyoverviewDate);
        mPrevDayButton = (ImageView) activity.findViewById(R.id.idDailyOverviewPreviousDay);
        mNextDayButton = (ImageView) activity.findViewById(R.id.idDailyoverviewNextDay);
        mUnitQuantityButton = (ImageView) activity.findViewById(R.id.idDailyoverviewSpoonButton);
        mMenuButton = (ImageView) activity.findViewById(R.id.idDailyoverviewMenuButton);
        mGroceryButton = (ImageView) activity.findViewById(R.id.idDailyoverviewGroceryButton);
        mEntryListView = (ListView) activity.findViewById(R.id.idDailyoverviewListView);

        mMaxCalories = (EditText) activity.findViewById(R.id.idDailyoverviewCaloriesMax);
        mUsedCalories = (TextView) activity.findViewById(R.id.idDailyoverviewCaloriesConsumed);
        mLeftCalories = (TextView) activity.findViewById(R.id.idDailyoverviewCaloriesLeft);

        mNewEntryButton = (ImageView) activity.findViewById(R.id.idDailyoverviewAddNewEntry);

        mEmptyListTextView = (TextView) activity.findViewById(R.id.idDailyoverviewNoResults);
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

    public TextView getUsedCalories() {
        return mUsedCalories;
    }

    public TextView getMaxCalories() {
        return mMaxCalories;
    }

    public TextView getLeftCalories() {
        return mLeftCalories;
    }

    /* Setter methods */
    public void setDate(int day, int month, int year) {
        mTodayDateText.setText(String.format("%02d.%02d.%04d", day, (month + 1), year));
    }

    public void setUsedCalories(int amount) {
        mUsedCalories.setText(String.valueOf(amount));
    }

    public void setMaxCalories(int amount) {
        if(amount > 0) {
            mMaxCalories.setText(String.valueOf(amount));
        }
        else {
            mMaxCalories.setText("");
        }
    }

    public void setLeftCalories(int amount) {
        mLeftCalories.setText(String.valueOf(amount));
        if(amount < 0)
            mLeftCalories.setTextColor(Color.RED);
        else
            mLeftCalories.setTextColor(Color.GREEN);
    }

    public TextView getEmptyListTextView() {
        return mEmptyListTextView;
    }
}