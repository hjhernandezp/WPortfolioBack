package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 100, message = "Máximo 100 caracteres")
    private String nombre;
    @NotNull
    private String descripcion;
    private String enlace;
    private String imagen;
    
    //CONSTRUCTOR
    public Proyectos() {
    }

    public Proyectos(
            String nombre, 
            String descripcion, 
            String enlace,
            String imagen
    ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.imagen = imagen;
    }
    
    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEnlace() { 
        return enlace;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
