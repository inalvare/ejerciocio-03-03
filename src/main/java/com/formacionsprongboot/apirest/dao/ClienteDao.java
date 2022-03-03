package com.formacionsprongboot.apirest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formacionsprongboot.apirest.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	@Transactional(readOnly=true)
	Optional<Cliente> findByNombre(String nombre);
}
