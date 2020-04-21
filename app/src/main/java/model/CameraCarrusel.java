package model;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.petjadesapp.MainMenu;
import com.example.petjadesapp.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class CameraCarrusel extends MainMenu {
    CarouselView carouselView;

    int[] sampleImages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_carousel_view);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
            //adjustar imatges
            imageView.setAdjustViewBounds(true);
            //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    };
}
