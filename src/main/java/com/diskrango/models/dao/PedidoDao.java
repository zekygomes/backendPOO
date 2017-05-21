package com.diskrango.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Pedido;

@Repository
@Transactional
public class PedidoDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Pedido pedido) {
    getSession().save(pedido);
  }
  
  public void apagar(Pedido pedido) {
    getSession().delete(pedido);
  }
  
  public void apagar(Long idPedido) {
	    getSession().delete(idPedido);
	  }
  
  @SuppressWarnings("unchecked")
  public List<Pedido> getAll() {
    return getSession().createQuery("from pedidos").list();
  }
  
  public Pedido getById(Long idPedido) {
    return (Pedido) getSession().load(Pedido.class, idPedido);
  }

  public void update(Pedido pedido) {
    getSession().update(pedido);
  }

}
