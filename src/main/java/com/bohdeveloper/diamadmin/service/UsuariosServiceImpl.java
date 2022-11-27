package com.bohdeveloper.diamadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bohdeveloper.diamadmin.dao.UsuariosDao;
import com.bohdeveloper.diamadmin.model.Usuarios;

@Service(value = "usuariosService")
public class UsuariosServiceImpl implements UsuariosService{
	
	@Autowired
	private UsuariosDao usuariosDao;

	/**
	 * Inserta un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	@Transactional(rollbackFor = Throwable.class)
	public Usuarios add(Usuarios usuarios) {
		return this.usuariosDao.add(usuarios);
	}

	/**
	 * Edita un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	@Transactional(rollbackFor = Throwable.class)
	public Usuarios update(Usuarios usuarios) {
		return this.usuariosDao.update(usuarios);
	}

	/**
	 * Elimina un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void delete(Usuarios usuarios) {
		this.usuariosDao.delete(usuarios);
	}

	/**
	 * Obtiene un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public Usuarios getUsuariosById(Long idUsuarios) {
		return this.usuariosDao.getUsuariosById(idUsuarios);
	}

	/**
	 * Obtiene varios registros en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public List<Usuarios> getAllUsuarios() {
		return this.usuariosDao.getAllUsuarios();
	}

}
