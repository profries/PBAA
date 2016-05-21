package com.example.lhries.crud_contatos_bd.dao;

import java.util.List;

public interface GenericDao<T> {
    public void salvar(T entidade);
    public void excluir(T entidade);
    public void atualizar(T entidade);
    public List<T> listar();
    public T procurarPorId(Integer id);
}
