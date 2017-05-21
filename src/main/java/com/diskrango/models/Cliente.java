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
@Table(name="clientes")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	
	@Column(name="email_cliente")
	private String email;
	@Column(name="endereco_cliente")
	private String endereco;
	@Column(name="telefone_cliente")
	private String telefone;
	@Column(name="ponto_referencia_cliente")
	private String pontoDeReferencia;

	public Cliente() {
	}
	
	public Cliente(Long id) {
	}
	
	public Cliente(String email, String nome) {
		super.nome = nome;
		this.email = email;
	}
	@JsonCreator
	public Cliente(@JsonProperty("idCliente")Long id, @JsonProperty("nome")String nome, @JsonProperty("emailCliente")String email, 
					@JsonProperty("enderecoCliente")String endereco, @JsonProperty("telefoneCliente")String telefone, 
					@JsonProperty("pontoReferenciaCliente")String pontoDeReferencia) {
		this.idCliente =id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public void setId(Long id) {
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
		return "Cliente{ id='" + this.idCliente + '\'' + 
						", nome='" + this.nome + '\'' + 
						", endereço='" + this.endereco + '\''+
						", telefone='" + this.telefone + '\'' + '}';
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
}
