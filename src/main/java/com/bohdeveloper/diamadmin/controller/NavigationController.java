package com.bohdeveloper.diamadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bohdeveloper.diamadmin.model.Usuarios;

@Controller
public class NavigationController {
	
    @GetMapping({"/", "/welcome"})
    public String getIndex(Model model) {
        return "login";
    }
    
    @GetMapping("/login")
    public String login() {
      return "login";
    }

    @GetMapping("/app")
    public String getApp(Model model) {
    	model.addAttribute("usuarios", new Usuarios());
        return "app/home";
    }
    
    @GetMapping("/error")
    public String getError(Model model) {
        return "error";
    }

}