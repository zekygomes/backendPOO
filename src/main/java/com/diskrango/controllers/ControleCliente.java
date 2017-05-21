package com.diskrango.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.dao.ClienteDao;

@RestController
@RequestMapping(value="/cliente")
public class ControleCliente {
	
  @Autowired
  private ClienteDao _clienteDao;
  
  
  @RequestMapping(value="/pegar-todos")
  public List<Cliente> getAll() {
 
	  List<Cliente> clientes = _clienteDao.getAll();
    	//result.toJSONString(clientes);

    return clientes;
  }

  
  @RequestMapping(value="/apagar")
  public String delete(@RequestParam (value="id",required=true)Long id) {
    try {
      Cliente cliente = getById(id);
      _clienteDao.apagar(cliente);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public Cliente getByName(@RequestParam (value="nome",required=true) String nome) {    
	  try {
		  return _clienteDao.getByName(nome);
	  }
    catch(Exception ex) {
    	System.out.println(ex.getMessage());
        return null;
      }
  }
  
  @RequestMapping(value="/pegar-por-id")
  public Cliente getById(@RequestParam (value="id",required=true) Long id) {    
	
    try {
    	return _clienteDao.getById(id);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }

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