package com.spring.app1.springboot_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/variable")
public class PathVariableController {

    @Value("${config.codigo}")
    private int codigo;
    @Value("${config.usuario}")
    private String usuario;


    @GetMapping("/page1/{message}")
    public ParamDTO page1(@PathVariable String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setInformacion(message);
        return paramDTO;
    }

    @GetMapping("/page2")
    public Map<String, Object> page2() {
        Map<String, Object> json = new HashMap<>();
        json.put("usuario", usuario);
        json.put("codigo", codigo);
        return json;
    }

}
