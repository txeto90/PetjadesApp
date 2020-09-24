package com.mamiferos.huellasyrastros.dao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.InputStream;

public class ImagesDAO {

    public static void getImageFromAssets(String imgName, ImageView imageView, @NonNull Context context){
        try {
            String url = "";
            if(imgName.contains("petjada")){
                url = "footprint";
            }else{
                if(imgName.contains("Distri")){
                    url = "distribution";
                }else{
                    url = "photos";
                }
            }
            InputStream ims = context.getAssets().open(url+"/"+imgName);
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
        }catch(Exception e){

        }
    }

    public static void getImageList(String imgName, ImageView imageView, @NonNull Context context){
        try {
            String url = "photos";
            InputStream ims = context.getAssets().open(url+"/"+imgName);
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
        }catch(Exception e){

        }
    }

}
