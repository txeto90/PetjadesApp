package com.example.petjadesapp.activity;


import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.petjadesapp.R;

public class AboutActivity extends AppCompatActivity {

    private TextView txtPhoto;
    private TextView txtMaps;
    private TextView txtCopyRight;
    private String author = "Jakob Fahr, \tCesar Pollo, \tAloma Alcina, \tFrank Sengpiel, \tTomeu Bosch, \tBenoit Nabholz, \tJeff Skrentny, \tJupreudhomme, \t" +
            "Andy Bridges, \tBill Palmer, \tRoberto Ghiglia, \tPaul Cools, \tAlejandro Garrido, \tLauren Glevanik, \tAnnika Lindqvist, \t" +
            "Setbusch, \tRonald Werson, \tPeter Trimming, \tSamuel Faure, \tMax Hofmann, \tDee Doubleu, \tSkyrk, \tMagriet B., \tGonzalo Mucientes, \t" +
            "Carlos Bocos, \tJose Cazador, \tThierry, \tClaudia Komesu, \tJarvo, \tMarco Vicariotto.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtMaps = findViewById(R.id.txtMaps);
        txtCopyRight = findViewById(R.id.txtCopyRight);
        txtPhoto = findViewById(R.id.txtPhotos);
        txtPhoto.setText(author);
        txtMaps.setMovementMethod(LinkMovementMethod.getInstance());
        txtCopyRight.setMovementMethod(LinkMovementMethod.getInstance());





    }

}
