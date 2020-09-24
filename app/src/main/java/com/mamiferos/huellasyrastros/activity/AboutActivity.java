package com.mamiferos.huellasyrastros.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.mamiferos.huellasyrastros.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setSupportActionBar(findViewById(R.id.toolbar));
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView txtMaps = findViewById(R.id.txtMaps);
        TextView txtCopyRight = findViewById(R.id.txtCopyRight);
        TextView txtPhoto = findViewById(R.id.txtPhotos);
        final String author = "Virginia Amate Padilla, \tPau L. Rodriguez, \tAloma Alcina, Pau Grau, \tChristian \"Asseus\" Flach, \tLinkie.";
        txtPhoto.setText(author);
        txtMaps.setMovementMethod(LinkMovementMethod.getInstance());
        txtCopyRight.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
