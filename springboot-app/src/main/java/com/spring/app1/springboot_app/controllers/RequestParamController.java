package com.spring.app1.springboot_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app1.springboot_app.models.Empleados;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/detalle")
    public ParamDTO detalle(@RequestParam String informacion) {
        ParamDTO paramDTO1 = new ParamDTO();
        paramDTO1.setInformacion(informacion);
        return paramDTO1;
    }
    
    @PostMapping("/solicitud")
    public Empleados crearEmple(@RequestBody Empleados empleado) {
        // Lógica para crear un nuevo empleado
        return empleado;
    }

}
