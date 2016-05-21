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

public class CadastroActivity extends AppCompatActivity {

    private ContatoDao contatoDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        contatoDao = new ContatoDaoBd(this);
    }

    public void cadastrarContato(View v){
        EditText textoNome = (EditText) findViewById(R.id.cadastro_editNome);
        EditText textoTelefone = (EditText) findViewById(R.id.cadastro_editTelefone);

        Contato contato = new Contato(textoNome.getText().toString(),textoTelefone.getText().toString());
        contatoDao.salvar(contato);

        Toast.makeText(this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        cancelarCadastro();
        super.onBackPressed();
    }

    public void cancelarCadastro(View v){
        cancelarCadastro();
    }

    private void cancelarCadastro() {
        Toast.makeText(this,"Cadastro cancelado!",Toast.LENGTH_SHORT).show();
        finish();

    }
}
