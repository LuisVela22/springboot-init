package com.example.spring_JWT.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin() {
        return "hello, you have accedded as a Admin";
    }
    
    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER')")
    public String accesUser(){
        return "hello, you have accedded as a User";
    }

    @GetMapping("/accessInvited")
    @PreAuthorize("hasRole('INVITED')")
    public String accessInvited() {
        return "hello, you have accedded as a Invited";
    }

}
