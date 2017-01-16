package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<GroceryUnit> mGroceryUnits;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mGroceryUnits = mData.getGroceryUnits();
    }

    @Override
    public int getCount() {
        return mGroceryUnits.size();
    }

    @Override
    public Object getItem(int i) {
        return mGroceryUnits.get(i);
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
        GroceryUnit groceryUnit = (GroceryUnit) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grocerymanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setGroceryUnit(groceryUnit);
        listViewHolder.getNameText().setText(
                String.format("%.2f %s", groceryUnit.getAmount(), groceryUnit.getUnit().getName())
        );
        return convertView;
    }
}