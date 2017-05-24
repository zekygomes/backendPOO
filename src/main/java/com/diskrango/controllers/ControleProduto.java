package com.diskrango.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.Produto;
import com.diskrango.models.dao.ProdutoDao;

@RestController
@RequestMapping(value="/api/produto")
public class ControleProduto {
	
  @Autowired
  private ProdutoDao _produtoDao;
  

  @RequestMapping(value="/salvar")
  public String salvar(Long codProduto, String nome, Double preco,String tipoProduto,Integer qntEstoque) {
    try {
    	Produto produto = new Produto(codProduto, nome, preco, tipoProduto, qntEstoque);
      _produtoDao.salvar(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto salvo com sucesso!";
  }
  
  @RequestMapping(value="/pegar-todos")
  public List<Produto> getAll() {
 
	  List<Produto> produtos = _produtoDao.getAll();

    return produtos;
  }

  
  @RequestMapping(value="/apagar")
  public String delete(@RequestParam (value="codProduto",required=true)Long codProduto) {
    try {
      Produto produto = getById(codProduto);
      _produtoDao.apagar(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public Produto getByName(@RequestParam (value="nome",required=true) String nome) {    
	  try {
		  return _produtoDao.getByName(nome);
	  }
    catch(Exception ex) {
    	System.out.println(ex.getMessage());
        return null;
      }
  }
  
  @RequestMapping(value="/pegar-por-id")
  public Produto getById(@RequestParam (value="codProduto",required=true) Long codProduto) {    
	
    try {
    	return _produtoDao.getById(codProduto);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }

  }

  
  @RequestMapping(value="/atualizarEstoque")
  public String atualizar(@RequestParam (value="codProduto",required=true)Long codProduto, @RequestParam (value="qntEstoque",required=true)Integer qntEstoque) {
    try {
    	Produto produto = getById(codProduto);
    	produto.atualizarEstoque(produto, qntEstoque);
      _produtoDao.update(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto atualizado com sucesso!";
  }
  

}