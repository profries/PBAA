package com.example.lhries.crud_contatos_bd.model;

import java.io.Serializable;

public class Contato implements Serializable{
    private Integer id;
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(Integer _id, String nome, String telefone){
        this(nome,telefone);
        this.id = _id;
    }

    public void setId(Integer _id){
        this.id = _id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
