package com.diskrango.models;

import java.util.ArrayList;
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
    private double valor_total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<itensPedido> itensPedido= new ArrayList<itensPedido>();
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "entregador", referencedColumnName = "id_entregador")
    private Entregador entregador;

    @Column(name="forma_pagamento")
	private String forma_pagamento;
	
    @Column(name="status_pedido")
	private String status;

	public Pedido(){
	}
	
	@JsonCreator
	public Pedido(@JsonProperty("idPedido")Long id_pedido, 
			@JsonProperty("itensPedido")ArrayList<itensPedido> itensPedido,
			@JsonProperty("idCliente")Cliente cliente,
			@JsonProperty("dataPedido")Date data_pedido, 
			@JsonProperty("valorTotal")double valor_total,
			@JsonProperty("idEntregador")Long entregador, 
			@JsonProperty("formaPagamento")String forma_pagamento, 
			@JsonProperty("status")String status) {
		super();
		this.id_pedido = id_pedido;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.entregador.setIdEntregador(entregador);
		this.forma_pagamento = forma_pagamento;
		this.status = status;
	}
	
	public Pedido(Long id_pedido, Date data_pedido, 
			Cliente cliente, List<itensPedido> itensPedido, Entregador entregador, 
			String forma_pagamento) {
		super();
		this.id_pedido = id_pedido;
		this.data_pedido = data_pedido;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.entregador = entregador;
		this.forma_pagamento = forma_pagamento;
	}

	@Override
	public String toString() {
		return "Pedido [{id_pedido='" + id_pedido + '\'' +
					", ItensPedido {itensPedido='" + itensPedido + '\''+"}" +	 
					", cliente='" + cliente + '\'' +
					", data_pedido='" + data_pedido + '\'' +
					", valor_total='" + valor_total + '\'' +
					 ", entregador='" + entregador + '\'' +
					 ", forma_pagamento='" + forma_pagamento + '\'' +
					 ", status='" + status + '\'' +"}]";
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

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<itensPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<itensPedido> itensPedido) {
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

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private double gerarValorTotal(List<itensPedido> itensPedido){
		double result=0;
		for(itensPedido pedido: itensPedido ){
			result += pedido.getPreco_total();
		}
		
		return result;
	}
	
	private void atualizarStatusPedido(String status){
		this.status = status;
	}
	
	private void cadastrarEntregador(Entregador entregador){
		this.entregador = entregador;
	}

}
