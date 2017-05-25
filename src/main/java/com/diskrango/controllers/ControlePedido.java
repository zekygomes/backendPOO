package com.diskrango.controllers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.Entregador;
import com.diskrango.models.itensPedido;
import com.diskrango.models.Pedido;
import com.diskrango.models.Produto;
import com.diskrango.models.dao.ClienteDao;
import com.diskrango.models.dao.EntregadorDao;
import com.diskrango.models.dao.PedidoDao;
import com.diskrango.models.dao.ProdutoDao;

@RestController
@RequestMapping(value="/api/pedido")
public class ControlePedido {
	
  @Autowired
  private PedidoDao _pedidoDao;
  
  @Autowired
  private ClienteDao _ClienteDao;
  
  Entregador entregador = new Entregador();

  @RequestMapping(value="/salvar")
  public String salvar(Long id_pedido, 
		  			ArrayList<itensPedido> itensPedido, 
		  			Long idCliente,
		  			Date data_pedido,
		  			double valor_total,
		  			Long idEntregador, 
		  			String forma_pagamento,
		  			String status) {
	  Cliente cliente = _ClienteDao.getById(idCliente);
    try {
    	Pedido pedido = new Pedido(id_pedido, itensPedido,  cliente, data_pedido, valor_total,idEntregador, forma_pagamento,status);
      _pedidoDao.salvar(pedido);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Pedido realizado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-todos")
  public List<Pedido> getAll() {
 
	  List<Pedido> pedidos = _pedidoDao.getAll();

    return pedidos;
  }

  
  @RequestMapping(value="/apagar")
  public String delete(@RequestParam (value="id_pedido",required=true)Long id_pedido) {
    try {
    	Pedido pedido = getById(id_pedido);
      _pedidoDao.apagar(pedido);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Pedido apagado com sucesso!";
  }
  
  @RequestMapping(value="/cancelar")
  public String cancelar(@RequestParam (value="id_pedido",required=true)Long id_pedido) {
    try {
    	Pedido pedido = getById(id_pedido);
      _pedidoDao.apagar(pedido);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Pedido apagado com sucesso!";
  }
    
  @RequestMapping(value="/pegar-por-id")
  public Pedido getById(@RequestParam (value="id_pedido",required=true) Long id_pedido) {    
	
    try {
    	return _pedidoDao.getById(id_pedido);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }

  }

  
  @RequestMapping(value="/atualizarPedido")
  public String atualizar(@RequestParam (value="id_pedido",required=true)Long id_pedido, @RequestParam (value="pedido",required=true)Pedido novoPedido) {
    try {
    	Pedido pedido = getById(id_pedido);
    	_pedidoDao.update(pedido);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Pedido atualizado com sucesso!";
  }
  

}