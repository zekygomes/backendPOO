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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cod_produto;
	
	@Column(name="nome")
	private String nome;

	@Column(name="preco_produto")
	private Double preco_produto;
	
	@Column(name="tipo_produto")
	private String tipo_produto;
	
	@Column(name="qnt_produto")
	private Integer qnt_estoque;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ItensPedido> itensPedido;
    
    public Produto(){}
	
    @JsonCreator
	public Produto(@JsonProperty("codProduto")Long codProduto,@JsonProperty("nome")String nome, @JsonProperty("precoProduto")Double preco, 
			@JsonProperty("tipoProduto")String tipoProduto, @JsonProperty("qntEstoque")Integer qntEstoque) {
		this.cod_produto = codProduto;
		this.nome = nome;
		this.preco_produto = preco;
		this.tipo_produto = tipoProduto;
		this.qnt_estoque = qntEstoque;
	}

	@Override
	public String toString() {
		return "Produto{codProduto='" + this.cod_produto + '\'' + 
                ", nome='" + this.nome + '\'' +
                ", descricao='" + this.tipo_produto + '\'' +
                ", preco='" + this.preco_produto + '\'' + 
                ", quantidade='" + this.qnt_estoque +'\''+'}';
	}
	
	public void atualizarEstoque(Produto produto, Integer qntEstoque){
		produto.qnt_estoque = qntEstoque;
	}

	public Long getCodProduto() {
		return cod_produto;
	}

	public void setCodProduto(Long codProduto) {
		this.cod_produto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return qnt_estoque;
	}

	public void setQntProduto(Integer qntProduto) {
		this.qnt_estoque = qntProduto;
	}



}
