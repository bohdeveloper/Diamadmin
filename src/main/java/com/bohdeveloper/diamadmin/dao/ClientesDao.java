package com.bohdeveloper.diamadmin.dao;

import java.util.List;

import com.bohdeveloper.diamadmin.model.Clientes;

public interface ClientesDao {

	/**
	 * Inserta un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	Clientes add(Clientes clientes);
	
	/**
	 * Edita un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	Clientes update(Clientes clientes);
	
	/**
	 * Elimina un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 */
	void delete(Clientes clientes);
	
	/**
	 * Obtiene un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	Clientes getClientesById(Long idClientes);
	
	/**
	 * Obtiene varios registros en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	List<Clientes> getAllClientes();
	
}
