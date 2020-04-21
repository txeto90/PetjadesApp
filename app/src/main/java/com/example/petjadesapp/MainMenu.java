package com.example.petjadesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import logic.AnimalsListActivity;

public class MainMenu extends AppCompatActivity {

    private ArrayList<String> nameImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void setSampleImages(){
        nameImages = new ArrayList<>();
        nameImages.add("ardilla_petjada");
        nameImages.add("comadreja_petjada");
        nameImages.add("conejo_petjada");
        nameImages.add("erizoeuropeo_petjada");
        nameImages.add("erizomoruno_petjada");
        nameImages.add("gardunya_petjada");
        nameImages.add("gatomontes_petjada");
        nameImages.add("gineta_petjada");
        nameImages.add("liebre_petjada");
        nameImages.add("lince_petjada");

        Log.d("kk", String.valueOf(nameImages.size()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.animalList) {
            Intent intent = new Intent(this, AnimalsListActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.dichotomous) {
            Intent intent = new Intent(this, DichotomousKeyActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.camera) {
            Intent intent = new Intent(this, CameraActivity.class);
            setSampleImages();
            intent.putExtra("imgFootPrint", nameImages);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
