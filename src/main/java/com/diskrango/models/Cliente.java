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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cliente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email_cliente")
	private String email_cliente;

	@Column(name="endereco_cliente")
	private String endereco_cliente;
	
	@Column(name="telefone_cliente")
	private String telefone_cliente;
	
	@Column(name="ponto_referencia_cliente")
	private String ponto_referencia_cliente;
	
	@Column(name="situacao_cliente")
	private Boolean situacao_cliente;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

	public Cliente() {
	}

	@JsonCreator
	public Cliente(@JsonProperty("idCliente")Long id, @JsonProperty("nome")String nome, @JsonProperty("emailCliente")String email, 
					@JsonProperty("enderecoCliente")String endereco, @JsonProperty("telefoneCliente")String telefone, 
					@JsonProperty("pontoDeReferencia")String pontoDeReferencia, @JsonProperty("situacaoCliente")Boolean situacaoCliente) {
		this.id_cliente = id;
		this.nome = nome;
		this.email_cliente = email;
		this.endereco_cliente = endereco;
		this.telefone_cliente = telefone;
		this.ponto_referencia_cliente = pontoDeReferencia;
		this.situacao_cliente = situacaoCliente;
	}

	@Override
	public String toString() {
		return "Cliente{ id='" + this.id_cliente + '\'' + 
						", nome='" + this.nome + '\'' + 
						", email='" + this.email_cliente + '\'' + 
						", endereço='" + this.endereco_cliente + '\''+
						", telefone='" + this.telefone_cliente + '\'' +
						", situacao='" + this.situacao_cliente + '\'' +'}';
	}

	public Long getIdCliente() {
		return this.id_cliente;
	}

	public void setIdCliente(Long idCliente) {
		this.id_cliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
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


	public Boolean getSituacao_cliente() {
		return situacao_cliente;
	}

	public void setSituacao_cliente(Boolean situacao_cliente) {
		this.situacao_cliente = situacao_cliente;
	}

}
