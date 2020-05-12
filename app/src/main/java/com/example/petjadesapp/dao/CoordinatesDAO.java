package com.example.petjadesapp.dao;

import android.util.Log;
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

    public CoordinatesDAO(){
        Log.d("kk2", "constructor" );
        getCoordinates();
    }

    //myRef.setValue("Hello, World!");

    // Read from the database
    public void getCoordinates() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot coordianteSnapshot: dataSnapshot.getChildren()){
                    Coordinate coor = coordianteSnapshot.getValue(Coordinate.class);
                    coordinatesList.add(coor);
                    Log.d("kk2", "Value is: " + coor.getX());
                }
                Log.d("kk2", "dao2: "+coordinatesList.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Failed to read value
            }
        });
    }

    public ArrayList<Coordinate> getCoordinatesList() {
        return coordinatesList;
    }
}
