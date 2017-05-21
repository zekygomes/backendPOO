package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="bebidas")
public class Bebida extends Produtos{
	
	@Column(name="qntEstoque")
    private int qtdEstoque;

    public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Bebida(){}
	
	@JsonCreator
    public Bebida(@JsonProperty("nome")String nome, @JsonProperty("valor")double valor, @JsonProperty("qtdEstoque")int qtdEstoque) {
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
    }

    public Long getCod(){
    	return this.codProduto;
    }
    
}
