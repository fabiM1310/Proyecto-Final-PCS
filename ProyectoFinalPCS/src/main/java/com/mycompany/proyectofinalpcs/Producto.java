package com.mycompany.proyectofinalpcs;

public class Producto extends ElementoMenu {
    private String descripcion;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, String descripcion, String categoria) {
        super(codigo, nombre, precio);
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String getDescripcionDetallada() {
        return "Producto: " + nombre + " - " + descripcion + " (Cat: " + categoria + ") - ₡" + precio;
    }
}
