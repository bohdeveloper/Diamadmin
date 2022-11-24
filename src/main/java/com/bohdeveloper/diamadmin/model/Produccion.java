package com.bohdeveloper.diamadmin.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

public class Produccion {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idProduccion;
	 
	 @Basic(optional = false)
	 private String loteInicialProd;
	 
	 @NotNull(message = "El lote del producto es obligatorio")
	 @Basic(optional = false)
	 private String loteFinalProd;
	 
	 @NotNull(message = "El nombre del producto es obligatorio")
	 @Basic(optional = false)
	 private String nombreProducto;
	 
	 @NotNull(message = "La fecha de la manipulación es obligatoria")
	 @Basic(optional = false)
	 private Date fechaProduccion;
	
	 @NotNull(message = "La cantidad del producto es obligatoria")
	 @Basic(optional = false)
	 private BigDecimal kilosLitros;
	 
	 @OneToOne(optional = false)
	 private Ventas ventas;
}
