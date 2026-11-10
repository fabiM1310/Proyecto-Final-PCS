package com.mycompany.proyectofinalpcs;

import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {
    private Usuario usuarioActual;

    public VentanaMenuPrincipal(Usuario usuario) {
        this.usuarioActual = usuario;

        setTitle("FideBurguesas - Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lblBienvenida = new JLabel("Bienvenido(a), " + usuarioActual.getNombre() + " (" + usuarioActual.getRol() + ")", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblBienvenida);

        JButton btnTomarPedido = new JButton("1. Punto de Venta / Tomar Pedido");
        JButton btnCocina = new JButton("2. Monitor de Cocina");
        JButton btnCerrarSesion = new JButton("3. Cerrar Sesión");

        add(btnTomarPedido);
        add(btnCocina);
        add(btnCerrarSesion);

        btnTomarPedido.addActionListener(e -> 
            new VentanaPuntoVenta(usuarioActual).setVisible(true)
        );

        btnCocina.addActionListener(e -> 
            new VentanaCocina().setVisible(true)
        );

        btnCerrarSesion.addActionListener(e -> {
            dispose();
            new VentanaLogin().setVisible(true);
        });
    }
}