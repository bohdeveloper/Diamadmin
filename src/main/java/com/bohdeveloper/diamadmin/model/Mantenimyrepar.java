package com.bohdeveloper.diamadmin.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "compras")
@AllArgsConstructor
@NoArgsConstructor

public class Mantenimyrepar {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idMyr;
	
	 @NotNull(message = "El nombre del objeto es obligatorio")
	 @Basic(optional = false)
	 private String nombreObjeto;
	 
	 @NotNull(message = "La fecha del aviso es obligatoria")
	 @Basic(optional = false)
	 private Date fecha;
	 
	 @NotNull(message = "El precio de la intervención es obligatorio")
	 @Basic(optional = false)
	 private BigDecimal coste;
	
	 @NotNull(message = "El motivo de la intervención es obligatorio")
	 @Basic(optional = true)
	 private String motivo;
}
