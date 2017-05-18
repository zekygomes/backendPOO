package com.diskrango.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Pedidos;

@Repository
@Transactional
public class PedidoDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Pedidos pedido) {
    getSession().save(pedido);
  }
  
  public void apagar(Pedidos pedido) {
    getSession().delete(pedido);
  }
  
  @SuppressWarnings("unchecked")
  public List getAll() {
    return getSession().createQuery("from pedidos").list();
  }
  
  public Pedidos getById(int idPedido) {
    return (Pedidos) getSession().load(Pedidos.class, idPedido);
  }

  public void update(Pedidos pedido) {
    getSession().update(pedido);
  }

}
