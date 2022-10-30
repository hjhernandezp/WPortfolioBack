package com.wportfolio.hhpx.Dto;

public class DCursos {
    private String nombre;
    private String instituto;
    private String lugar;
    private int horas;
    
    //CONSTRUCTOR
    public DCursos() {
    }

    public DCursos(
            String nombre,
            String instituto,
            String lugar,
            int horas
    ) {
        this.nombre = nombre;
        this.instituto = instituto;
        this.lugar = lugar;
        this.horas = horas;
    }
    
    //GETTERS & SETTES
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getHoras() {
        return horas;
    }

    public void sethoras(int horas) {
        this.horas = horas;
    }
}
