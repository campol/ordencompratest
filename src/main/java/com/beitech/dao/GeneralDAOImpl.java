/**
 * 
 */
package com.beitech.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beitech.entity.Cliente;
import com.beitech.entity.Orden;
import com.beitech.entity.OrdenDetalle;
import com.beitech.entity.Producto;

/**
 * @author lcampo
 *
 */
@Transactional
@Repository
public class GeneralDAOImpl implements GeneralDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.beitech.dao.GeneralDAO#crearOrden(com.beitech.entity.Orden)
	 */
	 @Transactional(readOnly = false)
	@Override
	public void crearOrden(Orden orden) throws Exception {
		entityManager.persist(orden);
		entityManager.flush();
		for(OrdenDetalle detalle: orden.getDetallesOrden()) {
			detalle.setIdOrden(orden.getId());
			entityManager.persist(detalle);
		}
	}

	/* (non-Javadoc)
	 * @see com.beitech.dao.GeneralDAO#getOrdenesPorCliente(int, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Orden> getOrdenesPorCliente(int idCliente, Date fechaDesde, Date fechaHasta) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select o from Orden as o");
		sb.append(" where o.fecha between :fechaDesde and :fechaHasta");
		sb.append(" and o.idCliente = :idCliente");
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		query.setParameter("idCliente", idCliente);
		List<Orden> ordenes = (List<Orden>) query.getResultList();
		sb = new StringBuilder();
		sb.append("select det from OrdenDetalle det where det.idOrden = :idOrden");
		for(Orden orden: ordenes) {
			query = entityManager.createQuery(sb.toString());
			query.setParameter("idOrden", orden.getId());
			List<OrdenDetalle> detallesOrden = (List<OrdenDetalle>) query.getResultList();
			orden.setDetallesOrden(detallesOrden);
		}
		return ordenes;
	}

	/* (non-Javadoc)
	 * @see com.beitech.dao.GeneralDAO#getClientes()
	 */
	@Override
	public List<Cliente> getClientes() throws Exception {
		Query query = entityManager.createQuery("select c from Cliente as c");
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		return clientes;
	}

	/* (non-Javadoc)
	 * @see com.beitech.dao.GeneralDAO#getProductosDispPorCliente(int)
	 */
	@Override
	public List<Producto> getProductosDispPorCliente(int idCliente) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("select p ");
		sb.append("from Producto p, ProductoDisponible pd ");
		sb.append("where p.id = pd.id.idProducto ");
		sb.append(" and pd.id.idCliente = "+idCliente);
		Query query = entityManager.createQuery(sb.toString());
		List<Producto> listProduct = query.getResultList();
		return listProduct;
	}

}
