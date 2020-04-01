package com.example.petjadesapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

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
        //language = Locale.getDefault().toString();


    }

    private String getStringResourceByName(String str){
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(str, "string", packageName);
        return getString(resId);
    }
    private int getintResourceByName(String str){
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(str, "string", packageName);
        return resId;
    }

    public void onClickRight(View view){
        String txt = btnRight.getText().toString();
//        String str = getStringResourceByName(txt);
        int resId = getintResourceByName(txt);

        switch(resId){
            case R.string.hoof:{

            }
        }
            btnRight.setText(R.string.pair_fingers);
            btnLeft.setText(R.string.);


    }

    public void onClickLeft(View view){

    }



}
