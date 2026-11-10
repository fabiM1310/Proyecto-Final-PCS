package com.mycompany.proyectofinalpcs;

public abstract class ElementoMenu {
    protected String codigo;
    protected String nombre;
    protected double precio;

    public ElementoMenu(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract String getDescripcionDetallada();
}
