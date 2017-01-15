package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.Filter;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

import java.util.ArrayList;

/**
 * Created by xySha on 14.01.2017.
 */
public class GroceriesEntityFilter extends Filter {
    private ArrayList<GroceriesEntity> mGroceriesEntities;
    private ListAdapter mListAdapter;

    public GroceriesEntityFilter(ArrayList<GroceriesEntity> groceriesEntities, ListAdapter listAdapter) {
        mGroceriesEntities = groceriesEntities;
        mListAdapter = listAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        String filterString;
        FilterResults results;
        final ArrayList<GroceriesEntity> list;
        final ArrayList<GroceriesEntity> nlist;
        GroceriesEntity filterableGroceriesEntry;

        filterString = constraint.toString().toLowerCase();
        results = new FilterResults();
        list = mGroceriesEntities;
        int count = list.size();
        nlist = new ArrayList<GroceriesEntity>(count);

        for (int i = 0; i < count; i++) {
            filterableGroceriesEntry = list.get(i);
            if (filterableGroceriesEntry.getName().toLowerCase().contains(filterString)) {
                nlist.add(filterableGroceriesEntry);
            }
        }
        results.values = nlist;
        results.count = nlist.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mListAdapter.setFilteredGroceriesEntities((ArrayList<GroceriesEntity>) results.values);
    }
}
