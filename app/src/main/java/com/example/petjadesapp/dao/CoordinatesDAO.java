package com.example.petjadesapp.dao;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.petjadesapp.activity.MapsLayoutActivity;
import com.example.petjadesapp.model.Coordinate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class CoordinatesDAO {

    private ArrayList <Coordinate> coordinatesList = new ArrayList<>();;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("coordinates");
    private MapsLayoutActivity mapsLayoutActivity;

    public CoordinatesDAO(MapsLayoutActivity mapsLayoutActivity){
        this.mapsLayoutActivity = mapsLayoutActivity;
    }

    // Read from the database
    public void getCoordinates(@NonNull Context context) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot coordianteSnapshot: dataSnapshot.getChildren()){
                    Coordinate coor = coordianteSnapshot.getValue(Coordinate.class);
                    coordinatesList.add(coor);
                }
                mapsLayoutActivity.populateMap();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Failed to read value
                Toast toast = Toast.makeText(context, "Error en la conexión. No se han podido cargar las huellas.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void pushValue(Coordinate c){
        myRef.push().setValue(c);
    }

    public ArrayList<Coordinate> getCoordinatesList() {
        return coordinatesList;
    }
}
