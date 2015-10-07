package com.bulat.advandroidhomework1;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class FullscreenStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_start);
        Thread myThready = new Thread(new Runnable() {
            public void run() {
                SystemClock.sleep(2000);
                Log.d("str", "Побочный поток");
            }
        });
        myThready.start(); //Запуск потока
        Log.d("str", "Главный поток");
        Toast.makeText(this, "готово", Toast.LENGTH_LONG).show();
    }

}
