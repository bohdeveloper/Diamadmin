package com.bohdeveloper.diamadmin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "proveedores")
@AllArgsConstructor
@NoArgsConstructor

public class Proveedores {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idProveedores;
	 
	 @NotNull(message = "La dirección del proveedor es obligatoria")
	 @Basic(optional = false)
	 private String direccion;
	 
	 @ManyToOne(optional = false)
	 private Poblacion poblacion;
	 
	 @NotNull(message = "El nombre del proveedor es obligatorio")
	 @Basic(optional = false)
	 private String nombreProveedor;
	 
	 @NotNull(message = "El nombre del contacto es obligatorio")
	 @Basic(optional = false)
	 private String nombreContacto;
	 
	 @NotNull(message = "El primer apellido del contacto es obligatorio")
	 @Basic(optional = false)
	 private String ape1Contacto;

	 @Basic(optional = true)
	 private String ape2Contacto;
	 
	 @NotNull(message = "El teléfono del contacto es obligatorio")
	 @Basic(optional = false)
	 private Integer telefono;
	 
	 @Basic(optional = true)
	 private String email;
	
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "proveedores")
	 private List<Compras> compras = new ArrayList<>();
}
