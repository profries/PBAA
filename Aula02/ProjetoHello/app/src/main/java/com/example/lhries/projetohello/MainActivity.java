package com.example.lhries.projetohello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void atualizarHello(View view){
        EditText editNome = (EditText) findViewById(R.id.main_editNome);
        TextView textoHelloWorld = (TextView) findViewById(R.id.main_textoHelloWorld);

        String nome = editNome.getText().toString();
        String hello = getResources().getString(R.string.hello);

        if(nome.isEmpty()){
            textoHelloWorld.setText(getResources().getString(R.string.helloworld));
        }
        else{
            textoHelloWorld.setText(hello+" "+nome);
        }


    }
}
