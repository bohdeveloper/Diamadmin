package com.bohdeveloper.diamadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bohdeveloper.diamadmin.model.Usuarios;

@Controller
public class NavigationController {
	
    @GetMapping({"/", "/welcome"})
    public String getIndex(Model model) {
    	model.addAttribute("rutaLogo", "");
        return "index";
    }
    
    @GetMapping("/login")
    public String getLogin(Model model) {
    	model.addAttribute("rutaLogo", "");
        return "login";
    }
    
    @GetMapping("/signin")
    public String getSignin(Model model) {
    	model.addAttribute("rutaLogo", "");
        return "signin";
    }
    
    @GetMapping("/app")
    public String getApp(Model model) {
    	model.addAttribute("rutaLogo", "");
    	model.addAttribute("usuarios", new Usuarios());
        return "app/home";
    }
    
    @GetMapping("/error")
    public String getError(Model model) {
    	model.addAttribute("rutaLogo", "");
        return "error";
    }

}