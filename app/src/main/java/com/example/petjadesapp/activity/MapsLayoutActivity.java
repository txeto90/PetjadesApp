package com.example.petjadesapp.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.petjadesapp.dao.AnimalsDAO;
import com.example.petjadesapp.dao.CoordinatesDAO;
import com.example.petjadesapp.model.Coordinate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.petjadesapp.R;

import java.util.ArrayList;
import java.util.List;

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

        Button btnSave = findViewById(R.id.button);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mapView.onResume();
    }


    public void showDialog(View view){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MapsLayoutActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.content_alert_dialog, null);
        mBuilder.setTitle(R.string.title_dialog);
        Spinner mSp = mView.findViewById(R.id.spAnimal);
        AnimalsDAO adao = new AnimalsDAO(this);
        List<String> spinnerArray = adao.getAnimalsNames();
        spinnerArray.add(0, getString(R.string.spinerselection_dialog));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MapsLayoutActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerArray
        );
        mSp.setAdapter(adapter);
        mBuilder.setPositiveButton(R.string.ok_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!mSp.getSelectedItem().toString().equalsIgnoreCase("")){
                    Log.d("kk2", "AGAFAR DADES");
                    //AGAFAR DADES I GUARDARLES
                }
            }
        });
        mBuilder.setNegativeButton(R.string.cancel_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Log.d("kk2", "CANCELAR");
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

}
