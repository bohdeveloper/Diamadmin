package com.bohdeveloper.diamadmin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "compras")
@AllArgsConstructor
@NoArgsConstructor

public class Compras {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idCompras;
	 
	 @NotNull(message = "El lote del producto es obligatorio")
	 @Basic(optional = false)
	 private String loteInicialCompras;
	 
	 @NotNull(message = "El código del albarán es obligatorio")
	 @Basic(optional = false)
	 private String codalbaran;
	 
	 @NotNull(message = "El nombre del producto es obligatorio")
	 @Basic(optional = false)
	 private String nombreProducto;
	 
	 @NotNull(message = "La fecha de la compra es obligatoria")
	 @Basic(optional = false)
	 private Date fechaCompra;
	 
	 @NotNull(message = "El precio/Kg/L del producto es obligatorio")
	 @Basic(optional = false)
	 private BigDecimal precioKiloLitro;
	
	 @NotNull(message = "La cantidad del producto es obligatoria")
	 @Basic(optional = false)
	 private BigDecimal kilosLitros;
	 
	 @Basic(optional = true)
	 private BigDecimal controlTemp;
	 
	 @Basic(optional = true)
	 private Integer devolucion;
	 
	 @Basic(optional = true)
	 private String motivoDev;
	 
	 @ManyToOne(optional = false)
	 private Proveedores proveedores;
	 
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "compras")
	 private List<Produccion> produccion = new ArrayList<>();
}
