package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import model.Animal;

public class AnimalsDAO {
    private SQLiteHelper connexion;
    private SQLiteDatabase db;
    ArrayList <Animal> animalList;
    //CONSTRUCTOR
    public AnimalsDAO(Context context){
        connexion = new SQLiteHelper(context);
        db =  connexion.getWritableDatabase();
    }
    //OBTENCIÓ DE DADES DE LA BASE DADES
    public ArrayList<Animal> getAnimals() {
        String sql = "SELECT * FROM animals";
        Cursor c = db.rawQuery(sql, null);
        animalList = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Animal a = new Animal();
                a.setScientificName(c.getString(1));
                a.setVulgarName(c.getString(2));
                a.setDescription(c.getString(3));
                a.setHabitat(c.getString(4));
                a.setDistribution(c.getString(5));
                a.setTrace(c.getString(6));
                a.setImgExcrement(c.getString(7));
                a.setImgFootprint(c.getString(8));
                a.setImgTraces(c.getString(9));
                a.setImgAnimal(c.getString(10));

                //Log.d("pDAO", "IFgetAnimals: "+a.getVulgarName());
                animalList.add(a);
            }while(c.moveToNext());
        }
        Log.d("pDAO", "IFgetAnimals: "+ animalList.size());
        return animalList;
    }


}
