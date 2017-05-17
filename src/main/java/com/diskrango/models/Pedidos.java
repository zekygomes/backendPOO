package com.diskrango.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPedido;

	private String data;
	private String codEntregador;
	private String codCliente;
	private String formaPagamento;
	private boolean status;
	private int qntDevolucoes;

	public Pedidos(){
		
	}
		

}
