package com.formacionsprongboot.apirest.service;

import java.util.List;
import java.util.Optional;

import com.formacionsprongboot.apirest.entity.Cliente;


public interface ClienteService {
	
	public List<Cliente> ListarTodosClientes();
	
	public Cliente FinById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void Delete(Long id);

	public List<Cliente> FinByNombre(String nombre);

}
