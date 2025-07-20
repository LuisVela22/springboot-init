package com.spring_security.app_security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/secure")
public class DemoController {

    @GetMapping("/public")
    public String publico() {
        return "this endpoint is public";
    }

    @GetMapping("/user")
    public String soloUsuario() {
        return new String("this endpoint is only for USERS");
    }

    @GetMapping("/admin")
    public String soloAdmin() {
        return new String("this endpoint is only for ADMINS");
    }

    @GetMapping("/private")
    public String privado() {
        return new String("This endpoint is for anyone who is authenticated");
    }

}
