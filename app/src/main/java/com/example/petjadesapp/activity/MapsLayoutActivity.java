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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.petjadesapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MapsLayoutActivity extends MainMenu implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap myMap;
    private double lat;
    private double lon;
    private CoordinatesDAO cdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestPermision();

        cdao = new CoordinatesDAO(this);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    public void populateMap(){
        ArrayList<Coordinate> coordinatesList = cdao.getCoordinatesList();
        Log.d("kk3", "mapready: " + coordinatesList.size());
        for (int i = 0; i < coordinatesList.size(); i++) {
            if(coordinatesList.get(i).isVisible() || getmAuth().getCurrentUser().getUid() == coordinatesList.get(i).getUser()) {
                myMap.addMarker(new MarkerOptions().position(new LatLng(coordinatesList.get(i).getLat(), coordinatesList.get(i).getLon()))
                        .title("User: Menganito \n Date: " + coordinatesList.get(i).getDate()));
            }

        /*
            listenerCheckbox
            if(checkboxVisible.activat){
                for (int i = 0; i < coordinatesList.size(); i++) {
                    if(getmAuth().getCurrentUser().getUid() == coordinatesList.get(i).getUser()) {
                        myMap.clear();
                        myMap.addMarker(new MarkerOptions().position(new LatLng(coordinatesList.get(i).getLat(), coordinatesList.get(i).getLon())));
                    }
            }
        */
            //map.addMarker(new MarkerOptions().position(mark).title("User: " + coordinatesList.get(i).getDate()));
            //map.moveCamera(CameraUpdateFactory.newLatLng(mark));
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        myMap = map;
        mapView.onResume();
        cdao.getCoordinates();
    }


    public void showDialog(View view) {
        //ACI PRIMER AGAFA LES COORDENADES PER THREAD
        placeOnPosition();
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MapsLayoutActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.content_alert_dialog, null);
        mBuilder.setTitle(R.string.title_dialog);
        Spinner mSp = mView.findViewById(R.id.spAnimal);
        RadioButton rbYes = mView.findViewById(R.id.rbYes);
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
                    String animal = mSp.getSelectedItem().toString();
                    String date = getDate();
                    boolean visible = rbYes.isChecked();
                    String userId = getmAuth().getCurrentUser().getUid();

                    Log.d("kk1", "animal: "+animal+", rb: " + visible);

                    Coordinate c = new Coordinate();
                    c.setAnimal(animal);
                    c.setDate(date);
                    c.setVisible(visible);
                    c.setLon(lon);
                    c.setLat(lat);
                    c.setUser(userId);
                    cdao.pushValue(c);
                }
            }
        });
        mBuilder.setNegativeButton(R.string.cancel_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public String getDate(){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        return formattedDate;
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
                lon = location.getLongitude();
                lat = location.getLatitude();
                addMap(lon, lat);
            }else{
                locationManager.requestLocationUpdates(bestProvider, 1000, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location loc) {
                        locationManager.removeUpdates(this);
                        lon = loc.getLongitude();
                        lat = loc.getLatitude();
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
                lon = location.getLongitude();
                lat = location.getLatitude();
                addMap(lon, lat);
            }else{
                locationManager.requestLocationUpdates(bestProvider, 1000, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location loc) {
                        locationManager.removeUpdates(this);
                        lon = loc.getLongitude();
                        lat = loc.getLatitude();
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
