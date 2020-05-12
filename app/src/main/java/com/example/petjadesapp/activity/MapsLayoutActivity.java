package com.example.petjadesapp.activity;

import android.os.Bundle;

import com.example.petjadesapp.dao.CoordinatesDAO;
import com.example.petjadesapp.model.Coordinate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import com.example.petjadesapp.R;

import java.util.ArrayList;

public class MapsLayoutActivity extends MainMenu implements OnMapReadyCallback{

    private MapView mapView;
    private ArrayList<Coordinate> coordinatesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        CoordinatesDAO c = new CoordinatesDAO();
        coordinatesList = c.getCoordinatesList();
        Log.d("kk2", coordinatesList.size()+"");
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
