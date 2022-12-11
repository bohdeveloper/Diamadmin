package com.bohdeveloper.diamadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bohdeveloper.diamadmin.model.Usuarios;
import com.bohdeveloper.diamadmin.service.UsuariosService;

@Controller
@RequestMapping(value = "app/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
//    @GetMapping(value = "/{id}")
//  public @ResponseBody Resource<Usuarios> get(@RequestParam(name = "id") Long idUsuarios) {
//    public @ResponseBody Usuarios get(@PathVariable Long idUsuarios) {
//    	Usuarios usuarios = this.usuariosService.getUsuariosById(idUsuarios);
//    	return usuarios;    	
//    }
    
//    @GetMapping()
//    public @ResponseBody List<Usuarios> getAll(@ModelAttribute Usuarios filterUsuarios) {
//    	return ResourceUtils.fromListToResource(this.usuariosService.findAll(filterUsuarios));
//    	return null;
//    }
    
    @PutMapping(value = "/edit")
    public @ResponseBody Usuarios edit(@RequestBody Usuarios usuarios) {
    	usuarios = this.usuariosService.update(usuarios);
    	return usuarios;    	
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
    	Usuarios usuarios = new Usuarios();
    	usuarios.setIdUsuarios(id);
    	this.usuariosService.delete(usuarios);
    	return usuarios;    
    }
    
    @GetMapping(value = "/maint")
    public String getMaint(Model model) {
        Iterable<Usuarios> usuarios = this.usuariosService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("rutaLogo", "../../");
    	return "app/usuarios/usuariosMaint";    	
    }
    
    @GetMapping(value = "/detalle/{id}")
    public String getMantenimiento(Model model, @PathVariable(value = "id") Long id) {
    	if(!id.toString().equals("0")) {
    		model.addAttribute("id", id);
    		Usuarios usuarios = new Usuarios();
        	usuarios.setIdUsuarios(id);
        	model.addAttribute("usuarios", usuarios);
    	} else {
    		model.addAttribute("id", null);
    		Usuarios usuarios = new Usuarios();
        	model.addAttribute("usuarios", usuarios);
    	}
    	model.addAttribute("rutaLogo", "../../../");
    	return "app/usuarios/usuariosDetalle";    	
    }
    

}