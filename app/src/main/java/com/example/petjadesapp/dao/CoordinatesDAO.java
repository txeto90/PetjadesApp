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
        //Log.d("kk3", "constructor" );
        getCoordinates();
    }

    // Read from the database
    private void getCoordinates() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot coordianteSnapshot: dataSnapshot.getChildren()){
                    Coordinate coor = coordianteSnapshot.getValue(Coordinate.class);
                    coordinatesList.add(coor);
                    Log.d("kk3", "Value is: " + coor.getLon());
                }
                Log.d("kk3", "dao1: "+coordinatesList.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Failed to read value
            }
        });
    }

    public void pushValue(String date, double lon, double lat){
        Coordinate c = new Coordinate();
        c.setDate(date);
        c.setLon(lon);
        c.setLat(lat);
        myRef.push().setValue(c);
    }

    public ArrayList<Coordinate> getCoordinatesList() {
        Log.d("kk3", "dao2: "+coordinatesList.size());
        return coordinatesList;
    }
}
