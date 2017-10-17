package com.beitech.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Representa los productos disponibles por usuario
 * @author lcampo
 *
 */
@Entity
@Table(name = "product_avalaible")
public class ProductoDisponible implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@EmbeddedId
	private ProductoDisponiblePK id;

	public ProductoDisponiblePK getId() {
		return id;
	}

	public void setId(ProductoDisponiblePK id) {
		this.id = id;
	}
	
}
