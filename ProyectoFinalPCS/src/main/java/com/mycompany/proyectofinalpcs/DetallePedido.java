package com.mycompany.proyectofinalpcs;

public class DetallePedido {
    private String idDetalle;
    private String codigoItem;
    private int cantidad;
    private double subtotal;

    public DetallePedido(String idDetalle, String codigoItem, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.codigoItem = codigoItem;
        this.cantidad = cantidad;
        this.subtotal = cantidad * precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCodigoItem() {
        return codigoItem;
    }
}
