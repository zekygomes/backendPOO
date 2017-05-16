package com.diskrango.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atendentes")
public class Atendente extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAtendente;

	public int getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(int idAtendente) {
		this.idAtendente = idAtendente;
	}
	
	

}