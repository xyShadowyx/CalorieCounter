package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

import java.util.ArrayList;

/**
 * @author Viktor Schroeder
 */
public class ListAdapter extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private final Context mContext;
    private final ArrayList<DatabaseGroceriesEntity> mDatabaseGroceriesEntities;
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private ArrayList<DatabaseGroceriesEntity> mFilteredDatabaseGroceriesEntities;
    private Filter mFilter;

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
        mDatabaseGroceriesEntities = mData.getDatabaseGroceriesEntityList();
        mFilter = new GroceriesEntityFilter(mDatabaseGroceriesEntities, this);
        mFilteredDatabaseGroceriesEntities = mDatabaseGroceriesEntities;
    }

    /**
     * Counts the quantity of filtered groceries in a list.
     *
     * @return The quantity of filtered groceries entities.
     */
    @Override
    public int getCount() {
        return mFilteredDatabaseGroceriesEntities.size();
    }

    /**
     * Gets the selected grocery entity from an ArrayList.
     *
     * @param i The position of the grocery entity which should be retrieved.
     * @return The grocery entity.
     */
    @Override
    public Object getItem(int i) {
        return mFilteredDatabaseGroceriesEntities.get(i);
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
     * Called when item clicked in list
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        GroceriesEntity clickedItem = (GroceriesEntity) getItem(i);
        mApplicationLogic.onItemSelected(clickedItem);
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
        DatabaseGroceriesEntity databaseGroceriesEntity;
        databaseGroceriesEntity = (DatabaseGroceriesEntity) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.groceriessearchoverview_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }
        listViewHolder.setDatabaseGroceriesEntity(databaseGroceriesEntity);
        listViewHolder.getNameText().setText(String.format("%s", databaseGroceriesEntity.getName()));
        return convertView;
    }

    /**
     * Get the filtered list
     *
     * @return
     */
    @Override
    public Filter getFilter() {
        return mFilter;
    }

    /**
     * Set filtered list
     *
     * @param filteredDatabaseGroceriesEntities
     */
    public void setFilteredDatabaseGroceriesEntities(ArrayList<DatabaseGroceriesEntity> filteredDatabaseGroceriesEntities) {
        mFilteredDatabaseGroceriesEntities = filteredDatabaseGroceriesEntities;
        notifyDataSetChanged();
    }
}