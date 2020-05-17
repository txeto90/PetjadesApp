package com.example.petjadesapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.example.petjadesapp.R;
import com.example.petjadesapp.dao.AnimalsDAO;
import com.example.petjadesapp.model.Animal;

import java.nio.charset.StandardCharsets;

public class DichotomousKeyActivity extends MainMenu {

    private Button btnLeft;
    private Button btnRight;
    private ImageView ivLeft;
    private ImageView ivRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dichotomous_key);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        AnimalsDAO animalsDAO = new AnimalsDAO(this);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRigth);
        ivLeft = findViewById(R.id.ivLeft);
        ivRight = findViewById(R.id.ivRigth);
    }

    @SuppressWarnings("unused")
    public void onClickRight(View view){
        String txt = btnRight.getText().toString();
        //PEZUÑA/CASCO
        if(txt.equalsIgnoreCase(getString(R.string.hoof))){
            btnRight.setText(R.string.pair_fingers);
            ivRight.setImageResource(R.drawable.cabra_petjada);
            btnLeft.setText(R.string.odd_fingers);
            ivLeft.setImageResource(R.drawable.caballo_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.pair_fingers))){
            btnRight.setText(R.string.no_secundary_hoof);
            ivRight.setImageResource(R.drawable.ciervo_petjada);
            btnLeft.setText(R.string.with_secundary_hoof);
            ivLeft.setImageResource(R.drawable.jabali_petjada);
        }
        if(txt.equalsIgnoreCase(getString(R.string.no_secundary_hoof))){
            int code = 30;
            startAnimalData(code);
        }
        //DEDOS HASTA ALM. PRINCIPAL UNICA
        if(txt.equalsIgnoreCase(getString(R.string.with_nails))){
            btnRight.setText(R.string.no_main_pad);
            ivRight.setImageResource(R.drawable.conejo_petjada);
            btnLeft.setText(R.string.with_main_pad);
            ivLeft.setImageResource(R.drawable.gatomontes_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.no_main_pad))){
            btnRight.setText(R.string.heavily_modified);
            ivRight.setImageResource(R.drawable.topillo_petjada);
            btnLeft.setText(R.string.oval_pad);
            ivLeft.setImageResource(R.drawable.liebre_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.heavily_modified))) {
            int code = 2;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.double_pad))){
            int code = 24;
            startAnimalData(code);
        }
        //ALMOHADILLA UNICA HASTA 1-3CM
        if(txt.equalsIgnoreCase(getString(R.string.one_to_five_size))){
            btnRight.setText(R.string.more_than_threecm);
            btnLeft.setText(R.string.one_to_three_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.more_than_threecm))){
            int code = 3;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.long_nails))){
            int code = 22;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.less_than_threecm))){
            btnRight.setText(R.string.more_than_onefivecm);
            ivLeft.setImageResource(R.drawable.rataagua_petjada);
            btnLeft.setText(R.string.less_than_onefive_cm);
            ivLeft.setImageResource(R.drawable.raton_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.more_than_onefivecm))){
            btnRight.setText(R.string.side_fingers);
            ivRight.setImageResource(R.drawable.raton_petjada);
            btnLeft.setText(R.string.front_fingers);
            ivLeft.setImageResource(R.drawable.rata_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.side_fingers))){
            int code = 7;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.mole))){
            int code = 2;
            startAnimalData(code);
        }
    }

    @SuppressWarnings("unused")
    public void onClickLeft(View view){
        String txt = btnLeft.getText().toString();
        //PEZUÑA/CASCO
        if(txt.equalsIgnoreCase(getString(R.string.with_secundary_hoof))){
            int code = 27;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.odd_fingers))){
            int code = 32;
            startAnimalData(code);
        }
        //DEDOS HASTA ALM. PRINCIPAL UNICA
        if(txt.equalsIgnoreCase(getString(R.string.fingers))){
            btnRight.setText(R.string.with_nails);
            ivRight.setImageResource(R.drawable.erizo_petjada);
            btnLeft.setText(R.string.no_nails);
            ivLeft.setImageResource(R.drawable.lince_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.no_nails))){
            btnRight.setText(R.string.double_pad);
            ivRight.setImageResource(R.drawable.gineta_petjada);
            btnLeft.setText(R.string.tripe_pad);
            ivLeft.setImageResource(R.drawable.gatomontes_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.tripe_pad))){
            int code = 26;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.oval_pad))){
            int code = 13;
            startAnimalData(code);
        }
        //ALMOHADILLA UNICA HASTA 1-3CM
        if(txt.equalsIgnoreCase(getString(R.string.with_main_pad))){
            btnRight.setText(R.string.one_to_five_size);
            btnLeft.setText(R.string.five_to_eigth_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.five_to_eigth_cm))){
            btnRight.setText(R.string.long_nails);
            ivRight.setImageResource(R.drawable.tejon_petjada);
            btnLeft.setText(R.string.small_nails);
            ivLeft.setImageResource(R.drawable.nutria_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.small_nails))){
            int code = 21;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.one_to_three_cm))){
            btnRight.setText(R.string.less_than_threecm);

            btnLeft.setText(R.string.four_to_five_cm);
            ivLeft.setImageResource(R.drawable.ardilla_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.four_to_five_cm))){
            int code = 11;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.less_than_onefive_cm))){
            btnRight.setText(R.string.mole);
            ivRight.setImageResource(R.drawable.topillo_petjada);
            btnLeft.setText(R.string.five_fingers);
            ivLeft.setImageResource(R.drawable.musaranya_petjada);
        }else if(txt.equalsIgnoreCase(getString(R.string.five_fingers))){
            int code = 1;
            startAnimalData(code);
        }
        if(txt.equalsIgnoreCase(getString(R.string.front_fingers))){
            int code = 8;
            startAnimalData(code);
        }

    }

    private void startAnimalData(int code){
        Animal a = AnimalsDAO.getAnimalInformation(code);
        //ENVIEM LES DADES DE L'ANIMAL AMB INTENT PER A REBRELES EN LA SEGUENT ACTIVITY
        Intent intent = new Intent(DichotomousKeyActivity.this, AnimalDataActivity.class);
        intent.putExtra("vulgarName", a.getVulgarName());
        intent.putExtra("scientificName", a.getScientificName());
        intent.putExtra("description", a.getDescription());
        intent.putExtra("habitat", a.getHabitat());
        intent.putExtra("distribution", a.getDistribution());
        intent.putExtra("trace", a.getTrace());
        intent.putExtra("imgFootPrint", a.getImgFootprint());
        intent.putExtra("imgAnimal", a.getImgAnimal());
        startActivity(intent);
    }

}
