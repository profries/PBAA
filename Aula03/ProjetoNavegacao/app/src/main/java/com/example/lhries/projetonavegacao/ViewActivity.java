package com.example.lhries.projetonavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent it = getIntent();
        //String nome = it.getStringExtra("nome");
        //String telefone = it.getStringExtra("telefone");
        Contato contato = (Contato) it.getSerializableExtra("contato");


        EditText editNome = (EditText) findViewById(R.id.view_editNome);
        editNome.setKeyListener(null);
        editNome.setText(contato.getNome());

        EditText editTelefone = (EditText) findViewById(R.id.view_editTelefone);
        editTelefone.setKeyListener(null);
        editTelefone.setText(contato.getTelefone());
    }

    public void voltar(View v){
        finish();
    }
}
