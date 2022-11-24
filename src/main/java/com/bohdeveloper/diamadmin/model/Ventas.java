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
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor

public class Ventas {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idVentas;
	 
	 @Basic(optional = false)
	 private String loteFinalVentas;
	 
	 @NotNull(message = "El nombre del producto es obligatorio")
	 @Basic(optional = false)
	 private String codalbaran;
	 
	 @NotNull(message = "La fecha de la venta es obligatoria")
	 @Basic(optional = false)
	 private Date fechaVenta;
	 
	 @NotNull(message = "El precio/Kg/L del producto es obligatorio")
	 @Basic(optional = false)
	 private BigDecimal preciokilolitro;
	
}
