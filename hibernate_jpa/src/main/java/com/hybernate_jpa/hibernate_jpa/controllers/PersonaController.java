package com.hybernate_jpa.hibernate_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hybernate_jpa.hibernate_jpa.entidades.Persona;
import com.hybernate_jpa.hibernate_jpa.repositorios.Repo_Persona;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private Repo_Persona repositorio;

    @GetMapping("path")
    public List<Persona> Consulta(){
        return (List<Persona>) repositorio.findAll();
    }
    
    

}
