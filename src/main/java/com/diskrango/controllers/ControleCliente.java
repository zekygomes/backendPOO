package com.diskrango.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.dao.ClienteDao;

@RestController
@RequestMapping(value="/cliente")
public class ControleCliente {

  @Autowired
  private ClienteDao _clienteDao;
  
  @RequestMapping(value="/apagar")
  public String delete(int id) {
    try {
      Cliente cliente = new Cliente(id);
      _clienteDao.apagar(cliente);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-email")
  public String getByEmail(String email) {
    String idCliente;
    try {
    	Cliente cliente = _clienteDao.getByEmail(email);
      idCliente = String.valueOf(cliente.getId());
    }
    catch(Exception ex) {
      return "Cliente não encontrado";
    }
    return "O id do cliente é: " + idCliente;
  }

  @RequestMapping(value="/salvar")
  public String salvar(String email, String nome) {
    try {
    	Cliente cliente = new Cliente(email, nome);
      _clienteDao.salvar(cliente);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente salvo com sucesso!";
  }

}