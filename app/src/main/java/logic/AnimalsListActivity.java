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
            R.drawable.zorro,
            R.drawable.zorro,
            R.drawable.zorro,
            R.drawable.zorro};
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
        ArrayList<Animal> theAnimals = animalsDAO.getAnimals();
/*        ArrayList<Animal> myAnimals = new ArrayList<Animal> ();
        for (int i = 0; i < vulgarName.length; i++){ //pregunta: perque si pose books.size() en compte de 4 no funciona?
            Animal aux = new Animal(scientificName[i],vulgarName[i], fotos[i]);
            //add to arraylist
            myAnimals.add(aux);
        }*/
        //create the adapter to convert the array to views
        AnimalsAdapter adapter = new AnimalsAdapter (this, theAnimals);
        //attach the adapter to a listView
        myAnimalsView = findViewById(R.id.listViewAnimals);
        myAnimalsView.setAdapter(adapter);

        myAnimalsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AnimalsListActivity.this, AnimalDataActivity.class);
                startActivity(intent);
                //buildDialog(scientificName[position], "Autor: " + vulgarName[position], position);
            }
        });
    }

    //Out from onCreated
/*    public void buildDialog(String title, String message, int position){
        final ImageView image = new ImageView((this));
        image.setImageResource(fotos[position]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.setView(image);
        builder.create();
        builder.show();
    }*/
}
