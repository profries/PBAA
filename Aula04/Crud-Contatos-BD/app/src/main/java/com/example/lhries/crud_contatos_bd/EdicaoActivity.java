package com.example.lhries.crud_contatos_bd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lhries.crud_contatos_bd.dao.ContatoDao;
import com.example.lhries.crud_contatos_bd.dao.bd.ContatoDaoBd;
import com.example.lhries.crud_contatos_bd.model.Contato;

public class EdicaoActivity extends AppCompatActivity {

    private ContatoDao contatoDao;
    private EditText textoNome, textoTelefone;
    private Contato contatoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        contatoDao = new ContatoDaoBd(this);

        contatoSelecionado = (Contato) this.getIntent().getSerializableExtra("contato");
        textoNome = (EditText) findViewById(R.id.edicao_editNome);
        textoNome.setText(contatoSelecionado.getNome());
        textoTelefone = (EditText) findViewById(R.id.edicao_editTelefone);
        textoTelefone.setText(contatoSelecionado.getTelefone());
    }

    public void editarContato(View v){
        Intent it = new Intent();
        String nome = textoNome.getText().toString();
        String telefone = textoTelefone.getText().toString();

        contatoSelecionado.setNome(nome);
        contatoSelecionado.setTelefone(telefone);

        contatoDao.atualizar(contatoSelecionado);

        Toast.makeText(this,"Edicao realizada com sucesso!",Toast.LENGTH_SHORT).show();

        finish();

    }

    @Override
    public void onBackPressed() {
        cancelarEdicao();
        super.onBackPressed();
    }

    public void cancelarEdicao(View v){
        cancelarEdicao();
    }

    private void cancelarEdicao(){
        Toast.makeText(this,"Edicao cancelada!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
