package com.example.lhries.exemplo_revisao_java;

import com.example.lhries.exemplo_revisao_java.model.Produto;
import com.example.lhries.exemplo_revisao_java.model.Venda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * Created by lhries.
 */
public class VendaTeste {
    @Test
    public void addProduto_isCorrect(){
        Venda venda = new Venda();
        Produto p = new Produto("Produto 1", 30);
        venda.addProduto(p);

        assertTrue(venda.getListaProdutos().contains(p));
        int valorEsperado = 1;
        assertEquals(valorEsperado,venda.getQuantidade());

    }

    @Test
    public void getTotal_isCorrect(){
        Venda v = new Venda();
        v.addProduto(new Produto("cadeira", 30));
        v.addProduto(new Produto("mesa", 120));
        v.addProduto(new Produto("copos", 10));
        try {
            v.setFrete(-10);
            fail("Nao caiu na excecao");
        }catch(IllegalArgumentException exc){
            //Log.e("Error","Erro no frete");
        }

        v.setFrete(20);

        int quantidadeEsperada = 3;
        assertEquals(quantidadeEsperada, v.getQuantidade());

        double valorTotalEsperado = 30+120+10+20;
        assertEquals(valorTotalEsperado, v.getTotal(),0);
    }}
