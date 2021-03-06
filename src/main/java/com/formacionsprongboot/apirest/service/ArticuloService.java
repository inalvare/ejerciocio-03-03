package com.formacionsprongboot.apirest.service;

import java.util.List;

import com.formacionsprongboot.apirest.entity.Articulo;
import com.formacionsprongboot.apirest.entity.Cliente;

public interface ArticuloService {
		
		public List<Articulo> ListarTodosArticulos();
		
		public Articulo FinById(Long id);
		
		public Articulo save(Articulo articulo);
		
		public void Delete(Long id);

		public List<Articulo> FindByNombre(String nombre);

}
