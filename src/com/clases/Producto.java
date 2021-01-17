package com.clases;

public class Producto {
    private String nombre;
    private String carateristicas;
    private String idProducto;
    private String condiciones;

    public Producto(String nombre, String carateristicas, String idProducto, String condiciones) {
        this.nombre = nombre;
        this.carateristicas = carateristicas;
        this.idProducto = idProducto;
        this.condiciones = condiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarateristicas() {
        return carateristicas;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getCondiciones() {
        return condiciones;
    }
}