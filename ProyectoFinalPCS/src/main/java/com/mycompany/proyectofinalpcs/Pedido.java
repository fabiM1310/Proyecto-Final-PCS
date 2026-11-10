package com.mycompany.proyectofinalpcs;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String idPedido;
    private String idUsuario;
    private String estado;
    private double total;
    private List<DetallePedido> detalles;

    public Pedido(String idPedido, String idUsuario) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.estado = "Pendiente";
        this.total = 0.0;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        this.total += detalle.getSubtotal();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public String getIdPedido() {
        return idPedido;
    }
}