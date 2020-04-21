package com.example.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;


import com.example.petjadesapp.R;



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
