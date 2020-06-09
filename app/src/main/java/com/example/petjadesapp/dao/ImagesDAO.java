package com.example.petjadesapp.dao;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import java.util.HashMap;

public class ImagesDAO {

    private static HashMap<String, Uri> hashmap = new HashMap<>();

    public static void getImageFromFirebase(String imgName, ImageView imageView, @NonNull Context context){
        if(hashmap.containsKey(imgName)){
            if(hashmap.get(imgName) != null) {
                Picasso.get().load(hashmap.get(imgName)).into(imageView);
                return;
            }
        }

        // PASARLI EN EL EXTRA EN NOM DE LA FOTO QUE ES VOL AGAFAR
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference riversRef;
        //escolleix depenent del nom de la imatge
        if(imgName.contains("Distri")){
            riversRef = mStorageRef.child("distribucio/" + imgName);
        }else{
            riversRef = mStorageRef.child("fotoAnimals/" + imgName);
        }
        hashmap.put(imgName, null);
        //download
        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                hashmap.put(imgName, uri);
                // Got the download URL for 'users/me/profile.png'
                // Pass it to Picasso to download, show in ImageView and caching
                Picasso.get().load(uri.toString()).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Any errors
                Toast toast = Toast.makeText(context, "Error en la conexión. No se han podido cargar las imágenes.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
