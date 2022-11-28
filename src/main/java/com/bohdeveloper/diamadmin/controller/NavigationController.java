package com.bohdeveloper.diamadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
    @GetMapping({"/", "/welcome"})
    public String getIndex(HttpServletRequest request) {
        request.setAttribute("rutaLogo", "");
        return "index";
    }
    
    @GetMapping("/login")
    public String getLogin(HttpServletRequest request) {
        request.setAttribute("rutaLogo", "");
        return "login";
    }
    
    @GetMapping("/signin")
    public String getSignin(HttpServletRequest request) {
        request.setAttribute("rutaLogo", "");
        return "signin";
    }
    
    @GetMapping("/app")
    public String getApp(HttpServletRequest request) {
        request.setAttribute("rutaLogo", "");
        return "app/home";
    }
    
    @GetMapping("/error")
    public String getError(HttpServletRequest request) {
        request.setAttribute("rutaLogo", "");
        return "error";
    }

}