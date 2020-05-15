package com.example.petjadesapp.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.petjadesapp.dao.AnimalsDAO;
import com.example.petjadesapp.dao.CoordinatesDAO;
import com.example.petjadesapp.model.Coordinate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.petjadesapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MapsLayoutActivity extends MainMenu implements OnMapReadyCallback {

    private MapView mapView;
    private ArrayList<Coordinate> coordinatesList;
    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestPermision();

        CoordinatesDAO c = new CoordinatesDAO();
        coordinatesList = c.getCoordinatesList();

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //coordinatesList = c.getCoordinatesList();
        myMap = map;
        Log.d("kk3", "mapready: " + coordinatesList.size());
        for (int i = 0; i < coordinatesList.size(); i++) {
            map.addMarker(new MarkerOptions().position(new LatLng(coordinatesList.get(i).getLon(), coordinatesList.get(i).getLat()))
                    .title("User: Menganito \n Date: " + coordinatesList.get(i).getDate()));

            //LatLng mark = new LatLng(coordinatesList.get(i).getX(), coordinatesList.get(i).getY());
            Log.d("kk3", "latlong: " + coordinatesList.get(i).getLon() + ", " + coordinatesList.get(i).getLat());
            //map.addMarker(new MarkerOptions().position(mark).title("User: " + coordinatesList.get(i).getDate()));
            //map.moveCamera(CameraUpdateFactory.newLatLng(mark));
        }
        mapView.onResume();
    }


    public void showDialog(View view) {
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
                if (!mSp.getSelectedItem().toString().equalsIgnoreCase("")) {
                    //AGAFAR DADES I GUARDARLES
                    placeOnPosition();
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

    public void placeOnPosition() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.d("kk2", "kk");
        Criteria criteria = new Criteria();
        String bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true)).toString();

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location != null) {
                double lon = location.getLongitude();
                double lat = location.getLatitude();
                addMap(lon, lat);
            }else{
                locationManager.requestLocationUpdates(bestProvider, 1000, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location loc) {
                        locationManager.removeUpdates(this);
                        double lon = loc.getLongitude();
                        double lat = loc.getLatitude();
                        addMap(lon, lat);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });
            }

        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location != null) {
                double lon = location.getLongitude();
                double lat = location.getLatitude();
                addMap(lon, lat);
            }else{
                locationManager.requestLocationUpdates(bestProvider, 1000, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location loc) {
                        locationManager.removeUpdates(this);
                        double lon = loc.getLongitude();
                        double lat = loc.getLatitude();
                        addMap(lon, lat);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });
            }
        }

    }


    private void requestPermision(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

    private void addMap(double lon, double lat){
        myMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)));
    }

}
