package com.bohdeveloper.diamadmin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

public class Lotes {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idLotes;
	 
	 @NotNull(message = "El lote es obligatorio")
	 @Basic(optional = false)
	 private String lote;
	 
	 @NotNull(message = "El estado del lote es obligatorio")
	 @Basic(optional = false)
	 private int estado;
	 
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "lotes")
	 private List<Productos> productos = new ArrayList<>();
	 
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @OneToMany(mappedBy = "lotes")
	 private List<Productos> detallesFacturas = new ArrayList<>();
	
}
