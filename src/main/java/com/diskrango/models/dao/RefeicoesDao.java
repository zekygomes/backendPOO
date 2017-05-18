package com.diskrango.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Refeicoes;

@Repository
@Transactional
public class RefeicoesDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Refeicoes refeicao) {
    getSession().save(refeicao);
  }
  
  public void apagar(Refeicoes refeicao) {
    getSession().delete(refeicao);
  }
  
  @SuppressWarnings("unchecked")
  public List getAll() {
    return getSession().createQuery("from refeicoes").list();
  }
  
  public Refeicoes getById(int codProduto) {
    return (Refeicoes) getSession().load(Refeicoes.class, codProduto);
  }

  public void update(Refeicoes refeicao) {
    getSession().update(refeicao);
  }

}