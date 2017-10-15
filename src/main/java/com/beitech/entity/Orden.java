package com.beitech.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
public class Orden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
	private Integer id;
	@Column(name = "customer_id")
	private Integer idCliente;
	@Column(name = "delivery_address")
	private String dirEntrega;
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
	
}
