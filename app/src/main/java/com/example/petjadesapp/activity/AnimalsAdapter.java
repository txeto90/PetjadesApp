package com.example.petjadesapp.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petjadesapp.R;
import com.example.petjadesapp.dao.ImagesDAO;
import com.example.petjadesapp.model.Animal;

import java.util.ArrayList;
import java.util.List;

class AnimalsAdapter extends ArrayAdapter implements Filterable {

    private Filter filter;
    private List objects;

    @SuppressWarnings("unchecked")
    public AnimalsAdapter(Context context, List objects){
        super(context, 0, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get data item for this position
        Animal animal = (Animal) getItem(position);
        //check if an existing view is being reused, otherwise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }
        //lookup view for data population
        TextView scientificName = convertView.findViewById(R.id.txtScientificName);
        TextView vulgarName = convertView.findViewById(R.id.txtVulgarName);
        ImageView imgAnimal = convertView.findViewById(R.id.imgAnimallist);
        //popuate the data uti te templatre view using the data object
        scientificName.setText(animal.getScientificName());
        vulgarName.setText(animal.getVulgarName());
        ImagesDAO.getImageFromAssets(animal.getImgAnimal(), imgAnimal, this.getContext());

        //return the complete view to render on screen
        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new AppFilter<Animal>(objects);
        return filter;
    }

    private class AppFilter<T> extends Filter {

        private ArrayList<T> sourceObjects;

        public AppFilter(List<T> objects) {
            sourceObjects = new ArrayList<T>();
            synchronized (this) {
                sourceObjects.addAll(objects);
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence chars) {
            String filterSeq = chars.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<T> filter = new ArrayList<T>();

                for (T object : sourceObjects) {
                    // the filtering itself:
                    if (object.toString().toLowerCase().contains(filterSeq))
                        filter.add(object);
                }
                result.count = filter.size();
                result.values = filter;
            } else {
                // add all objects
                synchronized (this) {
                    result.values = sourceObjects;
                    result.count = sourceObjects.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            ArrayList<T> filtered = (ArrayList<T>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = filtered.size(); i < l; i++)
                add((Animal) filtered.get(i));
            notifyDataSetInvalidated();
        }
    }
}
