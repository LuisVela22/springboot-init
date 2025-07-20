package com.inyecciondependencias.app1.spring_boot_id.repositorios;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.inyecciondependencias.app1.spring_boot_id.models.Productos;


@Repository
public class Repo_Productos_Imp implements ProductoRepositorio {
    List<Productos> datos;
    
    //Constructor
    public Repo_Productos_Imp() {
        this.datos = Arrays.asList(
            new Productos(1L, "Producto 1", 10.0),
            new Productos(2L, "Producto 2", 20.0),
            new Productos(3L, "Producto 3", 30.0),
            new Productos(4L, "Producto 4", 40.0)
        );
    }

    @Override
    public List<Productos> getDatos() {
        return datos;
    }


    @Override
    public Productos getProductoPorId(Long id) {
        return datos.stream()
            .filter(p -> p.getIdProducto()
            .equals(id))
            .findFirst()
            .orElse(null);
    }
 
}
