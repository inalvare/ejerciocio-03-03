package com.formacionsprongboot.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionsprongboot.apirest.entity.Articulo;

@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Long>{
	
	
	List<Articulo> findByNombre(String nombre);

}
