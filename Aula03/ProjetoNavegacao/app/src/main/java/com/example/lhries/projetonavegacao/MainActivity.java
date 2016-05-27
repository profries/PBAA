package com.example.lhries.projetonavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contato> listaContatos;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato("Fulano","(51)99999999"));
        listaContatos.add(new Contato("Sicrano","(51)88888888"));
        listaContatos.add(new Contato("Beltrano","(51)77777777"));

        ContatoAdapter adapter = new ContatoAdapter(this,listaContatos);

        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String nome = listaContatos.get(pos).getNome();
                String telefone = listaContatos.get(pos).getTelefone();
                Contato contato = new Contato(nome,telefone);

                Intent it = new Intent(MainActivity.this,ViewActivity.class);
                //it.putExtra("nome",nome);
                //it.putExtra("telefone",telefone);
                it.putExtra("contato",contato);
                startActivity(it);

            }
        });

    }

    private void atualizaLista() {
        ((ContatoAdapter)lista.getAdapter()).notifyDataSetChanged();
    }
}
