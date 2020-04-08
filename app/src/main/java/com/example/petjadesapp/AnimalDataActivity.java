package com.example.petjadesapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class AnimalDataActivity extends MainMenu {

    TextView txtIndexTitle;
    TextView txtVulgar;
    TextView txtScientific;
    TextView txtInformation;
    ImageButton ibInfo;
    ImageButton ibHabitat;
    ImageButton ibTrace;
    ImageButton ibDistribution;
    //ImageView imgAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //imgAnimal = findViewById(R.id.imgViewAnimal);
        txtIndexTitle = findViewById(R.id.txtViewIndex);
        txtVulgar = findViewById(R.id.txtViewVulgarName);
        txtScientific = findViewById(R.id.txtViewScientificName);
        txtInformation = findViewById(R.id.txtViewInformation);
        ibInfo = findViewById(R.id.ibDescription);
        ibHabitat = findViewById(R.id.ibHabitat);
        ibDistribution = findViewById(R.id.ibDistribution);
        ibTrace = findViewById(R.id.ibTrace);
//        getImagesFromFirebase();
        getDataFromAnimal();
        showImgAnimal();
    }

    //AGAFA LES DADES ENVIADES PER EL INTENT I LES MOSTRA EN ELS SEUS RESPECTIUS CAMPS
    private void getDataFromAnimal(){
        Bundle extras = getIntent().getExtras();
        String vulgarName = extras.getString("vulgarName");
        String scientificName = extras.getString("scientificName");
        String description = extras.getString("description");

        txtVulgar.setText(vulgarName);
        txtScientific.setText(scientificName);
        txtIndexTitle.setText(getString(R.string.txtIndexDescription));
        txtInformation.setText(description);
    }

    //MOSTRA LES DADES EN LES CORRESPONENTS PESTANYES
    public void showInfo(View view){
        Bundle extras = getIntent().getExtras();
        String description = extras.getString("description");
        checkImageButtons(ibInfo, ibHabitat, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexDescription));
        txtInformation.setText(description);
    }

    public void showHabitat(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("habitat");
        checkImageButtons(ibHabitat, ibInfo, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexHabitat));
        txtInformation.setText(habitat);
    }

    public void showDistribution(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("distribution");
        checkImageButtons(ibDistribution, ibInfo, ibHabitat, ibTrace);
        txtIndexTitle.setText(getString(R.string.txtIndexDistribution));
        txtInformation.setText(habitat);
    }

    public void showTrace(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("trace");
        checkImageButtons(ibTrace, ibInfo, ibHabitat, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexTrace));
        txtInformation.setText(habitat);
    }

    //POSAR IMATGE DEL ANIMAL
    private void showImgAnimal(){
        Bundle extras = getIntent().getExtras();
        String img = extras.getString("imgAnimal");
        Log.d("img", "String: " + img);
        getImagesFromFirebase(img);

    }

    //DIRECCIONA A LA CAMERAACTIVITY AMB LA PETJADA DE L'ANIMAL CORRESPONENT
    public void goToCameraActivity(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    //MARCA Y DESMARCA LES IMAGEBUTTONS DEPENENT DE LA SEUA SEL·LECCIÓ
    private void checkImageButtons(ImageButton ib, ImageButton first, ImageButton second, ImageButton third){
        ib.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(200,200,200)));
        first.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        second.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        third.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
    }

    // PASARLI EN EL EXTRA EN NOM DE LA FOTO QUE ES VOL AGAFAR
    private StorageReference mStorageRef;
    private File localFile = null;
    public void getImagesFromFirebase(String imgName){

        //FirebaseFirestore db;


/*        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);*/

        mStorageRef = FirebaseStorage.getInstance().getReference();


        StorageReference riversRef = mStorageRef.child(imgName);
        //download

        try {
            localFile = File.createTempFile("images", "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        System.out.println("on sucses");
                        Log.d("caca", "onsucces");
                        ImageView animalImage = findViewById(R.id.imgViewAnimal);
                        animalImage.setImageURI(Uri.fromFile(localFile));

                        // Successfully downloaded data to local file
                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("onFailure");
                Log.d("caca", "onFailure" + exception.toString());

                // Handle failed download
                // ...
            }
        });

    }
}
