package com.example.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.petjadesapp.R;
import com.example.petjadesapp.dao.AnimalsDAO;
import com.example.petjadesapp.model.Animal;


public class DichotomousKeyActivity extends MainMenu {

    Button btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dichotomous_key);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRigth);


    }

    public void onClickRight(View view){
        String txt = btnRight.getText().toString();
        //PEZUÑA/CASCO
        if(txt.equalsIgnoreCase(getString(R.string.hoof))){
            btnRight.setText(R.string.pair_fingers);
            btnLeft.setText(R.string.odd_fingers);
        }else if(txt.equalsIgnoreCase(getString(R.string.pair_fingers))){
//            int code = 32;
//            Animal a = AnimalsDAO.getAnimalInformation(code);
//            startAnimalData(a);
            System.out.println("Artiodactilos");
        }
        if(txt.equalsIgnoreCase(getString(R.string.no_secundary_hoof))){
            int code = 30;
            startAnimalData(code);
            System.out.println("Cervidos/Bovidos");
        }
        //DEDOS HASTA ALM. PRINCIPAL UNICA
        if(txt.equalsIgnoreCase(getString(R.string.with_nails))){
            btnRight.setText(R.string.no_main_pad);
            btnLeft.setText(R.string.with_main_pad);
        }else if(txt.equalsIgnoreCase(getString(R.string.no_main_pad))){
            btnRight.setText(R.string.heavily_modified);
            btnLeft.setText(R.string.oval_pad);
        }else if(txt.equalsIgnoreCase(getString(R.string.heavily_modified))) {
            int code = 2;
            startAnimalData(code);
            System.out.println("Talpidos");
        }
        if(txt.equalsIgnoreCase(getString(R.string.double_pad))){
            int code = 24;
            startAnimalData(code);
            System.out.println("Gineta");
        }
        //ALMOHADILLA UNICA HASTA 1-3CM
        if(txt.equalsIgnoreCase(getString(R.string.one_to_five_size))){
            btnRight.setText(R.string.more_than_threecm);
            btnLeft.setText(R.string.one_to_three_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.more_than_threecm))){
            System.out.println("cosas");
        }
        if(txt.equalsIgnoreCase(getString(R.string.long_nails))){
            int code = 22;
            startAnimalData(code);
            System.out.println("Tejón");
        }
        if(txt.equalsIgnoreCase(getString(R.string.less_than_threecm))){
            btnRight.setText(R.string.more_than_onefivecm);
            btnLeft.setText(R.string.less_than_onefive_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.more_than_onefivecm))){
            btnRight.setText(R.string.side_fingers);
            btnLeft.setText(R.string.front_fingers);
        }else if(txt.equalsIgnoreCase(getString(R.string.side_fingers))){
            System.out.println("Muridos/Microtidos");
        }
        if(txt.equalsIgnoreCase(getString(R.string.mole))){
            int code = 2;
            startAnimalData(code);
            System.out.println("Talpidos");
        }
    }

    public void onClickLeft(View view){
        String txt = btnLeft.getText().toString();
        //PEZUÑA/CASCO
        if(txt.equalsIgnoreCase(getString(R.string.odd_fingers))){
            btnRight.setText(R.string.no_secundary_hoof);
            btnLeft.setText(R.string.with_secundary_hoof);
        }else if(txt.equalsIgnoreCase(getString(R.string.with_secundary_hoof))){
            int code = 27;
            startAnimalData(code);
            System.out.println("Suidos");
        }
        //DEDOS HASTA ALM. PRINCIPAL UNICA
        if(txt.equalsIgnoreCase(getString(R.string.fingers))){
            btnRight.setText(R.string.with_nails);
            btnLeft.setText(R.string.no_nails);
        }else if(txt.equalsIgnoreCase(getString(R.string.no_nails))){
            btnRight.setText(R.string.double_pad);
            btnLeft.setText(R.string.tripe_pad);
        }else if(txt.equalsIgnoreCase(getString(R.string.tripe_pad))){
            int code = 26;
            startAnimalData(code);
            System.out.println("Gato");
        }
        if(txt.equalsIgnoreCase(getString(R.string.oval_pad))){
            int code = 13;
            startAnimalData(code);
            System.out.println("Conejo/Liebre");
        }
        //ALMOHADILLA UNICA HASTA 1-3CM
        if(txt.equalsIgnoreCase(getString(R.string.with_main_pad))){
            btnRight.setText(R.string.one_to_five_size);
            btnLeft.setText(R.string.five_to_eigth_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.five_to_eigth_cm))){
            btnRight.setText(R.string.long_nails);
            btnLeft.setText(R.string.small_nails);
        }else if(txt.equalsIgnoreCase(getString(R.string.small_nails))){
            int code = 21;
            startAnimalData(code);
            System.out.println("Nutria");
        }
        if(txt.equalsIgnoreCase(getString(R.string.one_to_three_cm))){
            btnRight.setText(R.string.less_than_threecm);
            btnLeft.setText(R.string.four_to_five_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.four_to_five_cm))){
            int code = 11;
            startAnimalData(code);
            System.out.println("Ardilla");
        }
        if(txt.equalsIgnoreCase(getString(R.string.less_than_onefive_cm))){
            btnRight.setText(R.string.mole);
            btnLeft.setText(R.string.five_fingers);
        }else if(txt.equalsIgnoreCase(getString(R.string.five_fingers))){
            System.out.println("Sorícios");
        }
        if(txt.equalsIgnoreCase(getString(R.string.front_fingers))){
            int code = 8;
            startAnimalData(code);
            System.out.println("Rata");
        }

    }

    public void startAnimalData(int code){
        Animal a = AnimalsDAO.getAnimalInformation(code);
        //ENVIEM LES DADES DE L'ANIMAL AMB INTENT PER A REBRELES EN LA SEGUENT ACTIVITY
        Intent intent = new Intent(DichotomousKeyActivity.this, AnimalDataActivity.class);
        intent.putExtra("vulgarName", a.getVulgarName());
        intent.putExtra("scientificName", a.getScientificName());
        intent.putExtra("description", a.getDescription());
        intent.putExtra("habitat", a.getHabitat());
        intent.putExtra("distribution", a.getDistribution());
        intent.putExtra("trace", a.getTrace());
        intent.putExtra("imgExcrement", a.getImgExcrement());
        intent.putExtra("imgFootPrint", a.getImgFootprint());
        intent.putExtra("imgTraces", a.getImgTraces());
        intent.putExtra("imgAnimal", a.getImgAnimal());

        startActivity(intent);
    }

}
