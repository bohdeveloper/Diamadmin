package com.bohdeveloper.diamadmin.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "poblacion")
@AllArgsConstructor
@NoArgsConstructor

public class Poblacion {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idPoblacion;
	 
	 @Basic(optional = false)
	 private String desMunicipio;
	 
	 @Basic(optional = false)
	 private String desProvincia;
	 
	 @Basic(optional = false)
	 private String comAutonoma;
	 
	 @Basic(optional = false)
	 private String pais;
	 
	 @Basic(optional = false)
	 private String paisCorto;
	 
	 @Basic(optional = false)
	 private String lat;
	 
	 @Basic(optional = false)
	 private String lng;
	 
	//Estudiarlo
//	 @EqualsAndHashCode.Exclude
//	 @ToString.Exclude
//	 @OneToMany(mappedBy = "cp_proveedores")
//	 private List<Proveedores> cpProveedores = new ArrayList<>();
	 
	//Estudiarlo
//	 @EqualsAndHashCode.Exclude
//	 @ToString.Exclude
//	 @OneToMany(mappedBy = "cp_clientes")
//	 private List<Clientes> cpClientes = new ArrayList<>();
}
