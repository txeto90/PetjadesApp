package com.example.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.petjadesapp.R;

import java.util.ArrayList;



public class MainMenu extends AppCompatActivity {

    private ArrayList<String> nameImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    private void setSampleImages(){
        nameImages = new ArrayList<>();
        nameImages.add("musaranya_petjada");
        nameImages.add("topillo_petjada");
        nameImages.add("erizo_petjada");
        nameImages.add("rataagua_petjada");
        nameImages.add("rataalmizclera_petjada");
        nameImages.add("raton_petjada");
        nameImages.add("rata_petjada");
        nameImages.add("liron_petjada");
        nameImages.add("ardilla_petjada");
        nameImages.add("liebre_petjada");
        nameImages.add("conejo_petjada");
        nameImages.add("oso_petjada");
        nameImages.add("lobo_petjada");
        nameImages.add("zorro_petjada");
        nameImages.add("perro_petjada");
        nameImages.add("comadreja_petjada");
        nameImages.add("turon_petjada");
        nameImages.add("marta_petjada");
        nameImages.add("gardunya_petjada");
        nameImages.add("nutria_petjada");
        nameImages.add("tejon_petjada");
        nameImages.add("meloncillo_petjada");
        nameImages.add("gineta_petjada");
        nameImages.add("lince_petjada");
        nameImages.add("gatomontes_petjada");
        nameImages.add("jabali_petjada");
        nameImages.add("muflon_petjada");
        nameImages.add("cabra_petjada");
        nameImages.add("ciervo_petjada");
        nameImages.add("corzo_petjada");
        nameImages.add("caballo_petjada");
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
        // handle arrow click here
        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.inici) {
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
        if (id == R.id.maps) {
            Intent intent = new Intent(this, MapsLayoutActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
