package com.example.petjadesapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.petjadesapp.R;

import java.io.IOException;
import java.io.InputStream;

public class LoadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3500);  //Delay of 3 seconds
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(LoadActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}
