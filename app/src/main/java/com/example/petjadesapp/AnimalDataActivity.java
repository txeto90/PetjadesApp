package com.example.petjadesapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnimalDataActivity extends MainMenu {

    TextView txtIndexTitle;
    TextView txtVulgar;
    TextView txtScientific;
    TextView txtDescription;
    ImageButton ibInfo;
    ImageButton ibHabitat;
    ImageButton ibRastre;
    ImageButton ibDistribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtIndexTitle = findViewById(R.id.txtViewIndex);
        txtVulgar = findViewById(R.id.txtViewVulgarName);
        txtScientific = findViewById(R.id.txtViewScientificName);
        txtDescription = findViewById(R.id.txtViewInformation);
        ibInfo = findViewById(R.id.ibDescription);
        ibHabitat = findViewById(R.id.ibHabitat);
        ibDistribution = findViewById(R.id.ibDistribution);
        ibRastre = findViewById(R.id.ibRastros);

        getDataFromAnimal();

    }

    //AGAFA LES DADES ENVIADES PER EL INTENT I LES MOSTRA EN ELS SEUS RESPECTIUS CAMPS
    private void getDataFromAnimal(){
        Bundle extras = getIntent().getExtras();
        String vulgarName = extras.getString("vulgarName");
        String scientificName = extras.getString("scientificName");
        String description = extras.getString("description");

        txtVulgar.setText(vulgarName);
        txtScientific.setText(scientificName);
        txtIndexTitle.setText("Descripción");
        txtDescription.setText(description);
    }

    public void showInfo(View view){
        Bundle extras = getIntent().getExtras();
        String description = extras.getString("description");
        txtIndexTitle.setText("Descripción");
        txtDescription.setText(description);
    }

    public void showHabitat(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("habitat");
        txtIndexTitle.setText("Hábitat");
        txtDescription.setText(habitat);
    }

}
