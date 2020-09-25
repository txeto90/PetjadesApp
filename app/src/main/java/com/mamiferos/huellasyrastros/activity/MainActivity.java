package com.mamiferos.huellasyrastros.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mamiferos.huellasyrastros.R;
import java.util.ArrayList;

public class MainActivity extends MainMenu {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewMain);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }


    @SuppressWarnings("unused")
    public void goToAnimalsListActivity(View view){
        startActivity(new Intent(this, AnimalsListActivity.class));
    }

    @SuppressWarnings("unused")
    public void goToDicotomicActivity(View view){
        Intent intent = new Intent(this, DichotomousKeyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    public void goToAboutActivity(View view){
        startActivity(new Intent(this, AboutActivity.class));
    }

    public void goToCameraActivity(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        ArrayList<String> nameImages = getImagesName();
        intent.putExtra("imgFootPrint", nameImages);
        startActivity(intent);
    }

}
