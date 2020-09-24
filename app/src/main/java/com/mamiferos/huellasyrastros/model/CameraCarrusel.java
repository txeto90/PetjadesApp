package com.mamiferos.huellasyrastros.model;

import android.os.Bundle;
import com.mamiferos.huellasyrastros.R;
import com.mamiferos.huellasyrastros.activity.MainMenu;
import com.synnapps.carouselview.CarouselView;

public class CameraCarrusel extends MainMenu {

    private final int[] sampleImages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_carousel_view);
        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
    }
}
