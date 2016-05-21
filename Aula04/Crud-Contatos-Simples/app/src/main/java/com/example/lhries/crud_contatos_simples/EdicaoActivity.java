package com.example.lhries.crud_contatos_simples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EdicaoActivity extends AppCompatActivity {

    private EditText textoNome, textoTelefone;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        Contato contato = (Contato) this.getIntent().getSerializableExtra("contato");
        textoNome = (EditText) findViewById(R.id.edicao_editNome);
        textoNome.setText(contato.getNome());
        textoTelefone = (EditText) findViewById(R.id.edicao_editTelefone);
        textoTelefone.setText(contato.getTelefone());

        posicao = this.getIntent().getIntExtra("posicao",-1);

    }
    public void editarContato(View v){
        Intent it = new Intent();
        String nome = textoNome.getText().toString();
        String telefone = textoTelefone.getText().toString();
        it.putExtra("contato",new Contato(nome,telefone));
        it.putExtra("posicao",posicao);
        setResult(RESULT_OK,it);
        finish();

    }

    public void cancelarEdicao(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
