package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bebidas")
public class Bebida extends Produtos{
	
	@Column
    private int qtdEstoque;

    public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Bebida(){}
    
    public Bebida(String nome, double valor, int qtdEstoque) {
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
    }

    public int getCod(){
    	return this.codProduto;
    }
    
}
