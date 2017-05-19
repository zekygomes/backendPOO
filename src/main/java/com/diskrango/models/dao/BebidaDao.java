package com.diskrango.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Bebida;

@Repository
@Transactional
public class BebidaDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Bebida bebida) {
    getSession().save(bebida);
  }
  
  public void apagar(Bebida bebida) {
    getSession().delete(bebida);
  }
  
  public void apagar(int codProduto) {
	    getSession().delete(codProduto);
	  }
  
  public Bebida getByNome(String nome) {
	    return (Bebida) getSession().createQuery(
	        "from bebidas where nome = :nome")
	        .setParameter("nome", nome)
	        .uniqueResult();
	  }
  
  @SuppressWarnings("unchecked")
  public List<Bebida> getAll() {
	List<Bebida> bebidas = new ArrayList<Bebida>();
	bebidas = getSession().createQuery("from bebidas").list();
    return bebidas;
  }
  
  public Bebida getById(int codProduto) {
    return (Bebida) getSession().load(Bebida.class, codProduto);
  }

  public void update(Bebida bebida) {
    getSession().update(bebida);
  }

}
