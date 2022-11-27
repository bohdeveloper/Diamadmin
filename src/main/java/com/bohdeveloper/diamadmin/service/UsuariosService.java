package com.bohdeveloper.diamadmin.service;

import java.util.List;

import com.bohdeveloper.diamadmin.model.Usuarios;

public interface UsuariosService {
	
	/**
	 * Inserta un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	Usuarios add(Usuarios usuarios);
	
	/**
	 * Edita un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	Usuarios update(Usuarios usuarios);
	
	/**
	 * Elimina un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 */
	void delete(Usuarios usuarios);
	
	/**
	 * Obtiene un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	Usuarios getUsuariosById(Long idUsuarios);
	
	/**
	 * Obtiene varios registros en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	List<Usuarios> getAllUsuarios();

}
