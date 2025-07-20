package com.spring.app1.springboot_app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

// import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod; // Removed incorrect import
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api") // Define a base path for all endpoints in this controller
public class RequestMappingg {
    @RequestMapping(path = "/detalles_info3", method = RequestMethod.GET)

    // @GetMapping("/detalles_info3")
    public Map<String, Object> detallesInfo2222() {
        Map<String, Object> response = new HashMap<>();
        response.put("titulo", "jajajaxd");
        response.put("descripcion", "Esta es una página de ejemplo que jajaja xd es de la información.");
        response.put("IP", "<dirección IP>");
        return response;
    }

}
