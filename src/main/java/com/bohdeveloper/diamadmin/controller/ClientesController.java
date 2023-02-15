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

import com.bohdeveloper.diamadmin.model.Clientes;
import com.bohdeveloper.diamadmin.service.ClientesService;

@Controller
@RequestMapping(value = "app/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;
	
//    @GetMapping(value = "/{id}")
//  public @ResponseBody Resource<Clientes> get(@RequestParam(name = "id") Long idClientes) {
//    public @ResponseBody Clientes get(@PathVariable Long idClientes) {
//    	Clientes clientes = this.clientesService.getClientesById(idUsuaidClientesrios);
//    	return clientes;    	
//    }
    
//    @GetMapping()
//    public @ResponseBody List<Clientes> getAll(@ModelAttribute Clientes filterClientes) {
//    	return ResourceUtils.fromListToResource(this.usuariosService.findAll(filterClientes));
//    	return null;
//    }
    
    @PutMapping(value = "/edit")
    public @ResponseBody Clientes edit(@RequestBody Clientes clientes) {
    	clientes = this.clientesService.update(clientes);
    	return clientes;    	
    }
    
    @PostMapping(value = "/add")
    public @ResponseBody Clientes add(@RequestBody Clientes clientes) {
    	//Comprobar existencias de clientes repetidos
//    	Clientes clienteConsulta = new Clientes();
//    	clienteConsulta.setNombreEmpresa(clientes.getNombreEmpresa());
//    	List<Clientes> lClientesNombreEmpresa = this.clientesService.findAll(clienteConsulta);
//    	Clientes clienteAux = new Clientes();
//    	if(lClientesNombreEmpresa.isEmpty()) {
//    		clienteConsulta.setEmail(clientes.getEmail());
//    		List<Clientes> lClientesEmail = this.clientesService.findAll(clienteConsulta);
//    		if(lClientesEmail.isEmpty()) {
//    			clienteAux = this.clientesService.add(clientes);
//    		} else {
//        		throw new NegocioException("El email ya esta registrado");
//        	}
//    	} else {
//    		throw new NegocioException("El nombre del cliente ya esta registrado");
//    	}
    
//    	return clienteAux;    	
    	return null;
    }
    
    @PutMapping(value = "/delete")
    public @ResponseBody Clientes delete(@RequestParam Long id) {
    	Clientes clientes = new Clientes();
    	clientes.setIdClientes(id);
    	this.clientesService.delete(clientes);
    	return clientes;    
    }
    
    @GetMapping(value = "/maint")
    public String getMaint(Model model) {
        Iterable<Clientes> clientes = this.clientesService.getAllClientes();
        model.addAttribute("clientes", clientes);
    	return "app/clientes/clientesMaint";    	
    }
    
    @GetMapping(value = "/detalle/{id}")
    public String getMantenimiento(Model model, @PathVariable(value = "id") Long id) {
    	if(!id.toString().equals("0")) {
    		model.addAttribute("id", id);
    		Clientes clientes = new Clientes();
    		clientes.setIdClientes(id);
        	model.addAttribute("clientes", clientes);
    	} else {
    		model.addAttribute("id", null);
    		Clientes clientes = new Clientes();
        	model.addAttribute("clientes", clientes);
    	}
    	return "app/clientes/clientesDetalle";    	
    }
    

}