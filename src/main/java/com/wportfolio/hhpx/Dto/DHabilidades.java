package com.wportfolio.hhpx.Dto;

public class DHabilidades {
    private String nombre;
    private int nivel;
    
    //CONSTRUCTOR
    public DHabilidades() {
    }

    public DHabilidades(
            String nombre, 
            int nivel
    ) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
