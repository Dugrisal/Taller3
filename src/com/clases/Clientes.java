package com.clases;

import java.util.List;

public class Clientes extends Personas{
    private String nombre;
    private String telefono;
    private String direccion;
    private List<Producto> productos;

    public Clientes(String nombre, String telefono, String direccion, String tipodocumento,String cedula, String celular){

        super( tipodocumento,cedula, celular);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        //this.productos = productos;

    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
