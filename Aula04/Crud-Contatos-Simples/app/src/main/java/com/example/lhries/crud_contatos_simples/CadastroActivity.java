package com.example.lhries.crud_contatos_simples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarContato(View v){
        EditText textoNome = (EditText) findViewById(R.id.cadastro_editNome);
        EditText textoTelefone = (EditText) findViewById(R.id.cadastro_editTelefone);

        Intent it = new Intent();
        it.putExtra("contato",
                new Contato(textoNome.getText().toString(),textoTelefone.getText().toString())
        );
        setResult(RESULT_OK,it);
        finish();

    }

    public void cancelarCadastro(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

}
