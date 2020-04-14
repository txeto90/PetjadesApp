package com.example.petjadesapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import logic.AnimalsListActivity;

public class MainActivity extends MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }

    public void goToAnimalsListActivity(View view){
        Intent intent = new Intent(this, AnimalsListActivity.class);
        startActivity(intent);
    }

    public void goToDicotomicActivity(View view){
        Intent intent = new Intent(this, DichotomousKeyActivity.class);
        startActivity(intent);
    }

    public void goToAboutActivity(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
