package com.example.lhries.projetoradio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void responderQuestao(View v)
    {
        RadioGroup radioCurso = (RadioGroup) findViewById(R.id.radioCurso);
        int opcao = radioCurso.getCheckedRadioButtonId();
        if(opcao == R.id.radioAndroid)
            Toast.makeText(this, "Plataforma correta", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Plataforma errada", Toast.LENGTH_LONG).show();
    }
}
