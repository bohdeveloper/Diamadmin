package com.bohdeveloper.diamadmin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bohdeveloper.diamadmin.model.Roles;
import com.bohdeveloper.diamadmin.model.Usuarios;

@Repository
public class UsuariosDaoImpl implements UsuariosDao {
	
	public static final int STRING_BUILDER_INIT = 4096;
	
	public static final String QUERY_SELECT_FROM = "SELECT t1.ID_USUARIOS ID_USUARIOS, t1.NOMBREUSUARIO NOMBREUSUARIO, "
			+ "t1.PASSWORD PASSWORD, t1.NOMBRECONTACTO NOMBRECONTACTO, t1.APE1CONTACTO APE1CONTACTO, t1.APE2CONTACTO APE2CONTACTO, "
			+ "t1.TELEFONO TELEFONO, t1.EMAIL EMAIL, t2.ID_ROLES ID_ROLES, t2.NOMBREROL NOMBREROL FROM USUARIOS t1 INNER JOIN ROLES t2 ON t1.ID_ROLES = t2.ID_ROLES";
	
	public static final String QUERY_ULTIMOID = "DELETE * FROM USUARIOS WHERE ID_USUARIOS = ?";
	
	public static final String QUERY_ADD = "INSERT INTO USUARIOS (ID_USUARIOS, NOMBREUSUARIO, PASSWORD, NOMBRECONTACTO, "
			+ "APE1CONTACTO, APE2CONTACTO, TELEFONO, EMAIL, ID_ROLES) VALUES (?,?,?,?,?,?,?,?,?))";
	
	public static final String QUERY_UPDATE = "UPDATE USUARIOS SET NOMBREUSUARIO=?, PASSWORD=?, NOMBRECONTACTO=?, APE1CONTACTO=?, APE2CONTACTO=?, TELEFONO=?, EMAIL=?, ID_ROLES=? WHERE ID_USUARIOS=?";
	
	public static final String QUERY_DELETE = "DELETE * FROM USUARIOS WHERE ID_USUARIOS = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public class usuariosMapper implements RowMapper<Usuarios> {
		public Usuarios mapRow(ResultSet rs, int rwNum) throws SQLException {
			return new Usuarios(rs.getLong("ID_USUARIOS"), rs.getString("NOMBREUSUARIO"), 
					rs.getString("PASSWORD"), rs.getString("NOMBRECONTACTO"), 
					rs.getString("APE1CONTACTO"), rs.getString("APE2CONTACTO"), 
					rs.getString("TELEFONO"), rs.getString("EMAIL"), new Roles(rs.getLong("ID_ROLES"), rs.getString("NOMBREROL")));
		}

	};
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Inserta un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public Usuarios add(Usuarios usuarios) {
		//Generar id nuevo para la inserción
		//private Long ultimoId = ...
		this.jdbcTemplate.update(QUERY_ADD, 
				//ultimoId,
				usuarios.getNombreUsuario(), 
				usuarios.getPassword(), usuarios.getNombreContacto(), usuarios.getApe1Contacto(), 
				usuarios.getApe2Contacto(), usuarios.getTelefono(), usuarios.getEmail(), 
				usuarios.getRoles().getIdRoles());
		
		return usuarios;
	}

	/**
	 * Edita un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public Usuarios update(Usuarios usuarios) {
		this.jdbcTemplate.update(QUERY_UPDATE, usuarios.getNombreUsuario(), 
				usuarios.getPassword(), usuarios.getNombreContacto(), usuarios.getApe1Contacto(), 
				usuarios.getApe2Contacto(), usuarios.getTelefono(), usuarios.getEmail(), 
				usuarios.getRoles().getIdRoles());
		
		return usuarios;
	}

	/**
	 * Elimina un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 */
	public void delete(Usuarios usuarios) {
		this.jdbcTemplate.update(QUERY_DELETE, usuarios.getIdUsuarios());
	}

	/**
	 * Obtiene un único registro en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public Usuarios getUsuariosById(Long idUsuarios) {
		StringBuilder query = new StringBuilder(QUERY_SELECT_FROM).append(" WHERE t1.ID_USUARIOS = ?");
		
		return (Usuarios) jdbcTemplate.query(query.toString(), new usuariosMapper(), idUsuarios);
	}

	/**
	 * Obtiene varios registros en la tabla de usuarios
	 * 
	 * @param usuarios Usuarios
	 * 
	 * @return Usuarios
	 */
	public List<Usuarios> getAllUsuarios() {
		List<Usuarios> usuarios = jdbcTemplate.query(QUERY_SELECT_FROM, new BeanPropertyRowMapper<Usuarios>(Usuarios.class));
        return usuarios;
	}
	
	//Implementar findAll donde se busque un registro entre todos y añadir en Lista

}
