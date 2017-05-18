package com.diskrango.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Bebida;
import com.diskrango.models.dao.BebidaDao;

@RestController
@RequestMapping(value="/bebida")
public class ControleBebida {

  @Autowired
  private BebidaDao _bebidaDao;
  
  @RequestMapping(value="/apagar")
  public String delete(int codProduto) {
    try {
    	Bebida bebida = new Bebida(codProduto);
      _bebidaDao.apagar(bebida);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public String getByNome(String nome) {
    String codProduto;
    try {
    	Bebida bebida = _bebidaDao.getByNome(nome);
      codProduto = String.valueOf(bebida.getCod());
    }
    catch(Exception ex) {
      return "Bebida não encontrada";
    }
    return "O código da Bebida é: " + codProduto;
  }

  @RequestMapping(value="/salvar")
  public String salvar(int id, String nome, double valor, int quantideEmEstoque) {
    try {
    	Bebida bebida = new Bebida(id, nome, valor, quantideEmEstoque);
      _bebidaDao.salvar(bebida);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Bebida cadastrada com sucesso!";
  }

}