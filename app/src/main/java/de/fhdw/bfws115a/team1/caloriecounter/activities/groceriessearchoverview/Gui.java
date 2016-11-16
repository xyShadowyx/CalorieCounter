package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TextView;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private SearchView mSearchView;
    private ListView mListView;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_groceriessearchoverview);

        mSearchView = (SearchView) activity.findViewById(R.id.idSearchView);
        mListView = (ListView) activity.findViewById(R.id.idListView);
    }

    public ListView getListView() {
        return mListView;
    }

    public SearchView getSearchView() {
        return mSearchView;
    }
}
