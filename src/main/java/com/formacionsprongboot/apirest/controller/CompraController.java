package com.formacionsprongboot.apirest.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionsprongboot.apirest.entity.Compra;
import com.formacionsprongboot.apirest.entity.Compra;
import com.formacionsprongboot.apirest.service.CompraService;

@RestController
@RequestMapping("/api")
public class CompraController {

	@Autowired
	private CompraService servicio;
	
	@GetMapping("/compras")
	public List<Compra> index(){
		return servicio.findAll();
	}
	
	@GetMapping("/compras/{id}")
	public ResponseEntity<?>  findCompraById(@PathVariable Long id) {
		Compra compra = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			compra = servicio.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(compra == null) {
			response.put("mensaje", "La compra ID: " +id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Compra>(compra, HttpStatus.OK);
		
	}
	
	@PostMapping("/compras/nueva")
	public ResponseEntity<?> saveCompra(@RequestBody Compra compra) {
		 Compra compraNueva= null;
		 Map<String, Object> response = new HashMap<>();
		 
		 try {
			 compraNueva = servicio.save(compra);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 response.put("mensaje", "La compra ha sido creada con éxito!");
		 response.put("compra", compraNueva);
		 
		 return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		 
	}
	
	@PutMapping("/compras/{id}")
	public ResponseEntity<?> updateCompra(@RequestBody Compra compra, @PathVariable Long id) {
		Compra compraActual = servicio.findById(id);
		
		Map<String, Object> response = new HashMap<>();
		
		if(compraActual == null) {
			response.put("mensaje","Error: no se pudo editar, ela compra ID: "+id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			compraActual.setCliente(compra.getCliente());
			compraActual.setArticulo(compra.getArticulo());
			compraActual.setFecha(compra.getFecha());
			compraActual.setUnidades(compra.getUnidades());
			
			servicio.save(compraActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar un update a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		 response.put("mensaje", "La compra ha sido actualizado con éxito!");
		 response.put("compra", compraActual);
		 
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/fechaCompras/{fecha}")
	public List<Compra>  findCompraById(@PathVariable String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
		System.out.println(fecha);
		try {
			return servicio.findByFecha(formato.parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
//		List<Compra> compra = null;
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		String sDate1=fecha;  
//		
//		try {
//			Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//			compra=servicio.findByFecha(fecha);
//			
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al realizar consulta a base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			
//			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(compra == null) {
//			response.put("mensaje", "La compra no existe en la base de datos");
//			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
//		}
//		response.put("compra", compra);
//		return new ResponseEntity<Compra>(HttpStatus.OK);
//		
	}
}



