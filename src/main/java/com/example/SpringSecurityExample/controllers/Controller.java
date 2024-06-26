package com.example.SpringSecurityExample.controllers;

import com.example.SpringSecurityExample.config.MyUserPrincipal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {

    @GetMapping("/admin")
    public String getAdmin(Authentication authentication){
        MyUserPrincipal myUserPrincipal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication();

        return "ADMIN";
    }
    @Secured("ADMIN")
    @GetMapping("/client")
    public String getClient(){
        return "CLIENT";
    }

    @GetMapping("/any")
    public String getAny(){
        return "any";
    }
}
