/**
 * 
 */
package com.beitech.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beitech.entity.Cliente;
import com.beitech.entity.Orden;
import com.beitech.entity.Producto;
import com.beitech.service.GeneralService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author lcampo
 *
 */
@Controller
@RequestMapping("user")
public class GeneralController {
	@Autowired
	private GeneralService service;
	/**
	 * Obtiene la lista de clientes registrados
	 * @return
	 */
	@GetMapping("clientes")
	public ResponseEntity <List<Cliente>> getClientes (){
		List<Cliente> clientes =  new ArrayList<Cliente>();
		try {
			clientes = this.service.getClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity <List<Cliente>> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity <List<Cliente>> (clientes, HttpStatus.OK);
	}
	/**
	 * Obtiene los productos disponibles por clientes
	 * @param idCliente
	 * @return
	 */
	@GetMapping("productosDisponibles")
	public ResponseEntity <List<Producto>> getProductosDispPorClient (@RequestParam("idCliente") String idCliente){
		List<Producto> listProd =  new ArrayList<Producto>();
		try {
			listProd = this.service.getProductosDispPorCliente(Integer.parseInt(idCliente));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity <List<Producto>> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity <List<Producto>> (listProd, HttpStatus.OK);
	}
	/**
	 * Obtiene las ordenes en un rango de fecha de un cliente especificado 
	 * @param idCliente
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	@GetMapping("ordenesPorCliente")
	public ResponseEntity <List<Orden>> getOrdenesPorClient (@RequestParam("idCliente") String idCliente, @RequestParam("fechaDesde") String fechaDesde,
			@RequestParam("fechaHasta") String fechaHasta){
		List<Orden> listOrdenes =  new ArrayList<Orden>();
;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			Date fechaD = df.parse(fechaDesde);
			Date fechaH = df.parse(fechaHasta);
			listOrdenes = this.service.getOrdenesPorCliente(Integer.parseInt(idCliente), fechaD, fechaH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity <List<Orden>> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity <List<Orden>> (listOrdenes, HttpStatus.OK);
	}
	/**
	 * Crea la orden de compra
	 * @param orden
	 * @return
	 */
	@PostMapping("crearOrdn")
	public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden){
		try {
			System.out.println("Vamos");
			this.service.crearOrden(orden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Orden>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Orden>(orden, HttpStatus.CREATED);
	}
}
