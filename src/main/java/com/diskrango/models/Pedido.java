package com.diskrango.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_pedido;

    @NotNull
    @Column(name="data_pedido")
    private Date data_pedido;

    @NotNull
    @Column(name="valor_total")
    private Double valor_total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clientes", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItensPedido> itensPedido;

	
	private String codEntregador;
	private String codCliente;
	private String formaPagamento;
	private boolean status;
	private int qntDevolucoes;

	public Pedido(){
		
	}
		

}
