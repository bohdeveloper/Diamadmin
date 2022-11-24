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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	 
	 @OneToOne(optional = false)
	 private Produccion produccion;
	 
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "ventas")
	 private List<Clientes> clientes = new ArrayList<>();
}
