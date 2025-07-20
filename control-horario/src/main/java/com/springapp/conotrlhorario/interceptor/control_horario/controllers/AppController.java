package com.springapp.conotrlhorario.interceptor.control_horario.controllers;

import java.util.Date;
// import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AppController {

    @GetMapping("/indice")    
    public ResponseEntity<?> Indice(HttpServletRequest request){
        Map<String, Object> datos = new HashMap<>(); 
        datos.put("titulo", "Sistema de control de accesi");
        datos.put("hora", new Date());
        datos.put("mensaje", request.getAttribute("mensaje"));
        return ResponseEntity.ok(datos);
    }
}
