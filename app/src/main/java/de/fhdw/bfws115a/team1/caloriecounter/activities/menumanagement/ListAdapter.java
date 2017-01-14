package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* Member variables */
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

    /**
     * Counts the quantity of FixGroceryEntities in a list.
     *
     * @return The quantity of filtered groceries entities.
     */
    @Override
    public int getCount() {
        return mFixGroceryEntities.size();
    }

    /**
     * Gets the selected FixGroceryEntity item from an ArrayList.
     *
     * @param i The position of the FixGroceryEntity which should be retrieved.
     * @return The FixGroceryEntity.
     */
    @Override
    public Object getItem(int i) {
        return mFixGroceryEntities.get(i);
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
     * //TODO Löschen?
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }

    /**
     * //TODO Was macht diese Methode?
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        FixGrocery fixGroceryEntity;
        fixGroceryEntity = (FixGrocery) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.menumanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setFixGroceryEntity(fixGroceryEntity);
        listViewHolder.getNameText().setText(
                String.format("%s (%.2f %s)", fixGroceryEntity.getName(), fixGroceryEntity.getAmount(), fixGroceryEntity.getUnit().getName()));
        return convertView;
    }
}