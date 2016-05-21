package com.example.lhries.crud_contatos_bd.dao.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lhries.crud_contatos_bd.dao.ContatoDao;
import com.example.lhries.crud_contatos_bd.model.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhries on 21/05/2016.
 */
public class ContatoDaoBd implements ContatoDao {
    private BancoDadosOpenHelper bdOpenHelper;

    public ContatoDaoBd(Context contexto)
    {
        bdOpenHelper = new BancoDadosOpenHelper(contexto);
    }

    @Override
    public void salvar(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        long id = banco.insert("contato", null, dados);
        contato.setId((int) id);
        banco.close();
    }

    @Override
    public void excluir(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();
        banco.delete("contato", "id=?", new String[]{ contato.getId().toString()});
        banco.close();
    }

    @Override
    public void atualizar(Contato contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        banco.update("contato", dados, "id=?", new String[]{contato.getId().toString()});
        banco.close();
    }

    @Override
    public List<Contato> listar() {
        List<Contato> listaContatos = new ArrayList<Contato>();

        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();
        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone"},
                null, null, null, null, null);

        while(cursor.moveToNext()){
            Contato contato = new Contato((cursor.getInt(cursor.getColumnIndex("id"))),
                cursor.getString(cursor.getColumnIndex("nome")),
                cursor.getString(cursor.getColumnIndex("telefone")));

            listaContatos.add(contato);
        }
        return(listaContatos);
    }

    @Override
    public Contato procurarPorId(Integer id) {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();
        Cursor cursor = banco.query("aluno",
                new String[]{"id","nome","telefone"},
                "id=?", new String[]{id.toString()},
                null, null, null);

        if(cursor.moveToNext()){
            Contato contato = new Contato((cursor.getInt(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("telefone")));

            return(contato);
        }
        return(null);
    }

    @Override
    public List<Contato> procurarPorNome(String filtro) {
        List<Contato> listaContatos = new ArrayList<Contato>();

        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();
        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone"},
                "nome LIKE ?", new String[]{"%"+filtro+"%"},
                null, null, null);

        while(cursor.moveToNext()){
            Contato contato = new Contato((cursor.getInt(cursor.getColumnIndex("id"))),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("telefone")));

            listaContatos.add(contato);
        }
        return(listaContatos);    }
}
