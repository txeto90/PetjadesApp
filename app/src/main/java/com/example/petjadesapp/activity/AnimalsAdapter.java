package com.example.petjadesapp.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.petjadesapp.R;
import com.example.petjadesapp.dao.ImagesDAO;
import com.example.petjadesapp.model.Animal;

import java.io.InputStream;
import java.util.List;

class AnimalsAdapter extends ArrayAdapter implements Filterable {

    @SuppressWarnings("unchecked")
    public AnimalsAdapter(Context context, List objects){
        super(context, 0, objects);
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



}
