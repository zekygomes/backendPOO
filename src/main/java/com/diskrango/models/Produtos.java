package com.diskrango.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codProduto;
	
	private String nome;
	private float preco;
	private int nota;
	private String tipoProduto;
}
