package com.example.petjadesapp.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.example.petjadesapp.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView txtMaps = findViewById(R.id.txtMaps);
        TextView txtCopyRight = findViewById(R.id.txtCopyRight);
        TextView txtPhoto = findViewById(R.id.txtPhotos);
        final String author = "Jakob Fahr, \tCesar Pollo, \tAloma Alcina, Pau L. Rodriguez, \tFrank Sengpiel, \tTomeu Bosch, \tBenoit Nabholz, \tJeff Skrentny, \tJupreudhomme, \t" +
                "Andy Bridges, \tBill Palmer, \tRoberto Ghiglia, \tPaul Cools, \tAlejandro Garrido, \tLauren Glevanik, \tAnnika Lindqvist, \t" +
                "Setbusch, \tRonald Werson, \tPeter Trimming, \tSamuel Faure, \tMax Hofmann, \tDee Doubleu, \tSkyrk, \tMagriet B., \tGonzalo Mucientes, \t" +
                "Carlos Bocos, \tJose Cazador, \tThierry, \tClaudia Komesu, \tJarvo, \tMarco Vicariotto.";
        txtPhoto.setText(author);
        txtMaps.setMovementMethod(LinkMovementMethod.getInstance());
        txtCopyRight.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
