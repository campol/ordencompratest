/**
 * 
 */
package com.beitech.service;

import java.util.Date;
import java.util.List;

import com.beitech.entity.Cliente;
import com.beitech.entity.Orden;
import com.beitech.entity.Producto;

/**
 * @author lcampo
 *
 */
public interface GeneralService {
	public void crearOrden(Orden orden) throws Exception;
	public List<Orden> getOrdenesPorCliente(int idCliente, Date fechaDesde, Date fechaHasta) throws Exception;
	public List<Cliente> getClientes () throws Exception;
	public List<Producto> getProductosDispPorCliente(int idCliente) throws Exception;
}
