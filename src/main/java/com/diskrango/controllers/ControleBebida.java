package com.diskrango.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Bebida;
import com.diskrango.models.dao.BebidaDao;

@RestController
@RequestMapping(value="/bebida")
public class ControleBebida {

  @Autowired
  private BebidaDao _bebidaDao;
  
  @RequestMapping(value="/cadastrar")
  public String salvar(String nome, double valor, int qtdEstoque) {
    try {
    	Bebida bebida = new Bebida(nome, valor, qtdEstoque);
      _bebidaDao.salvar(bebida);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Bebida cadastrada com sucesso!";
  }
  
  @RequestMapping(value="/atualizar")
  public String salvar(Long codProduto, int qtdEstoque) {
    try {
    	Bebida bebida = _bebidaDao.getById(codProduto);
    	_bebidaDao.update(bebida);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Bebida atualizada com sucesso!";
  }
  
  @RequestMapping(value="/apagar")
  public String delete(Long codProduto) {
    try {
      _bebidaDao.apagar(codProduto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public String getByNome(@RequestParam (value="nome",required=true)String nome) {
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


}