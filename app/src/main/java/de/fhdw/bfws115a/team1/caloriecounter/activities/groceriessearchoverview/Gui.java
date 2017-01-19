package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Viktor Schroeder
 */
public class Gui {

    /* Member variables */
    private SearchView mSearchView;
    private ListView mListView;
    private ImageView mAddGroceryButton;
    private ImageView mAddMenuButton;
    private TextView mEmptyListTextView;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.groceriessearchoverview);

        mSearchView = (SearchView) activity.findViewById(R.id.idGroceriesSearchOverviewSearchView);
        mListView = (ListView) activity.findViewById(R.id.idGroceriesSearchOverviewListView);
        mAddGroceryButton = (ImageView) activity.findViewById(R.id.idGroceriesSearchOverviewAddGroceryButton);
        mAddMenuButton = (ImageView) activity.findViewById(R.id.idGroceriesSearchOverviewAddMenuButton);
        mEmptyListTextView = (TextView) activity.findViewById(R.id.idGrocerySearchoverviewNoResults);
    }

    /* Getter methods */
    public ListView getListView() {
        return mListView;
    }

    public SearchView getSearchView() {
        return mSearchView;
    }

    public ImageView getAddGroceryButton() {
        return mAddGroceryButton;
    }

    public ImageView getAddMenuButton() {
        return mAddMenuButton;
    }

    public TextView getEmptyListTextView() {
        return mEmptyListTextView;
    }
}