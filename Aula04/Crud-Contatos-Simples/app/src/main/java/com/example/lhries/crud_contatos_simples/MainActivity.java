package com.example.lhries.crud_contatos_simples;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private static final int CADASTRAR_CONTATO=1;
    private static final int EDITAR_CONTATO=2;

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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                posicaoSelecionada = pos;
                return false;
            }
        });
    }

    private void atualizaLista() {
        ((ContatoAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    private void excluirContatoSelecionado(){
        if(posicaoSelecionada < 0)
            Toast.makeText(this,"Erro ao excluir um contato!",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Confirmacao de exclusao");
        dialogo.setMessage("Esse contato sera excluido");
        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listaContatos.remove(posicaoSelecionada);
                posicaoSelecionada=-1;
                atualizaLista();
            }
        });
        dialogo.setNegativeButton("Cancelar", null);
        dialogo.show();
    }

    public void criarNovoContato(View v){
        Intent it = new Intent(this,CadastroActivity.class);
        startActivityForResult(it,CADASTRAR_CONTATO);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CADASTRAR_CONTATO){
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaContatos.add(contato);
                atualizaLista();
                Toast.makeText(this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Cadastro cancelado!",Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode == EDITAR_CONTATO){
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
