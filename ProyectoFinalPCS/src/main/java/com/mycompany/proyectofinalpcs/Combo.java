package com.mycompany.proyectofinalpcs;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ElementoMenu {
    private List<Producto> productos;

    public Combo(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String getDescripcionDetallada() {
        StringBuilder sb = new StringBuilder("Combo: " + nombre + " - ₡" + precio + "\nIncluye:\n");
        for (Producto p : productos) {
            sb.append(" - ").append(p.getNombre()).append("\n");
        }
        return sb.toString();
    }
}
