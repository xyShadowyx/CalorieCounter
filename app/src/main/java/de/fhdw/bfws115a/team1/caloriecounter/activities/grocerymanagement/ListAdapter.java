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

/**
 * @author Niklas Lammers.
 */
public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* Member variables */
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }

    /**
     * Gets the layout of one list entry and fills it with additional list items.
     * If it´s not issued yet, it creates one.
     *
     * @param position    The position of the item within the adapter´s data set of the item whose view is wanted.
     * @param convertView The view which should be get.
     * @param parent      The parent view.
     * @return The Layout of one list entry.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        GroceryUnit groceryUnit;
        groceryUnit = (GroceryUnit) getItem(position);

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

    /**
     * Counts how many GroceryUnits are within the ArrayList.
     *
     * @return
     */
    @Override
    public int getCount() {
        return mGroceryUnits.size();
    }

    /**
     * Gets one specific item from an ArrayList.
     *
     * @param i The items position.
     * @return The item which should be retrieved.
     */
    @Override
    public Object getItem(int i) {
        return mGroceryUnits.get(i);
    }

    /**
     * Gets the specific item ID which is associated with the specified position in the list.
     *
     * @param i The position of the the item in the ArrayList.
     * @return The items ID.
     */
    @Override
    public long getItemId(int i) {
        return i;
    }
}