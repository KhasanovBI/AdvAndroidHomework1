package com.bulat.advandroidhomework1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class FullscreenStartActivity extends AppCompatActivity {
    private final int ACTIVITY_SLEEP_TIME = 2;
    private PreloadTask preloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_start);
        preloadTask = new PreloadTask();
        preloadTask.execute();
    }

    private class PreloadTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(ACTIVITY_SLEEP_TIME);
            } catch (InterruptedException ignored) {}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            goToMainActivity();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        preloadTask.cancel(true);
        finish();
    }

    void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
