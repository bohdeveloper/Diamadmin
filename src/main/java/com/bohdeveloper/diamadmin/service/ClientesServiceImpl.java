package com.bohdeveloper.diamadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bohdeveloper.diamadmin.dao.ClientesDao;
import com.bohdeveloper.diamadmin.model.Clientes;

@Service(value = "clientesService")
public class ClientesServiceImpl implements ClientesService{
	
	@Autowired
	private ClientesDao clientesDao;

	/**
	 * Inserta un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	@Transactional(rollbackFor = Throwable.class)
	public Clientes add(Clientes clientes) {
		return this.clientesDao.add(clientes);
	}

	/**
	 * Edita un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	@Transactional(rollbackFor = Throwable.class)
	public Clientes update(Clientes clientes) {
		return this.clientesDao.update(clientes);
	}

	/**
	 * Elimina un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void delete(Clientes clientes) {
		this.clientesDao.delete(clientes);
	}

	/**
	 * Obtiene un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public Clientes getClientesById(Long idClientes) {
		return this.clientesDao.getClientesById(idClientes);
	}

	/**
	 * Obtiene varios registros en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public List<Clientes> getAllClientes() {
		return this.clientesDao.getAllClientes();
	}

}
