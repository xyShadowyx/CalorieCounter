package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<FixGrocery> mFixGroceryEntities;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mFixGroceryEntities = mData.getMenuFixGroceries();
    }

    @Override
    public int getCount() {
        return mFixGroceryEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return mFixGroceryEntities.get(i);
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
        FixGrocery fixGroceryEntity = (FixGrocery) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.menumanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setFixGroceryEntity(fixGroceryEntity);
        listViewHolder.getNameText().setText(
                String.format("%s (%.2f %s)", fixGroceryEntity.getName(), fixGroceryEntity.getAmount(), fixGroceryEntity.getUnit().getName())
        );
        return convertView;
    }
}