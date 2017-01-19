package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.Filter;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

import java.util.ArrayList;

/**
 * @author Viktor Schroeder
 */
public class GroceriesEntityFilter extends Filter {
    private ArrayList<DatabaseGroceriesEntity> mDatabaseGroceriesEntities;
    private ListAdapter mListAdapter;

    /**
     * Constructor
     *
     * @param databaseGroceriesEntities
     * @param listAdapter
     */
    public GroceriesEntityFilter(ArrayList<DatabaseGroceriesEntity> databaseGroceriesEntities, ListAdapter listAdapter) {
        mDatabaseGroceriesEntities = databaseGroceriesEntities;
        mListAdapter = listAdapter;
    }

    /**
     * Filter List
     *
     * @param constraint filter condition
     * @return
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        String filterString;
        FilterResults results;
        final ArrayList<DatabaseGroceriesEntity> list;
        final ArrayList<DatabaseGroceriesEntity> nlist;
        DatabaseGroceriesEntity filterableDatabaseGroceriesEntity;

        filterString = constraint.toString().toLowerCase();
        results = new FilterResults();
        list = mDatabaseGroceriesEntities;
        int count = list.size();
        nlist = new ArrayList<DatabaseGroceriesEntity>(count);

        for (int i = 0; i < count; i++) {
            filterableDatabaseGroceriesEntity = list.get(i);
            if (filterableDatabaseGroceriesEntity.getName().toLowerCase().contains(filterString)) {
                nlist.add(filterableDatabaseGroceriesEntity);
            }
        }
        results.values = nlist;
        results.count = nlist.size();
        return results;
    }

    /**
     * Apply filter to list
     *
     * @param constraint
     * @param results
     */
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mListAdapter.setFilteredDatabaseGroceriesEntities((ArrayList<DatabaseGroceriesEntity>) results.values);
    }
}
