package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long codProduto;
	
	@Column(name="nomeProduto")
	protected String nome;
	@Column(name="valorProduto")
	protected double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
