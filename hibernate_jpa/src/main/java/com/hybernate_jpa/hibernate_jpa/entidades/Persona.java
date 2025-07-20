package com.hybernate_jpa.hibernate_jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre, apellido;
    
    @Column(name = "lenguajes")
    private String lenguaje;

    public Persona(){}
    
    public Persona(Long id, String nombre, String apellido, String lenguaje) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lenguaje = lenguaje;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getLenguaje() {
        return lenguaje;
    }
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", lenguaje=" + lenguaje + "]";
    }

    
    // private Long id;
    // private String nombre, apellido, lenguaje;

    

}
