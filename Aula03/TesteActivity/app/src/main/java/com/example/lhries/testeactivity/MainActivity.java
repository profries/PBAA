package com.example.lhries.testeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CicloVida","Create");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida","Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloVida","Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CicloVida","Restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloVida","Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloVida","Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloVida","Destroy");
    }
}
