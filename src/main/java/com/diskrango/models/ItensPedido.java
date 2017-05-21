package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_itenspedido;

    @Column(name="preco_unitario")
    private Double preco_unitario;

    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name="preco_total")
    private Double preco_total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto", referencedColumnName = "cod_produto")
    private Produto produto;
    
}