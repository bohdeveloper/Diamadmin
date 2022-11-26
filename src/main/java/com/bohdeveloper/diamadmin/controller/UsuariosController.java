package com.bohdeveloper.diamadmin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bohdeveloper.diamadmin.model.Usuarios;

@Controller
@RequestMapping(value = "app/usuarios")
public class UsuariosController {
	
    @GetMapping(value = "/{id}")
//  public @ResponseBody Resource<Usuarios> get(@RequestParam(name = "id") Long idUsuarios) {
    public @ResponseBody Usuarios get(@PathVariable Long idUsuarios) {
    	Usuarios usuarios = new Usuarios();
//    	usuarios.setIdUsuarios(idUsuarios);
//    	usuarios = this.usuariosService.find(usuarios);
    	return usuarios;    	
    }
    
    @GetMapping()
    public @ResponseBody List<Usuarios> getAll(@ModelAttribute Usuarios filterUsuarios) {
//    	return ResourceUtils.fromListToResource(this.usuariosService.findAll(filterUsuarios));
    	return null;
    }
    
    @PutMapping(value = "/edit")
    public @ResponseBody Usuarios edit(@RequestBody Usuarios usuarios) {
//    	Usuarios usuarios = this.usuariosService.update(usuarios);
//    	return usuarios;    	
    	return null;
    }
    
    @PostMapping(value = "/add")
    public @ResponseBody Usuarios add(@RequestBody Usuarios usuarios) {
    	//Comprobar existencias de usuarios repetidos
//    	Usuarios usuarioConsulta = new Usuarios();
//    	usuarioConsulta.setNombreUsuario(usuarios.getNombreUsuario());
//    	List<Usuarios> lUsuariosNombreUsuario = usuariosService.findAll(usuarioConsulta);
//    	Usuarios usuariosAux = new Usuarios();
//    	if(lUsuariosNombreUsuario.isEmpty()) {
//    		usuarioConsulta.setEmail(usuarios.getEmail());
//    		List<Usuarios> lUsuariosEmail = usuariosService.findAll(usuarioConsulta);
//    		if(lUsuariosEmail.isEmpty()) {
//    			usuariosAux = this.usuariosService.add(usuarios);
//    		} else {
//        		throw new NegocioException("Este email ya esta registrado");
//        	}
//    	} else {
//    		throw new NegocioException("El nombre de usuario esta ocupado");
//    	}
    
//    	return usuariosAux;    	
    	return null;
    }
    
    @PutMapping(value = "/delete")
    public @ResponseBody Usuarios delete(@RequestParam Long id) {
//    	Usuarios usuarios = new Usuarios();
//    	usuarios.setIdUsuarios(id);
//    	this.usuariosService.delete(usuarios);
//    	return usuarios;    	
    	return null;
    }
    
    @GetMapping(value = "/maint")
    public String getMaint(Model model) {
    	model.addAttribute("usuarios", new Usuarios());
    	return "usuarios";    	
    }
    
    @GetMapping(value = "/mantenimiento/{id}")
    public String getMantenimiento(Model model, @PathVariable(value = "id") Long id) {
    	if(!id.toString().equals("0")) {
    		model.addAttribute("id", id);
    	} else {
    		model.addAttribute("id", null);
    	}
    	model.addAttribute("usuariosDetalle", new Usuarios());
    	return "usuariosDetalle";    	
    }
    

}