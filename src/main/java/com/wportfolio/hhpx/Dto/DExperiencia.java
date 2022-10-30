package com.wportfolio.hhpx.Dto;

public class DExperiencia {
    private String empresa;
    private String lugar;
    private String cargo;
    
    //CONSTRUCTOR
    public DExperiencia() {
    }

    public DExperiencia(
            String empresa, 
            String lugar, 
            String cargo
    ) {
        this.empresa = empresa;
        this.lugar = lugar;
        this.cargo = cargo;
    }
    
    //GETTERES & SETTERS
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
