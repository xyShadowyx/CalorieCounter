package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;

import java.util.ArrayList;

/**
 * @author Viktor Schroeder
 */
public class ListAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<DatabaseEntry> mDatabaseEntries;
    private Data mData;
    private ApplicationLogic mApplicationLogic;

    /**
     * Constructor
     *
     * @param data
     * @param applicationLogic
     */
    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;
        mContext = mData.getActivity().getApplicationContext();
        mDatabaseEntries = mData.getDatabaseEntryList();
    }

    /**
     * Counts the quantity of filtered groceries in a list.
     *
     * @return The quantity of filtered groceries entities.
     */
    @Override
    public int getCount() {
        return mDatabaseEntries.size();
    }

    /**
     * Gets the selected grocery entity from an ArrayList.
     *
     * @param i The position of the grocery entity which should be retrieved.
     * @return The grocery entity.
     */
    @Override
    public Object getItem(int i) {
        return mDatabaseEntries.get(i);
    }

    /**
     * Gets a specific grocery entity item ID.
     *
     * @param i The position of the grocery entity which ID should be retrieved.
     * @return The ID.
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Gets the layout of one list entry and fills it with additional list items.
     * If it's not issued yet, it creates one.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view is wanted.
     * @param convertView The view which should be get.
     * @param parent      The parent view.
     * @return The Layout of one list entry.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        DatabaseEntry databaseEntry;
        databaseEntry = (DatabaseEntry) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.dailyoverview_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }
        listViewHolder.setDatabaseEntry(databaseEntry);
        listViewHolder.getNameText().setText(String.format("%s", databaseEntry.getName()));
        listViewHolder.getAmountText().setText(String.format("%.2f %s", databaseEntry.getAmount(), databaseEntry.getUnitName()));
        listViewHolder.getCaloriesText().setText(String.format("%d %s", databaseEntry.getCalories(), "kcal"));
        return convertView;
    }
}