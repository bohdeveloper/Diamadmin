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
@Table(name = "produccion")
@AllArgsConstructor
@NoArgsConstructor

public class Facturas {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idFacturas;
	
	 @NotNull(message = "El código del albarán es obligatorio")
	 @Basic(optional = false)
	 private BigDecimal codAlbaran;
	 
	 @NotNull(message = "La fecha de la factura es obligatoria")
	 @Basic(optional = false)
	 private Date fechaFactura;
	 
	 @ManyToOne(optional = false)
	 private Clientes clientes;
	 
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "facturas")
	 private List<DetalleFacturas> detallesFacturas = new ArrayList<>();
}
