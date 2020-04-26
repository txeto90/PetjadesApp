package com.example.petjadesapp.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.example.petjadesapp.R;
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
import java.util.ArrayList;

public class AnimalDataActivity extends MainMenu {

    private TextView txtIndexTitle;
    private TextView txtVulgar;
    private TextView txtScientific;
    private TextView txtInformation;
    private ImageButton ibInfo;
    private ImageButton ibHabitat;
    private ImageButton ibTrace;
    private ImageButton ibDistribution;
    private ImageView imgAditional;
    private File localFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_data);
        setSupportActionBar(findViewById(R.id.toolbar));

        txtIndexTitle = findViewById(R.id.txtViewIndex);
        txtVulgar = findViewById(R.id.txtViewVulgarName);
        txtScientific = findViewById(R.id.txtViewScientificName);
        txtInformation = findViewById(R.id.txtViewInformation);
        ibInfo = findViewById(R.id.ibDescription);
        ibHabitat = findViewById(R.id.ibHabitat);
        ibDistribution = findViewById(R.id.ibDistribution);
        ibTrace = findViewById(R.id.ibTrace);
        imgAditional = findViewById(R.id.imgViewAditional);
        imgAditional.setVisibility(View.INVISIBLE);
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
    @SuppressWarnings("unused")
    public void showInfo(View view){
        Bundle extras = getIntent().getExtras();
        String description = extras.getString("description");
        checkImageButtons(ibInfo, ibHabitat, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexDescription));
        txtInformation.setText(description);
        imgAditional.setVisibility(View.INVISIBLE);
    }

    @SuppressWarnings("unused")
    public void showHabitat(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("habitat");
        checkImageButtons(ibHabitat, ibInfo, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexHabitat));
        txtInformation.setText(habitat);
        imgAditional.setVisibility(View.INVISIBLE);
    }

    @SuppressWarnings("unused")
    public void showDistribution(View view){
        Bundle extras = getIntent().getExtras();
        String dist = extras.getString("distribution");
        checkImageButtons(ibDistribution, ibInfo, ibHabitat, ibTrace);
        txtIndexTitle.setText(getString(R.string.txtIndexDistribution));
        txtInformation.setText("");
        getImagesFromFirebase(dist, R.id.imgViewAditional);
        imgAditional.setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("unused")
    public void showTrace(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("trace");
        checkImageButtons(ibTrace, ibInfo, ibHabitat, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexTrace));
        txtInformation.setText(habitat);
        imgAditional.setVisibility(View.INVISIBLE);
    }

    //POSAR IMATGE DEL ANIMAL
    private void showImgAnimal(){
        Bundle extras = getIntent().getExtras();
        String img = extras.getString("imgAnimal");
        getImagesFromFirebase(img, R.id.imgViewAnimal);
    }

    //DIRECCIONA A LA CAMERAACTIVITY AMB LA PETJADA DE L'ANIMAL CORRESPONENT
    @SuppressWarnings("unused")
    public void goToCameraActivity(View view){
        Bundle extras = getIntent().getExtras();
        String img = extras.getString("imgFootPrint");
        Intent intent = new Intent(this, CameraActivity.class);
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add(img);
        intent.putExtra("imgFootPrint", imgs);
        startActivity(intent);
    }

    //MARCA Y DESMARCA LES IMAGEBUTTONS DEPENENT DE LA SEUA SEL·LECCIÓ
    private void checkImageButtons(ImageButton ib, ImageButton first, ImageButton second, ImageButton third){
        ib.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(200,200,200)));
        first.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        second.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        third.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
    }

    public void comeBack(View view){
        startActivity(new Intent(this, AnimalsListActivity.class));
    }

    public void getImagesFromFirebase(String imgName, int objectId){
        Log.d("kk", "img: " + imgName+", Rid: " + String.valueOf(objectId));
        // PASARLI EN EL EXTRA EN NOM DE LA FOTO QUE ES VOL AGAFAR
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference riversRef;
        //escolleix depenent del no m de imatge
        if(imgName.contains("Distri")){
            riversRef = mStorageRef.child("distribucio/" + imgName);
        }else{
            riversRef = mStorageRef.child("fotoAnimals/" + imgName);
        }
        //download
        try {
            localFile = File.createTempFile("images", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        ImageView animalImage = findViewById(objectId);
                        animalImage.setImageURI(Uri.fromFile(localFile));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) { }
        });
    }
}
