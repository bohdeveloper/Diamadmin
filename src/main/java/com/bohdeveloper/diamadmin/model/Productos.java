package com.bohdeveloper.diamadmin.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "produccion")
@AllArgsConstructor
@NoArgsConstructor

public class Productos {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idProductos;
	 
	 @NotNull(message = "El nombre del producto es obligatorio")
	 @Basic(optional = false)
	 private String nombreProducto;
	 
	 @Basic(optional = true)
	 private Date fechaCaducidad;
	
	 @NotNull(message = "La cantidad del producto es obligatoria")
	 @Basic(optional = false)
	 private BigDecimal controlTemp;
	 
	 @Basic(optional = true)
	 private int devolucion;
	 
	 @Basic(optional = true)
	 private String motivoDevolucion;
	 
	 @ManyToOne(optional = false)
	 private Proveedores proveedores;
	 
	 @ManyToOne(optional = false)
	 private Lotes lotes;
}
