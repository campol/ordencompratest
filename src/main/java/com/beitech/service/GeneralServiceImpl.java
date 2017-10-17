/**
 * 
 */
package com.beitech.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.dao.GeneralDAO;
import com.beitech.entity.Cliente;
import com.beitech.entity.Orden;
import com.beitech.entity.Producto;

/**
 * @author lcampo
 *
 */
@Service
public class GeneralServiceImpl implements GeneralService {
	@Autowired
	private GeneralDAO genDao;
	/* (non-Javadoc)
	 * @see com.beitech.service.GeneralService#crearOrden(com.beitech.entity.Orden)
	 */
	@Override
	public void crearOrden(Orden orden) throws Exception {
		this.genDao.crearOrden(orden);
	}

	/* (non-Javadoc)
	 * @see com.beitech.service.GeneralService#getOrdenesPorCliente(int, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Orden> getOrdenesPorCliente(int idCliente, Date fechaDesde, Date fechaHasta) throws Exception {
		return this.genDao.getOrdenesPorCliente(idCliente, fechaDesde, fechaHasta);
	}

	/* (non-Javadoc)
	 * @see com.beitech.service.GeneralService#getClientes()
	 */
	@Override
	public List<Cliente> getClientes() throws Exception {
		return this.genDao.getClientes();
	}

	/* (non-Javadoc)
	 * @see com.beitech.service.GeneralService#getProductosDispPorCliente(int)
	 */
	@Override
	public List<Producto> getProductosDispPorCliente(int idCliente) throws Exception {
		return this.genDao.getProductosDispPorCliente(idCliente);
	}

}
