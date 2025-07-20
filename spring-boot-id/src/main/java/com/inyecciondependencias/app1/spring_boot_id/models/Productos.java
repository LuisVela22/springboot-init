package com.inyecciondependencias.app1.spring_boot_id.models;

public class Productos implements Cloneable{
    private Long idProducto;
    private String nombre;
    private Double precio;


    public Productos() {
    }

    public Productos(Long idProducto, String nombre, Double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public Object clone() {
        
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Productos(idProducto, nombre, precio);
        }
    }

    
}
