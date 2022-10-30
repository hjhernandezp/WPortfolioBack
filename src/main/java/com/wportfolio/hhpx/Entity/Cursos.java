package com.wportfolio.hhpx.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 100, message = "Máximo 100 caracteres")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 100, message = "Máximo 100 caracteres")
    private String instituto;
    private String lugar;
    private int horas;
    
    //CONSTRUCTOR
    public Cursos() {
    }

    public Cursos(
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

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
