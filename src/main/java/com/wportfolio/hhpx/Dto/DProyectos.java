package com.wportfolio.hhpx.Dto;

public class DProyectos {
    private String nombre;
    private String descripcion;
    private String enlace;
    private String imagen;
    
    //CONSTRUCTOR
    public DProyectos() {
    }

    public DProyectos(
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
