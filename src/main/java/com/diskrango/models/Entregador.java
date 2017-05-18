package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entregador")
public class Entregador extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEntregador;
	
	@Column
	private String placaVeiculo;

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

}
