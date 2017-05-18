package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bebidas")
public class Bebida extends Produtos{
	
	@Column
    private int qtdEstoque;

    public Bebida(){}

    public Bebida(int id, String nome, double valor, int quantideEmEstoque) {
        super.codProduto = id;
        super.nome = nome;
        super.valor = valor;
        this.qtdEstoque = quantideEmEstoque;
    }


    public int getQuantideEmEstoque() {
        return qtdEstoque;
    }

    public void setQuantideEmEstoque(int quantideEmEstoque) {
        this.qtdEstoque = quantideEmEstoque;
    }
	

}
