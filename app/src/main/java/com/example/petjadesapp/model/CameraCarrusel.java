package com.example.petjadesapp.model;

import android.os.Bundle;
import android.widget.TextView;

import com.example.petjadesapp.R;
import com.example.petjadesapp.activity.MainMenu;
import com.synnapps.carouselview.CarouselView;

public class CameraCarrusel extends MainMenu {

    private final int[] sampleImages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_carousel_view);

        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        //TextView txtCameraView = findViewById(R.id.txtCameraView);

        carouselView.setPageCount(sampleImages.length);
    }
}
