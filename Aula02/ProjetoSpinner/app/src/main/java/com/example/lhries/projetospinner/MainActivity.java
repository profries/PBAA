package com.example.lhries.projetospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{
    /** Called when the activity is first created. */
    private static String[] paises = {"Argentina","Brasil","Estados Unidos","Paraguai","Uruguai"};
    private ArrayAdapter<String> adPaises;
    Spinner spinnerEstado;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adPaises = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                paises);

        spinnerEstado = (Spinner) findViewById(R.id.spinnerEstado);
        spinnerEstado.setAdapter(adPaises);
        spinnerEstado.setOnItemSelectedListener(this);

    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {

        if(arg2 == 1)
            Toast.makeText(this, "Selecionou o pais Brasil", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Pais selecionado: "+((TextView)arg1).getText(), Toast.LENGTH_SHORT).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Nada foi alterado!", Toast.LENGTH_SHORT).show();

    }

}
