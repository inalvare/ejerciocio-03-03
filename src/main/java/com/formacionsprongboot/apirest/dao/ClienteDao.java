package com.formacionsprongboot.apirest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionsprongboot.apirest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{

	List<Cliente> findByNombre(String nombre);
}
