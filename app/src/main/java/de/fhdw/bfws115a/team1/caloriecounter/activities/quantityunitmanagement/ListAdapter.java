package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Florian Obladen.
 */

public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<DatabaseUnit> mQuantityUnitEntities;
    /* Member variables */
    private Data mData;
    private ApplicationLogic mApplicationLogic;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mQuantityUnitEntities = mData.getQuantityUnits();
    }

    /**
     * Counts the number of quantity unit entities.
     *
     * @return The size of the ArrayList which contains quantity unit entities.
     */
    @Override
    public int getCount() {
        return mQuantityUnitEntities.size();
    }

    /**
     * Gets the selected quantity unit entity from an ArrayList.
     *
     * @param i The position of the quantity unit entity which should be retrieved.
     * @return The quantity unit entity.
     */
    @Override
    public Object getItem(int i) {
        return mQuantityUnitEntities.get(i);
    }

    /**
     * Gets a specific quantity unit entity item ID.
     *
     * @param i The position of the quantity unit entity which ID should be retrieved.
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
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        DatabaseUnit databaseUnit;
        databaseUnit = (DatabaseUnit) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.quantityunitmanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setDatabaseUnit(databaseUnit);
        listViewHolder.getNameText().setText(String.format("%s", databaseUnit.getName()));

        if (Arrays.asList(mContext.getResources().getStringArray(R.array.undeletable_units)).contains(databaseUnit.getName())) {
            listViewHolder.getDeleteImage().setVisibility(View.INVISIBLE);
        } else {
            listViewHolder.getDeleteImage().setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}