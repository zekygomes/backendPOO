package com.diskrango.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Cliente;

@Repository
@Transactional
public class ClienteDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Cliente cliente) {
    getSession().save(cliente);
  }
  
  public void apagar(Cliente cliente) {
    getSession().delete(cliente);
  }
  
  @SuppressWarnings("unchecked")
  public List getAll() {
    return getSession().createQuery("from cliente").list();
  }
  
  public Cliente getByEmail(String email) {
    return (Cliente) getSession().createQuery(
        "from cliente where email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  public Cliente getById(int id) {
    return (Cliente) getSession().load(Cliente.class, id);
  }

  public void update(Cliente cliente) {
    getSession().update(cliente);
  }

}
