package logic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petjadesapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

import model.Animal;

public class AnimalsAdapter extends ArrayAdapter {
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
        ImageView animalImage = convertView.findViewById(R.id.imgAnimal);
        TextView scientificName = convertView.findViewById(R.id.txtScientificName);
        TextView vulgarName = convertView.findViewById(R.id.txtVulgarName);
        //popuate the data uti te templatre view using the data object
        //animalImage.setImageResource(animal.getImage());
        scientificName.setText(animal.getScientificName());
        vulgarName.setText(animal.getVulgarName());
        //return the complete view to render on screen

        return convertView;
    }




}
