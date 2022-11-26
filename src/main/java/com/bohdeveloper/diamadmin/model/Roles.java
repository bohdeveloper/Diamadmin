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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoles;
    
    @Basic(optional = false)
    private String nombrerol;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "roles")
    private List<Usuarios> usuarios = new ArrayList<>();
    
    public Roles(Long idRoles) {
    	this.idRoles = idRoles;
    }
    
    public Roles(Long idRoles, String nombrerol) {
    	this.idRoles = idRoles;
    	this.nombrerol = nombrerol;
    }
}