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
    }

    @SuppressWarnings("unused")
    public void goToAnimalsListActivity(View view){
        startActivity(new Intent(this, AnimalsListActivity.class));
    }

    @SuppressWarnings("unused")
    public void goToDicotomicActivity(View view){
        startActivity(new Intent(this, DichotomousKeyActivity.class));
    }

    @SuppressWarnings("unused")
    public void goToAboutActivity(View view){
        startActivity(new Intent(this, AboutActivity.class));
    }
}
