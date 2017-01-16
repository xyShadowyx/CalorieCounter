package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntity;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<DatabaseGroceriesEntity> mDatabaseGroceriesEntities;
    private ArrayList<DatabaseGroceriesEntity> mFilteredDatabaseGroceriesEntities;
    private Filter mFilter;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;
        mContext = mData.getActivity().getApplicationContext();
        mDatabaseGroceriesEntities = mData.getDatabaseGroceriesEntityList();
        mFilter = new GroceriesEntityFilter(mDatabaseGroceriesEntities, this);
        mFilteredDatabaseGroceriesEntities = mDatabaseGroceriesEntities;

        Log.d("Dabug", "Init");
    }

    public void setFilteredDatabaseGroceriesEntities(ArrayList<DatabaseGroceriesEntity> filteredDatabaseGroceriesEntities) {
        mFilteredDatabaseGroceriesEntities = filteredDatabaseGroceriesEntities;
        notifyDataSetChanged();
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("Dabug", "Click");
        GroceriesEntity clickedItem = (GroceriesEntity) getItem(i);
        mApplicationLogic.onItemSelected(clickedItem);
    }

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

    @Override
    public Filter getFilter() {
        return mFilter;
    }
}