package com.inyecciondependencias.app1.spring_boot_id.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component
import org.springframework.stereotype.Service;

import com.inyecciondependencias.app1.spring_boot_id.models.Productos;
import com.inyecciondependencias.app1.spring_boot_id.repositorios.ProductoRepositorio;
// import com.inyecciondependencias.app1.spring_boot_id.repositorios.Repo_Productos_Imp;


@Service
public class Productos_Services_Imp implements ProductoServicios{

    @Autowired
    // private Repo_Productos_Imp repoProductos; /* = new Repo_Productos_Imp();*/
    // at this momment, "repoProductos", has all the data created from the
    // repository
    private ProductoRepositorio repoProductos;

    
    @Override
    public List<Productos> findAll() {

        return repoProductos.getDatos()
                .stream()
                .map(p -> {
                    Double precioConIva = p.getPrecio() * 1.21;
                    
                    Productos newProductos = (Productos) p.clone();
                    newProductos.setPrecio(precioConIva);
                    /*
                    Aqui es para inmutannilidad
                    Productos nuevoPrecio = new Productos(p.getIdProducto(), p.getNombre(), precioConIva);*/

                    // p.setPrecio(precioConIva); // esto podrías evitarlo incluso
                    return newProductos;
                })
                .collect(Collectors.toList());

    }

    @Override
    public Productos getProductoPorId(Long id) {
        return repoProductos.getProductoPorId(id);
    }

}
