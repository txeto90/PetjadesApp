package com.mamiferos.huellasyrastros.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.mamiferos.huellasyrastros.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "animals";
    private static final int DATABASE_VERSION = 27;

    private final String sqlTableAnimals = "CREATE TABLE animals (codi INTEGER PRIMARY KEY, nomCientific TEXT, nomVulgar TEXT, descripcio TEXT, habitat TEXT, distribucio TEXT, rastre TEXT, fotoPetjada TEXT, fotoAnimal TEXT)";

    private Context sqlcontext;

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.sqlcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlTableAnimals);
        insertDB(db, Locale.getDefault().getLanguage());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS animals");
        db.execSQL(sqlTableAnimals);
        insertDB(db, Locale.getDefault().getLanguage());
    }

    private void insertDB(SQLiteDatabase db, String lang){
        BufferedReader reader;
        String line = "";
        int id = 0;
        switch(lang){
            case "en":{ id = R.raw.bd_en;    }break;
            default:{   id = R.raw.bd_es;   }break;
        }
        InputStream in = sqlcontext.getResources().openRawResource(id);
        reader = new BufferedReader(new InputStreamReader(in));
        try {
            while (((line = reader.readLine()) != null)){
                db.execSQL(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast toast = Toast.makeText(sqlcontext, R.string.error_bd, Toast.LENGTH_LONG);
            toast.show();
        }
    }


}
