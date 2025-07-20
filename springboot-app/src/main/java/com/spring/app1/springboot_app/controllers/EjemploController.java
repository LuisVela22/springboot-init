package com.spring.app1.springboot_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;


@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info(Model model){
        model.addAttribute("titulo", "Detalles de la Información");
        model.addAttribute("descripcion", "Esta es una página de ejemplo que muestra detalles de la información.");
        model.addAttribute("IP", "<dirección IP>");
        return "detalles_info";
    }

}
