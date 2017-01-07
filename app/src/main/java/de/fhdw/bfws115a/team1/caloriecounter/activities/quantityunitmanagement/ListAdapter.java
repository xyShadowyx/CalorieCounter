package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<DatabaseUnit> mQuantityUnitEntities;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mQuantityUnitEntities = mData.getQuantityUnits();
    }

    @Override
    public int getCount() {
        return mQuantityUnitEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return mQuantityUnitEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        DatabaseUnit databaseUnit = (DatabaseUnit) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.quantityunitmanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setDatabaseUnit(databaseUnit);
        listViewHolder.getNameText().setText(
                String.format("%s", databaseUnit.getName())
        );
        return convertView;
    }
}