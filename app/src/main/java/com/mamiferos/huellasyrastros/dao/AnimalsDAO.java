package com.mamiferos.huellasyrastros.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mamiferos.huellasyrastros.activity.MainMenu;
import com.mamiferos.huellasyrastros.model.Animal;
import java.util.ArrayList;

public class AnimalsDAO extends MainMenu {

    private SQLiteHelper connexion;
    private static SQLiteDatabase db;
    private ArrayList<Animal> animalList;

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
                a.setImgFootprint(c.getString(7));
                a.setImgAnimal(c.getString(8));
                animalList.add(a);
            }while(c.moveToNext());
        }
        return animalList;
    }

    public static Animal getAnimalInformation(int id) {
        String sql = "SELECT * FROM animals WHERE codi = " + id + ";";
        Cursor c = db.rawQuery(sql, null);
        Animal a = new Animal();
        if(c.moveToFirst()) {
            do {
                a.setScientificName(c.getString(1));
                a.setVulgarName(c.getString(2));
                a.setDescription(c.getString(3));
                a.setHabitat(c.getString(4));
                a.setDistribution(c.getString(5));
                a.setTrace(c.getString(6));
                a.setImgFootprint(c.getString(7));
                a.setImgAnimal(c.getString(8));
            } while (c.moveToNext());
        }
        return a;
    }

    public static Animal getAnimalInformation(String petjada) {
        String sql = "SELECT * FROM animals WHERE fotoPetjada = \'" + petjada + "\';";
        Cursor c = db.rawQuery(sql, null);
        Animal a = new Animal();
        if(c.moveToFirst()) {
            do {
                a.setScientificName(c.getString(1));
                a.setVulgarName(c.getString(2));
                a.setDescription(c.getString(3));
                a.setHabitat(c.getString(4));
                a.setDistribution(c.getString(5));
                a.setTrace(c.getString(6));
                a.setImgFootprint(c.getString(7));
                a.setImgAnimal(c.getString(8));
            } while (c.moveToNext());
        }
        return a;
    }
}
