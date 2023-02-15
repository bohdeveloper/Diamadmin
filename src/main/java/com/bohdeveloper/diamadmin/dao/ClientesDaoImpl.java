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

import com.bohdeveloper.diamadmin.model.Clientes;
import com.bohdeveloper.diamadmin.model.Poblacion;

@Repository
public class ClientesDaoImpl implements ClientesDao {
	
	public static final int STRING_BUILDER_INIT = 4096;
	
	public static final String QUERY_SELECT_FROM = "SELECT t1.ID_CLIENTES IDCLIENTES, t1.CP_CLIENTE CPCLIENTE, "
			+ "t1.DIRECCION DIRECCION, t1.NOMBRE_EMPRESA NOMBREEMPRESA, t1.NOMBRE_CONTACTO NOMBRECONTACTO, t1.APE1_CONTACTO APE1CONTACTO, "
			+ "t1.APE2_CONTACTO APE2CONTACTO, t1.TELEFONO TELEFONO, t1.EMAIL EMAIL FROM CLIENTES t1";
	
	//INNER JOIN DE POBLACIÓN
	
	public static final String QUERY_ULTIMOID = "DELETE * FROM CLIENTES WHERE ID_CLIENTES = ?";
	
	public static final String QUERY_ADD = "INSERT INTO CLIENTES (ID_CLIENTES, CP_CLIENTE, DIRECCION, NOMBRE_EMPRESA, NOMBRE_CONTACTO, "
			+ "APE1_CONTACTO, APE2_CONTACTO, TELEFONO, EMAIL) VALUES (?,?,?,?,?,?,?,?,?))";
	
	public static final String QUERY_UPDATE = "UPDATE CLIENTES SET CP_CLIENTE=?, DIRECCION=?, NOMBRE_EMPRESA=?, NOMBRE_CONTACTO=?, "
			+ "APE1_CONTACTO=?, APE2_CONTACTO=?, TELEFONO=?, EMAIL=? WHERE ID_CLIENTES=?";
	
	public static final String QUERY_DELETE = "DELETE * FROM CLIENTES WHERE ID_CLIENTES = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public class clientesMapper implements RowMapper<Clientes> {
		public Clientes mapRow(ResultSet rs, int rwNum) throws SQLException {
			return new Clientes(rs.getLong("ID_CLIENTES"), new Poblacion(), rs.getString("NOMBREUSUARIO"), 
					rs.getString("PASSWORD"), rs.getString("NOMBRECONTACTO"), 
					rs.getString("APE1CONTACTO"), rs.getString("APE2CONTACTO"), 
					rs.getInt("TELEFONO"), rs.getString("EMAIL"), null);
			
			//AÑADIR POBLACIÓN
		}

	};
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Inserta un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public Clientes add(Clientes clientes) {
		//Generar id nuevo para la inserción
		//private Long ultimoId = ...
		this.jdbcTemplate.update(QUERY_ADD, 
				//ultimoId,
				clientes.getPoblacion().getCp(), 
				clientes.getDireccion(), 
				clientes.getNombreEmpresa(), 
				clientes.getNombreContacto(), 
				clientes.getApe1Contacto(), 
				clientes.getApe2Contacto(), 
				clientes.getTelefono(), 
				clientes.getEmail());
		
		return clientes;
	}

	/**
	 * Edita un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public Clientes update(Clientes clientes) {
		this.jdbcTemplate.update(QUERY_UPDATE, 
				clientes.getPoblacion().getCp(), 
				clientes.getDireccion(), 
				clientes.getNombreEmpresa(), 
				clientes.getNombreContacto(), 
				clientes.getApe1Contacto(), 
				clientes.getApe2Contacto(), 
				clientes.getTelefono(), 
				clientes.getEmail(),
				clientes.getIdClientes());
		
		return clientes;
	}

	/**
	 * Elimina un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 */
	public void delete(Clientes clientes) {
		this.jdbcTemplate.update(QUERY_DELETE, clientes.getIdClientes());
	}

	/**
	 * Obtiene un único registro en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public Clientes getClientesById(Long idClientes) {
		StringBuilder query = new StringBuilder(QUERY_SELECT_FROM).append(" WHERE t1.ID_CLIENTES = ?");
		
		return (Clientes) jdbcTemplate.query(query.toString(), new clientesMapper(), idClientes);
	}

	/**
	 * Obtiene varios registros en la tabla de clientes
	 * 
	 * @param clientes Clientes
	 * 
	 * @return Clientes
	 */
	public List<Clientes> getAllClientes() {
		List<Clientes> clientes = jdbcTemplate.query(QUERY_SELECT_FROM, new BeanPropertyRowMapper<Clientes>(Clientes.class));
        return clientes;
	}
	
	//Implementar findAll donde se busque un registro entre todos y añadir en Lista

}
