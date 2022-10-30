package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 100, message = "Máximo 100 caracteres")
    private String carrera;
    @NotNull
    @Size(min = 1, max = 100, message = "Máximo 100 caracteres")
    private String mencion;
    private String estado;
    private String instituto;
    private String lugar;
   
    //CONSTRUCTOR
    public Estudios() {
    }

    public Estudios(
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String estcarrera) {
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
