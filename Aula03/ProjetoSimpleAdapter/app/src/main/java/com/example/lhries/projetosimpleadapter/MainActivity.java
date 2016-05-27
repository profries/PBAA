package com.example.lhries.projetosimpleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contato> listaContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos = new ArrayList<>();
        listaContatos.add(new Contato("Fulano","(51)99999999"));
        listaContatos.add(new Contato("Sicrano","(51)88888888"));
        listaContatos.add(new Contato("Beltrano","(51)77777777"));

        updateLista();

    }

    private void updateLista() {
        List<HashMap<String,String>> listaMap = new ArrayList<HashMap<String, String>>();

        for(Contato contato: listaContatos){
            HashMap<String, String> map = new HashMap<>();
            map.put("nome",contato.getNome());
            map.put("telefone",contato.getTelefone());
            listaMap.add(map);
        }

        String from[] = {"nome","telefone"};
        int to[] = {R.id.idNome, R.id.idTelefone};
        SimpleAdapter adapter = new SimpleAdapter(this, listaMap,R.layout.list_item,from,to);

        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adapter);

    }

}
