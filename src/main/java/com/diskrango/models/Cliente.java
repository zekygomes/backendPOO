package com.diskrango.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="cliente")
public class Cliente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cliente;
	@Email
	@Column(name="email_cliente")
	private String email_cliente;
	@Column(name="endereco_cliente")
	private String endereco_cliente;
	@Column(name="telefone_cliente")
	private String telefone_cliente;
	@Column(name="ponto_referencia_cliente")
	private String ponto_referencia_cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

	public Cliente() {
	}

	@JsonCreator
	public Cliente(@JsonProperty("idCliente")Long id, @JsonProperty("nome")String nome, @JsonProperty("email_cliente")String email, 
					@JsonProperty("endereco_cliente")String endereco, @JsonProperty("telefone_cliente")String telefone, 
					@JsonProperty("ponto_referencia_cliente")String pontoDeReferencia) {
		this.id_cliente = id;
		this.nome = nome;
		this.email_cliente = email;
		this.endereco_cliente = endereco;
		this.telefone_cliente = telefone;
		this.ponto_referencia_cliente = pontoDeReferencia;
	}

	public void setId(Long id) {
		this.setIdCliente(id);
	}

	public String getEndereco() {
		return endereco_cliente;
	}

	public void setEndereco(String endereco) {
		this.endereco_cliente = endereco;
	}

	public String getTelefone() {
		return telefone_cliente;
	}

	public void setTelefone(String telefone) {
		this.telefone_cliente = telefone;
	}

	public String getPontoDeReferencia() {
		return ponto_referencia_cliente;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.ponto_referencia_cliente = pontoDeReferencia;
	}

	@Override
	public String toString() {
		return "Cliente{ id='" + this.id_cliente + '\'' + 
						", nome='" + this.nome + '\'' + 
						", email='" + this.email_cliente + '\'' + 
						", endereço='" + this.endereco_cliente + '\''+
						", telefone='" + this.telefone_cliente + '\'' + '}';
	}

	public Long getIdCliente() {
		return this.id_cliente;
	}

	public void setIdCliente(Long idCliente) {
		this.id_cliente = idCliente;
	}
}
