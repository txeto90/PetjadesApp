package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "animals";
    public static final int DATABASE_VERSION = 1;

    //SQL sentence to create a table
    String sqlTableAnimals = "CREATE TABLE animals(codi INTEGER PRIMARY KEY, nomCientific TEXT NOT NULL," +
            "nomVulgar TEXT NOT NULL)";
    String sqlZorro = "INSERT INTO animals VALUES (1, 'Vulpes vulpes', 'Zorro')";
    String sqlLobo = "INSERT INTO animals VALUES (2, 'Canis lupus', 'Lobo')";
    String sqlCorzo = "INSERT INTO animals VALUES (3, 'Capreolus capreolus', 'Corzo')";
    String sqlTejon = "INSERT INTO animals VALUES (4, 'Meles meles', 'Tejón')";
    String sqlJabali = "INSERT INTO animals VALUES (5, 'Sus scrofa', 'Jabalí')";

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
        db.execSQL("DROP TABLE IF EXISTS animal");
        db.execSQL(sqlTableAnimals); //creating a new version
    }
}
