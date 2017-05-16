package com.diskrango.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="clientes")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;

	private String nome;

	private String email;

	private String endereco;

	private String telefone;

	private String pontoDeReferencia;

	public Cliente() {
	}
	
	public Cliente(long id) {
	}
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Cliente(int id, String nome, String endereco, String telefone, String pontoDeReferencia) {
		this.idCliente = id;
		super.setNome(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public int getId() {
		return idCliente;
	}

	public void setId(int id) {
		this.idCliente = id;
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
		return "Cliente{ id='" + idCliente + '\'' + ", nome='" + getNome() + '\'' + ", endereço='" + endereco + '\''
				+ ", telefone='" + telefone + '\'' + '}';
	}
}
