package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "animals";
    public static final int DATABASE_VERSION = 5;

    //SQL sentence to create a table
    String sqlTableAnimals = "CREATE TABLE animals(codi INTEGER PRIMARY KEY, nomCientific TEXT NOT NULL," +
            "nomVulgar TEXT NOT NULL, descripcio TEXT, habitat TEXT)";
    String sqlZorro = "INSERT INTO animals VALUES (1, 'Vulpes vulpes', 'Zorro', 'alea jacta estalea jacta estalea jacta estalea jacta estalea jacta est'," +
            "'alea jacta estalea jacta estalea jacta estalea jacta estalea jacta estalea jacta est')";
    String sqlLobo = "INSERT INTO animals VALUES (2, 'Canis lupus', 'Lobo', 'alea jacta estalea jacta estalea jacta estalea jacta estalea jacta est'," +
            "'Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis')";
    String sqlCorzo = "INSERT INTO animals VALUES (3, 'Capreolus capreolus', 'Corzo', 'alea jacta estalea jacta estalea jacta estalea jacta estalea jacta est'," +
            "'Ars \n \n longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevisArs longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis')";
    String sqlTejon = "INSERT INTO animals VALUES (4, 'Meles meles', 'Tejón', 'Constitución ancha y robusta con cabeza blanca cruzada por bandas negras laterales que incorporan la zona ocular. Observado a distancia parece gris, color fruto de un pelo blanco en su base y ápice, y de banda negra en el centro. Patas y vientre cubiertos por pelo negro bastante rlo en el abdomen.\n \n Se mueve al trote con la cabeza baja y los cuartos traseros balanceándose de un lado a otro, alternando con paradas para escuchar.'," +
            "'Tejoneras de muchas bocas y complicada red de galerías y cámaras. Se diferencia de las zorreras por verse fuera montones de tierra y vegetales secos, resultado de la renovación de las camas. Viven en todo tipo de montes y dehesas, aunque no les impide la residencia en áreas cultivadas, campiñas, riveras o cantiles. Más numerosos en mosaicos de bosque con cultivos y pastizales.')";
    String sqlJabali = "INSERT INTO animals VALUES (5, 'Sus scrofa', 'Jabalí', 'alea jacta estalea jacta estalea jacta estalea jacta estalea jacta est'," +
            "'Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevisArs longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis Ars longa, vita brevis')";

    //The constructor: Create the database. Pay attention to your Android API level
    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Called if DB is accessed but not created yet
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlTableAnimals);
        db.execSQL(sqlZorro);
        db.execSQL(sqlLobo);
        db.execSQL(sqlCorzo);
        db.execSQL(sqlTejon);
        db.execSQL(sqlJabali);
        System.out.println("creada BD");
    }

    //Called if db version is increased in your app code
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Deleting the preiovus versin on the table
        db.execSQL("DROP TABLE IF EXISTS animals");
        db.execSQL(sqlTableAnimals); //creating a new version
        db.execSQL(sqlZorro);
        db.execSQL(sqlLobo);
        db.execSQL(sqlCorzo);
        db.execSQL(sqlTejon);
        db.execSQL(sqlJabali);
        System.out.println("actualitzada BD");
    }
}
