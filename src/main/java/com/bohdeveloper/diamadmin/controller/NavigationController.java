package com.bohdeveloper.diamadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bohdeveloper.diamadmin.model.Usuarios;

@Controller
public class NavigationController {
	
    @GetMapping({"/", "/welcome"})
    public String getIndex(HttpServletRequest request) {
        return "index";
    }
    
    @GetMapping("/login")
    public String getLogin(HttpServletRequest request) {
        return "login";
    }
    
    @GetMapping("/signin")
    public String getSignin(HttpServletRequest request) {
        return "signin";
    }
    
    @GetMapping("/app")
    public String getApp(HttpServletRequest request) {
        Usuarios usuario = new Usuarios();
//        Iterable<Usuarios> usuarios = daoUsuarios.obtenerTodos();

        request.setAttribute("usuario", usuario);
//        request.setAttribute("usuarios", usuarios);
        return "app/home";
    }
    
    @GetMapping("/error")
    public String getError(HttpServletRequest request) {
        return "error";
    }

}