package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_itenspedido;

    @Column(name="preco_unitario")
    private Double preco_unitario;

    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name="preco_total")
    private Double preco_total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto", referencedColumnName = "cod_produto")
    private Produto produto;
    
    @JsonCreator
	public ItensPedido(@JsonProperty("idItensPedido")Long id_itenspedido, @JsonProperty("precoUnitario")Double preco_unitario, 
			@JsonProperty("quantidade")Integer quantidade, @JsonProperty("precoTotal")Double preco_total,
			@JsonProperty("idPedido")Pedido pedido, @JsonProperty("idProduto")Produto produto) {
		super();
		this.id_itenspedido = id_itenspedido;
		this.preco_unitario = preco_unitario;
		this.quantidade = quantidade;
		this.preco_total = preco_total;
		this.pedido = pedido;
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItensPedido [id_itenspedido=" + id_itenspedido + ", preco_unitario=" + preco_unitario + ", quantidade="
				+ quantidade + ", preco_total=" + preco_total + ", pedido=" + pedido + ", produto=" + produto + "]";
	}

	public Long getId_itenspedido() {
		return id_itenspedido;
	}

	public void setId_itenspedido(Long id_itenspedido) {
		this.id_itenspedido = id_itenspedido;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(Double preco_total) {
		this.preco_total = preco_total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
    
    
}