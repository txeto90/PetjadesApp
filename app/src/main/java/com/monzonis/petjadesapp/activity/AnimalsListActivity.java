package com.monzonis.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.monzonis.petjadesapp.R;
import com.monzonis.petjadesapp.dao.AnimalsDAO;
import com.monzonis.petjadesapp.model.Animal;
import java.util.ArrayList;
import java.util.Collections;

public class AnimalsListActivity extends MainMenu {

    //private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animals_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
 */
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        AnimalsDAO animalsDAO = new AnimalsDAO(this);

        //construct data source
        final ArrayList<Animal> theAnimals = animalsDAO.getAnimals();
        Collections.sort(theAnimals, Animal.VulgarName);
        //Collections.sort(theAnimals, Animal.ScientificName);

        //create the adapter to convert the array to views
        AnimalsAdapter adapter = new AnimalsAdapter (this, theAnimals);
        ListView myAnimalsView = findViewById(R.id.listViewAnimals);
        myAnimalsView.setAdapter(adapter);

        myAnimalsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ENVIEM LES DADES DE L'ANIMAL AMB INTENT PER A REBRELES EN LA SEGUENT ACTIVITY
                Intent intent = new Intent(AnimalsListActivity.this, AnimalDataActivity.class);
                intent.putExtra("vulgarName", theAnimals.get(position).getVulgarName());
                intent.putExtra("scientificName", theAnimals.get(position).getScientificName());
                intent.putExtra("description", theAnimals.get(position).getDescription());
                intent.putExtra("habitat", theAnimals.get(position).getHabitat());
                intent.putExtra("distribution", theAnimals.get(position).getDistribution());
                intent.putExtra("trace", theAnimals.get(position).getTrace());
                intent.putExtra("imgFootPrint", theAnimals.get(position).getImgFootprint());
                intent.putExtra("imgAnimal", theAnimals.get(position).getImgAnimal());
                startActivity(intent);
            }
        });
        EditText txtSearch = findViewById(R.id.txtSearch);
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);
            }
        });
    }

}
