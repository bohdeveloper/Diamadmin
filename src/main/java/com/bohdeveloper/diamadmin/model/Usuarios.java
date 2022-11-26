package com.bohdeveloper.diamadmin.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor

public class Usuarios {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idUsuarios;

		@NotNull(message = "El nombre de usuario es obligatorio")
	    @Basic(optional = false)
		private String nombreUsuario;
	    
	    @JsonInclude()
	    @Transient
	    @NotNull(message = "La contraseña es obligatoria")
	    @Basic(optional = false)
	    private String password;
	    
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
	    private String telefono;

	    @NotNull(message = "El correo electrónico del contacto es obligatorio")
	    @Basic(optional = false)
	    private String email;

	    @ManyToOne(optional = false)
	    private Roles roles;
	    
	    public Usuarios(Long idUsuarios) {
	    	this.idUsuarios = idUsuarios;
	    }
	    
	    public Usuarios(Long idUsuarios, String password) {
	    	this.idUsuarios = idUsuarios;
	    	this.password = password;
	    }
}
