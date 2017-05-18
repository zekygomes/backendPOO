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
    
    public Bebida(int codProduto){
    	super.codProduto = codProduto;
    }
    
    public Bebida(int id, String nome, double valor, int quantideEmEstoque) {
        this.codProduto = id;
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = quantideEmEstoque;
    }

    public int getCod(){
    	return this.codProduto;
    }
    
    public int getQuantideEmEstoque() {
        return qtdEstoque;
    }

    public void setQuantideEmEstoque(int quantideEmEstoque) {
        this.qtdEstoque = quantideEmEstoque;
    }
	

}
