package com.mycompany.proyectofinalpcs;

import java.time.LocalDateTime;

public class Factura {
    private String numeroFactura;
    private String idPedido;
    private LocalDateTime fechaHora;
    private double montoTotal;

    public Factura(String numeroFactura, String idPedido, double montoTotal) {
        this.numeroFactura = numeroFactura;
        this.idPedido = idPedido;
        this.fechaHora = LocalDateTime.now();
        this.montoTotal = montoTotal;
    }

    public String generarComprobante() {
        return "FACTURA N°: " + numeroFactura + "\nPedido: " + idPedido + "\nFecha: " + fechaHora + "\nTotal: ₡" + montoTotal;
    }
}