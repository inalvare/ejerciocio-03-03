package com.formacionsprongboot.apirest.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionsprongboot.apirest.entity.Compra;

@Repository
public interface CompraDao extends CrudRepository<Compra, Long> {
	@Query(value="SELECT * FROM compras WHERE fecha = ?1", nativeQuery=true)
	List<Compra> findByFecha(java.util.Date fecha);
}
