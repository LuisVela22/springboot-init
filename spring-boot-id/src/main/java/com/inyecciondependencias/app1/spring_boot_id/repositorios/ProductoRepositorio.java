package com.inyecciondependencias.app1.spring_boot_id.repositorios;

import com.inyecciondependencias.app1.spring_boot_id.models.Productos;

import java.util.List;

public interface ProductoRepositorio {

    List<Productos> getDatos();

    Productos getProductoPorId(Long id);
    
} 