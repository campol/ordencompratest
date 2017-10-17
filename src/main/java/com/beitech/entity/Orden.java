package com.beitech.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad para la orden
 * @author lcampo
 *
 */
@Entity
@Table(name = "orders")
public class Orden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer id;
	@Column(name = "customer_id")
	private Integer idCliente;
	@Column(name = "delivery_address")
	private String dirEntrega;
	@Column(name = "dates")
	private Date fecha;
	@Transient
	private List<OrdenDetalle> detallesOrden;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getDirEntrega() {
		return dirEntrega;
	}
	public void setDirEntrega(String dirEntrega) {
		this.dirEntrega = dirEntrega;
	}
	public List<OrdenDetalle> getDetallesOrden() {
		return detallesOrden;
	}
	public void setDetallesOrden(List<OrdenDetalle> detallesOrden) {
		this.detallesOrden = detallesOrden;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
