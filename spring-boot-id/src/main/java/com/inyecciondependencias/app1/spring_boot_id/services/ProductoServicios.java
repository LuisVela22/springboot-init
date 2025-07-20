package com.inyecciondependencias.app1.spring_boot_id.services;

import java.util.List;

import com.inyecciondependencias.app1.spring_boot_id.models.Productos;

public interface ProductoServicios {
    List<Productos> findAll();
    Productos getProductoPorId(Long id);
    
} 