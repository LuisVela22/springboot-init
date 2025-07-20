package com.inyecciondependencias.app1.spring_boot_id.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inyecciondependencias.app1.spring_boot_id.models.Productos;
import com.inyecciondependencias.app1.spring_boot_id.services.ProductoServicios;
// import com.inyecciondependencias.app1.spring_boot_id.services.Productos_Services_Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    // private Productos_Services_Imp servicio; /*= new Productos_Services_Imp();*/
    private ProductoServicios servicio;

    @GetMapping("path")
    public List<Productos> ListaProductos(){
        // Productos_Services servicio = new Productos_Services();
        return servicio.findAll();
    }

    @GetMapping("/{idProducto}")
    public Productos mostrar(@PathVariable Long idProducto){
        // Productos_Services servicio = new Productos_Services();
        return servicio.getProductoPorId(idProducto);
    }
    
}
