package com.example.petjadesapp;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.Locale;

public class DichotomousKeyActivity extends MainMenu {

    Button btnLeft, btnRight;
    //String language;

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
            System.out.println("Artiodactilos");
        }
        if(txt.equalsIgnoreCase(getString(R.string.no_secundary_hoof))){
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
            System.out.println("Talpidos");
        }
        if(txt.equalsIgnoreCase(getString(R.string.double_pad))){
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
            System.out.println("Gato");
        }
        if(txt.equalsIgnoreCase(getString(R.string.oval_pad))){
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
            System.out.println("Nutria");
        }
        if(txt.equalsIgnoreCase(getString(R.string.one_to_three_cm))){
            btnRight.setText(R.string.less_than_threecm);
            btnLeft.setText(R.string.four_to_five_cm);
        }else if(txt.equalsIgnoreCase(getString(R.string.four_to_five_cm))){
            System.out.println("Ardilla");
        }
        if(txt.equalsIgnoreCase(getString(R.string.less_than_onefive_cm))){
            btnRight.setText(R.string.mole);
            btnLeft.setText(R.string.five_fingers);
        }else if(txt.equalsIgnoreCase(getString(R.string.five_fingers))){
            System.out.println("Sorícios");
        }
        if(txt.equalsIgnoreCase(getString(R.string.front_fingers))){
            System.out.println("Rata");
        }

    }



}
