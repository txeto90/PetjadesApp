package com.example.petjadesapp.dao;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petjadesapp.activity.MainMenu;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class ImagesDAO extends AppCompatActivity {

    private File localFile = null;


    public ImagesDAO(String imgName, int objectId){
        Log.d("kk", "img: " + imgName+", Rid: " + String.valueOf(objectId));
        // PASARLI EN EL EXTRA EN NOM DE LA FOTO QUE ES VOL AGAFAR
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference riversRef;
        //escolleix depenent del no m de imatge
        if(imgName.contains("Distri")){
            riversRef = mStorageRef.child("distribucio/" + imgName);
        }else{
            riversRef = mStorageRef.child("fotoAnimals/" + imgName);
        }
        //download
        try {
            localFile = File.createTempFile("images", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        ImageView animalImage = findViewById(objectId);
                        animalImage.setImageURI(Uri.fromFile(localFile));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) { }
        });
    }
}
