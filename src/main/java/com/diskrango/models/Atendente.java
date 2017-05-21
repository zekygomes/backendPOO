package com.diskrango.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="atendentes")
public class Atendente extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAtendente;

	public Long getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(Long idAtendente) {
		this.idAtendente = idAtendente;
	}
	@JsonCreator
	public Atendente(@JsonProperty("idAtendente") Long idAtendente, @JsonProperty("nome")String nome) {
		this.nome = nome;
		this.idAtendente = idAtendente;
	}
	
	

}