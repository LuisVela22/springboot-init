package com.interceptores.interceptores_id.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping
public class Saludo {

    @GetMapping("/saludo")
    public String saludo() throws InterruptedException {
        Thread.sleep(7000);
        return "Saludos a toda la people";
    }
    
}
