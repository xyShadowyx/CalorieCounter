package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    /* Member variables */
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<GroceriesEntity> mGroceriesEntities;
    private ArrayList<GroceriesEntity> mFilteredGroceriesEntities;
    private Filter mFilter;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mGroceriesEntities = mData.getGroceriesEntityList();

        mFilter = new GroceriesEntityFilter();
        mFilteredGroceriesEntities = mGroceriesEntities;
    }

    /**
     * Counts the quantity of filtered groceries.
     *
     * @return The quantity of filtered groceries entities.
     */
    @Override
    public int getCount() {
        return mFilteredGroceriesEntities.size();
    }

    /**
     * Gets the selected grocery entity from an ArrayList.
     *
     * @param i The position of the grocery entity which should be retrieved.
     * @return The grocery entity.
     */
    @Override
    public Object getItem(int i) {
        return mFilteredGroceriesEntities.get(i);
    }

    /**
     * Gets a specific grocery entity item ID.
     *
     * @param i The position of the grocery unit entity which ID should be retrieved.
     * @return The ID.
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    //TODO Was ist das für eine Methode?
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.groceriessearchoverview_listrow, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GroceriesEntity groceryEnity = (GroceriesEntity) getItem(position);
        viewHolder.nameText.setText(String.format("%s", groceryEnity.getName()));
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    //TODO Was macht diese Methode?
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        GroceriesEntity clickedItem = (GroceriesEntity) getItem(i);
        mApplicationLogic.onItemSelected(clickedItem);
    }

    //TODO Löschen?
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("onItemSelected: ", "onItemSelected!!!");
    }

    //TODO Löschen?
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d("onNothingSelected: ", "onNothingSelected!!!");
    }

    //TODO Neue Klasse? Doc muss noch eingerichtet werden!
    private class GroceriesEntityFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();

            final ArrayList<GroceriesEntity> list = mGroceriesEntities;

            int count = list.size();
            final ArrayList<GroceriesEntity> nlist = new ArrayList<GroceriesEntity>(count);

            GroceriesEntity filterableGroceriesEntry;

            for (int i = 0; i < count; i++) {
                filterableGroceriesEntry = list.get(i);
                if (filterableGroceriesEntry.getName().toLowerCase().contains(filterString)) {
                    nlist.add(filterableGroceriesEntry);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredGroceriesEntities = (ArrayList<GroceriesEntity>) results.values;
            notifyDataSetChanged();
        }
    }

    private class ViewHolder {
        TextView nameText;
        ImageView editImage;
        ImageView deleteImage;

        public ViewHolder(View view) {
            nameText = (TextView) view.findViewById(R.id.idGroceriesSearchOverviewGrocery);
            editImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewSettingButton);
            deleteImage = (ImageView) view.findViewById(R.id.idGroceriesSearchOverviewDeleteButton);
        }
    }
}