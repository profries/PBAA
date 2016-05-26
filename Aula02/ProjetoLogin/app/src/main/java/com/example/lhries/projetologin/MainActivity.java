package com.example.lhries.projetologin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listaUsuarios = iniciaUsuarios();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void realizarLogin(View v){
        EditText editUsuario = (EditText) findViewById(R.id.editUsuario);
        EditText editSenha = (EditText) findViewById(R.id.editSenha);
        Usuario user = new Usuario(editUsuario.getText().toString(),
                editSenha.getText().toString());

        if(listaUsuarios.contains(user)){
            Toast.makeText(this,"Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Usuario ou senha invalidos!",Toast.LENGTH_SHORT).show();
        }

    }

    private List<Usuario> iniciaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("user1","123"));
        listaUsuarios.add(new Usuario("user2","123"));
        listaUsuarios.add(new Usuario("user3","123"));
        listaUsuarios.add(new Usuario("user4","123"));
        return(listaUsuarios);
    }
}
