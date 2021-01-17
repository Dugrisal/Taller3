package com.clases;

public class Personas {

    private String tipoDocumento;
    private String cedula;
    private String celular;

    public Personas(String tipoDocumento, String cedula, String celular) {
        this.tipoDocumento =tipoDocumento;
        this.cedula = cedula;
        this.celular = celular;
    }

    public String gettipoDocumento() {
        return tipoDocumento;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
