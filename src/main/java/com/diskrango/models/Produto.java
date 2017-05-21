package com.diskrango.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long cod_produto;
	
	@Column(name="nome_produto")
	protected String nome_produto;

	@Column(name="preco_produto")
	protected Double preco_produto;
	
	@Column(name="tipo_produto")
	protected String tipo_produto;
	
	@Column(name="qnt_produto")
	protected Integer qnt_produto;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ItensPedido> itensPedido;
	
	
	public Produto(String nome, Double preco, String tipoProduto, Integer qntProduto) {
		super();
		this.nome_produto = nome;
		this.preco_produto = preco;
		this.tipo_produto = tipoProduto;
		this.qnt_produto = qntProduto;
	}

	@Override
	public String toString() {
		return "Produto{codProduto='" + this.cod_produto + '\'' + 
                ", nome='" + this.nome_produto + '\'' +
                ", descricao='" + this.tipo_produto + '\'' +
                ", preco='" + this.preco_produto + '\'' + 
                ", quantidade='" + this.qnt_produto +'\''+'}';
	}

	public Long getCodProduto() {
		return cod_produto;
	}

	public void setCodProduto(Long codProduto) {
		this.cod_produto = codProduto;
	}

	public String getNome() {
		return nome_produto;
	}

	public void setNome(String nome) {
		this.nome_produto = nome;
	}

	public Double getValor() {
		return preco_produto;
	}

	public void setValor(Double valor) {
		this.preco_produto = valor;
	}

	public String getTipoProduto() {
		return tipo_produto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipo_produto = tipoProduto;
	}

	public Integer getQntProduto() {
		return qnt_produto;
	}

	public void setQntProduto(Integer qntProduto) {
		this.qnt_produto = qntProduto;
	}



}
