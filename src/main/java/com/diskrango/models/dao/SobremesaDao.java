package com.diskrango.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Sobremesa;

@Repository
@Transactional
public class SobremesaDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Sobremesa sobremesa) {
    getSession().save(sobremesa);
  }
  
  public void apagar(Sobremesa sobremesa) {
    getSession().delete(sobremesa);
  }
  
  @SuppressWarnings("unchecked")
  public List getAll() {
    return getSession().createQuery("from sobremesas").list();
  }
  
  public Sobremesa getById(int codProduto) {
    return (Sobremesa) getSession().load(Sobremesa.class, codProduto);
  }

  public void update(Sobremesa sobremesa) {
    getSession().update(sobremesa);
  }

}