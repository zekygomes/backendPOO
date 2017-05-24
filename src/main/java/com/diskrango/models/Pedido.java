package com.diskrango.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_pedido;

    @Column(name="data_pedido")
    private Date data_pedido;

    @Column(name="valor_total")
    private Double valor_total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItensPedido> itensPedido;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "entregador", referencedColumnName = "id_entregador")
    private Entregador entregador;

    @Column(name="forma_pagamento")
	private String forma_pagamento;
	
    @Column(name="status_pagamento")
	private boolean status;

	public Pedido(){
	}
	
	@JsonCreator
	public Pedido(@JsonProperty("idPedido")Long id_pedido, @JsonProperty("dataPedido")Date data_pedido, 
			@JsonProperty("valorTotal")Double valor_total, @JsonProperty("idCliente")Cliente cliente, 
			@JsonProperty("itensPedido")List<ItensPedido> itensPedido, @JsonProperty("idEntregador")Entregador entregador, 
			@JsonProperty("formaPagamento")String forma_pagamento, @JsonProperty("status")boolean status) {
		super();
		this.id_pedido = id_pedido;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.entregador = entregador;
		this.forma_pagamento = forma_pagamento;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", data_pedido=" + data_pedido + ", valor_total=" + valor_total
				+ ", cliente=" + cliente + ", itensPedido=" + itensPedido + ", entregador=" + entregador
				+ ", forma_pagamento=" + forma_pagamento + ", status=" + status + "]";
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItensPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
