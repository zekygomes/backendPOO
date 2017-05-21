package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="entregador")
public class Entregador extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEntregador;
	
	@Column(name="placaVeiculo")
	private String placaVeiculo;
	
	
	@JsonCreator
	public Entregador(@JsonProperty("idEntregador")Long idEntregador, @JsonProperty("nome")String nome, @JsonProperty("placaVeiculo")String placaVeiculo) {
		this.nome = nome;
		this.idEntregador = idEntregador;
		this.placaVeiculo = placaVeiculo;
	}

	public Long getIdEntregador() {
		return idEntregador;
	}

	public void setIdEntregador(Long idEntregador) {
		this.idEntregador = idEntregador;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

}

