package com.example.lhries.projetonavegacaocomresultado;

import java.io.Serializable;

public class Contato implements Serializable{
    private String nome;
    private String telefone;

    public Contato (String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
