package logic;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.petjadesapp.AnimalDataActivity;
import com.example.petjadesapp.MainMenu;
import com.example.petjadesapp.R;

import java.util.ArrayList;

import dao.AnimalsDAO;
import model.Animal;

public class AnimalsListActivity extends MainMenu {
    private AnimalsDAO animalsDAO;
    /*    private String[] scientificName = {
                "Vulpes vulpes",
                "Cannis lupus",
                "Raupicabra rupicabra",
                "Meles meles"};
        private String[] vulgarName = {
                "Zorro",
                "Lobo",
                "Corzo",
                "Tejon",
        };*/
    private int[] fotos = {
            R.drawable.fotozorro,
            R.drawable.fotozorro,
            R.drawable.fotozorro,
            R.drawable.fotozorro};
    private ListView myAnimalsView;
    private ArrayList<Animal> theAnimals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        animalsDAO = new AnimalsDAO(this);

        //construct data source
        final ArrayList<Animal> theAnimals = animalsDAO.getAnimals();
        //create the adapter to convert the array to views
        AnimalsAdapter adapter = new AnimalsAdapter (this, theAnimals);
        //attach the adapter to a listView
        myAnimalsView = findViewById(R.id.listViewAnimals);
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
                startActivity(intent);
            }
        });
    }

}
