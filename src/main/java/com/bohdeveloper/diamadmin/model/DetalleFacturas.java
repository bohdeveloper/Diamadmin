package com.bohdeveloper.diamadmin.model;

import java.math.BigDecimal;

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

public class DetalleFacturas {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idDetalleFacturas;
	
	 @NotNull(message = "La cantidad del producto es obligatoria")
	 @Basic(optional = false)
	 private BigDecimal cantidad;
	 
	 @NotNull(message = "El precio del producto es obligatorio")
	 @Basic(optional = false)
	 private BigDecimal precio;
	 
	 @ManyToOne(optional = false)
	 private Facturas facturas;
	 
	 @ManyToOne(optional = false)
	 private Lotes lotes;
}
