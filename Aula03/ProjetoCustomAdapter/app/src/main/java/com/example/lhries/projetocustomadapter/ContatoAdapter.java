package com.example.lhries.projetocustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {
    private List<Contato> listaContatos;
    private Context contexto;

    public ContatoAdapter(Context contexto, List<Contato> listaContatos){
        this.contexto = contexto;
        this.listaContatos = listaContatos;
    }



    @Override
    public int getCount() {
        return listaContatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaContatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Contato contato = listaContatos.get(position);


        LayoutInflater inflater = (LayoutInflater)contexto.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        View viewInflate = inflater.inflate(R.layout.list_item,null);

        TextView textNome = (TextView) viewInflate.findViewById(R.id.list_text_idNome);
        textNome.setText(contato.getNome());

        TextView textTelefone = (TextView) viewInflate.findViewById(R.id.list_text_idTelefone);
        textTelefone.setText(contato.getTelefone());

        return viewInflate;
    }
}
