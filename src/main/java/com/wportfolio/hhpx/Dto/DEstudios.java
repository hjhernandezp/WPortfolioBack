package com.wportfolio.hhpx.Dto;

public class DEstudios {
    private String carrera;
    private String mencion;
    private String estado;
    private String instituto;
    private String lugar;
    
    //CONTRUCTOR
    public DEstudios() {
    }

    public DEstudios(
            String carrera, 
            String mencion, 
            String estado, 
            String instituto, 
            String lugar
    ) {
        this.carrera = carrera;
        this.mencion = mencion;
        this.estado = estado;
        this.instituto = instituto;
        this.lugar = lugar;
    }

    //GETTERS & SETTERS
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
}
