package com.example.lhries.crud_contatos_bd.dao;

import com.example.lhries.crud_contatos_bd.model.Contato;

import java.util.List;


public interface ContatoDao extends GenericDao<Contato>{
    public List<Contato> procurarPorNome(String palavra_chave);
}
