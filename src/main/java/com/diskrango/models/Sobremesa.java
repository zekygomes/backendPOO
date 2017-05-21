package com.diskrango.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="sobremesas")
public class Sobremesa extends Produtos{
	
	@JsonCreator
	public Sobremesa(@JsonProperty("codProduto")Long codProduto,@JsonProperty("nome")String nome,@JsonProperty("valor")double valor) {
		this.codProduto = codProduto;
		this.nome = nome;
		this.valor = valor;
	}
	

}
