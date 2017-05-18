package com.diskrango.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clientes")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	
	@Column
	private String email;
	@Column
	private String endereco;
	@Column
	private String telefone;
	@Column
	private String pontoDeReferencia;

	public Cliente() {
	}
	
	public Cliente(int id) {
	}
	
	public Cliente(String nome, String email) {
		super.nome = nome;
		this.email = email;
	}

	public Cliente(int id, String nome, String endereco, String telefone, String pontoDeReferencia) {
		this.setIdCliente(id);
		super.setNome(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public int getId() {
		return getIdCliente();
	}

	public void setId(int id) {
		this.setIdCliente(id);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}

	@Override
	public String toString() {
		return "Cliente{ id='" + getIdCliente() + '\'' + ", nome='" + getNome() + '\'' + ", endereço='" + endereco + '\''
				+ ", telefone='" + telefone + '\'' + '}';
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
