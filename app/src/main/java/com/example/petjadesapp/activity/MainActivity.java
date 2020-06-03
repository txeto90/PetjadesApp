package com.example.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.petjadesapp.R;

import java.util.ArrayList;

public class MainActivity extends MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressWarnings("unused")
    public void goToAnimalsListActivity(View view){
        startActivity(new Intent(this, AnimalsListActivity.class));
    }

    @SuppressWarnings("unused")
    public void goToDicotomicActivity(View view){
        Intent intent = new Intent(this, DichotomousKeyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    public void goToAboutActivity(View view){
        startActivity(new Intent(this, AboutActivity.class));
    }

    public void goToCameraActivity(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        ArrayList<String> nameImages = getImagesName();
        intent.putExtra("imgFootPrint", nameImages);
        startActivity(intent);
    }

    public void goToMapsActivity(View view){
        startActivity(new Intent(this, MapsLayoutActivity.class));
    }
}
