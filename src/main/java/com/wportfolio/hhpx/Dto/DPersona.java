package com.wportfolio.hhpx.Dto;

public class DPersona {
    private String nombre;
    private String apellido;
    private String descripcion;
    private String imagen;
    
    //CONSTRUCTOR
    public DPersona() {
    }

    public DPersona(
            String nombre, 
            String apellido, 
            String descripcion, 
            String imagen
    ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    //GETTERS & SETTES
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
