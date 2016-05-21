package com.example.lhries.crud_contatos_bd;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lhries.crud_contatos_bd.dao.ContatoDao;
import com.example.lhries.crud_contatos_bd.dao.bd.ContatoDaoBd;
import com.example.lhries.crud_contatos_bd.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int CADASTRAR_CONTATO=1;
    private static final int EDITAR_CONTATO=2;

    private List<Contato> listaContatos;
    private Contato contatoSelecionado;
    private ListView listView;
    private ContatoDao contatoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatoDao = new ContatoDaoBd(this);

        ContatoAdapter adapter = new ContatoAdapter(this,contatoDao.listar());

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        registerForContextMenu(listView); //Indica que a listView terá um menu de contexto.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent it = new Intent(MainActivity.this,EdicaoActivity.class);
                it.putExtra("contato",(Contato) adapterView.getItemAtPosition(pos));
                startActivity(it);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                contatoSelecionado = (Contato) adapterView.getItemAtPosition(pos);
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    private void atualizaLista() {
        ((ContatoAdapter)listView.getAdapter()).setListaContatos(contatoDao.listar());
        ((ContatoAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    private void excluirContatoSelecionado(){
        if(contatoSelecionado==null) {
            Toast.makeText(this, "Erro ao excluir um contato!", Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Confirmacao de exclusao");
        dialogo.setMessage("Esse contato sera excluido");
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                contatoDao.excluir(contatoSelecionado);
                contatoSelecionado = null;
                atualizaLista();
            }
        });
        dialogo.setNegativeButton("Cancelar", null);
        dialogo.show();
    }

    public void criarNovoContato(View v){
        Intent it = new Intent(this,CadastroActivity.class);
        startActivity(it);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.listView)
        {
            getMenuInflater().inflate(R.menu.menu_contexto_listacontatos,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuExcluir:
                excluirContatoSelecionado();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
