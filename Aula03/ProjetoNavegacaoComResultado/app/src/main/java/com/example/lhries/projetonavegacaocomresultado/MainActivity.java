package com.example.lhries.projetonavegacaocomresultado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int EDITAR_CONTATO=1;

    private List<Contato> listaContatos;
    private int posicaoSelecionada = -1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato("Fulano","(51)99999999"));
        listaContatos.add(new Contato("Sicrano","(51)88888888"));
        listaContatos.add(new Contato("Beltrano","(51)77777777"));

        ContatoAdapter adapter = new ContatoAdapter(this,listaContatos);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        registerForContextMenu(listView); //Indica que a listView terá um menu de contexto.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent it = new Intent(MainActivity.this,EdicaoActivity.class);
                it.putExtra("contato",listaContatos.get(pos));
                it.putExtra("posicao",pos);
                startActivityForResult(it,EDITAR_CONTATO);

            }
        });

    }

    private void atualizaLista() {
        ((ContatoAdapter)listView.getAdapter()).notifyDataSetChanged();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == EDITAR_CONTATO){
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                int posicao = data.getIntExtra("posicao",-1);
                listaContatos.set(posicao, contato);
                atualizaLista();
                Toast.makeText(this,"Edicao realizada com sucesso!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Edicao cancelada!",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
