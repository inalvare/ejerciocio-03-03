package com.formacionsprongboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionsprongboot.apirest.dao.ArticuloDao;
import com.formacionsprongboot.apirest.entity.Articulo;
import com.formacionsprongboot.apirest.entity.Cliente;


@Service
public class ArticuloServiceImpl implements ArticuloService{

	@Autowired
	ArticuloDao AccesoDb;
	
	@Override
	public List<Articulo> ListarTodosArticulos() {

		return (List<Articulo>) AccesoDb.findAll();
	}

	@Override
	public Articulo FinById(Long id) {
		
		return AccesoDb.findById(id).orElse(null);
	}

	@Override
	public Articulo save(Articulo articulo) {
		
		return AccesoDb.save(articulo);
	}

	@Override
	public void Delete(Long id) {

		AccesoDb.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Articulo> FindByNombre(String nombre) {
		
		return AccesoDb.findByNombre(nombre);
	}

}
