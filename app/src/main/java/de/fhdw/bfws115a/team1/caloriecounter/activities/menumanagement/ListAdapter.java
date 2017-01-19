package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
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
     * Never used in our application.
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
        listViewHolder.getNameText().setText(fixGroceryEntity.getName());
        listViewHolder.getAmountText().setText(
                String.format("%.2f %s", fixGroceryEntity.getAmount(), fixGroceryEntity.getUnit().getName())
        );
        listViewHolder.getCaloriesText().setText(
                String.format("%d %s", fixGroceryEntity.getKcal(), "kcal")
        );
        return convertView;
    }
}