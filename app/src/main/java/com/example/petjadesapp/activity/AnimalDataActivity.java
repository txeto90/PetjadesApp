package com.example.petjadesapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import com.example.petjadesapp.R;
import com.example.petjadesapp.dao.ImagesDAO;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_data);
        setSupportActionBar(findViewById(R.id.toolbar));

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

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
        txtInformation.setText(Html.fromHtml(description));
    }

    //MOSTRA LES DADES EN LES CORRESPONENTS PESTANYES
    @SuppressWarnings("unused")
    public void showInfo(View view){
        Bundle extras = getIntent().getExtras();
        String description = extras.getString("description");
        checkImageButtons(ibInfo, ibHabitat, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexDescription));
        txtInformation.setText(Html.fromHtml(description));
        imgAditional.setVisibility(View.INVISIBLE);
    }

    @SuppressWarnings("unused")
    public void showHabitat(View view){
        Bundle extras = getIntent().getExtras();
        String habitat = extras.getString("habitat");
        checkImageButtons(ibHabitat, ibInfo, ibTrace, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexHabitat));
        txtInformation.setText(Html.fromHtml(habitat));
        imgAditional.setVisibility(View.INVISIBLE);
    }

    @SuppressWarnings("unused")
    public void showDistribution(View view){
        Bundle extras = getIntent().getExtras();
        String dist = extras.getString("distribution");
        checkImageButtons(ibDistribution, ibInfo, ibHabitat, ibTrace);
        txtIndexTitle.setText(getString(R.string.txtIndexDistribution));
        txtInformation.setText("");
        ImageView iv = findViewById(R.id.imgViewAditional);
        ImagesDAO.getImageFromFirebase(dist, iv, this.getApplicationContext());
        imgAditional.setVisibility(View.VISIBLE);
    }


    @SuppressWarnings("unused")
    public void showTrace(View view){
        Bundle extras = getIntent().getExtras();
        String trace = extras.getString("trace");
        checkImageButtons(ibTrace, ibInfo, ibHabitat, ibDistribution);
        txtIndexTitle.setText(getString(R.string.txtIndexTrace));
        txtInformation.setText(Html.fromHtml(trace));
        imgAditional.setVisibility(View.INVISIBLE);
    }

    //POSAR IMATGE DEL ANIMAL
    private void showImgAnimal(){
        Bundle extras = getIntent().getExtras();
        String img = extras.getString("imgAnimal");
        ImageView iv = findViewById(R.id.imgViewAnimal);
        ImagesDAO.getImageFromFirebase(img, iv, this.getApplicationContext());
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

}
