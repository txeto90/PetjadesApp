package com.monzonis.petjadesapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.monzonis.petjadesapp.R;
import java.util.ArrayList;



public class MainMenu extends AppCompatActivity {

    private ArrayList<String> nameImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setSampleImages();
    }

    public ArrayList<String> getImagesName(){ return nameImages; }

    private void setSampleImages(){
        nameImages = new ArrayList<>();
        nameImages.add("perro_petjada.png");            nameImages.add("comadreja_petjada.png");
        nameImages.add("musaranya_petjada.png");        nameImages.add("topillo_petjada.png");
        nameImages.add("erizo_petjada.png");            nameImages.add("rataagua_petjada.png");
        nameImages.add("rataalmizclera_petjada.png");   nameImages.add("raton_petjada.png");
        nameImages.add("rata_petjada.png");             nameImages.add("liron_petjada.png");
        nameImages.add("ardilla_petjada.png");          nameImages.add("liebre_petjada.png");
        nameImages.add("conill_petjada.png");           nameImages.add("oso_petjada.png");
        nameImages.add("lobo_petjada.png");             nameImages.add("zorro_petjada.png");
        nameImages.add("turon_petjada.png");            nameImages.add("marta_petjada.png");
        nameImages.add("gardunya_petjada.png");         nameImages.add("nutria_petjada.png");
        nameImages.add("tejon_petjada.png");            nameImages.add("meloncillo_petjada.png");
        nameImages.add("gineta_petjada.png");           nameImages.add("lince_petjada.png");
        nameImages.add("gatomontes_petjada.png");       nameImages.add("jabali_petjada.png");
        nameImages.add("muflon_petjada.png");           nameImages.add("cabra_petjada.png");
        nameImages.add("ciervo_petjada.png");           nameImages.add("corzo_petjada.png");
        nameImages.add("caballo_petjada.png");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // handle arrow click here
        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.inici) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.animalList) {
            Intent intent = new Intent(this, AnimalsListActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.dichotomous) {
            Intent intent = new Intent(this, DichotomousKeyActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.camera) {
            Intent intent = new Intent(this, CameraActivity.class);
            intent.putExtra("imgFootPrint", nameImages);
            startActivity(intent);
            return true;
        }
        if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
