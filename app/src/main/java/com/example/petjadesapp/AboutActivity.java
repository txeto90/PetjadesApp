package com.example.petjadesapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView txtPhoto;
    private String author = "Jakob Fahr \nCesar Pollo \nAloma Alcina \nFrank Sengpiel \nTomeu Bosch \n Benoit Nabholz \nJeff Skrentny \nJupreudhomme \n" +
            "Andy Bridges \nBill Palmer \nRoberto Ghiglia \nPaul Cools \nAlejandro Garrido \nLauren Glevanik \nAnnika Lindqvist \n" +
            "Setbusch \nRonald Werson \nPeter Trimming \nSamuel Faure \nMax Hofmann \nDee Doubleu \nSkyrk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtPhoto = findViewById(R.id.txtPhotos);
        txtPhoto.setText(author);






    }

}
