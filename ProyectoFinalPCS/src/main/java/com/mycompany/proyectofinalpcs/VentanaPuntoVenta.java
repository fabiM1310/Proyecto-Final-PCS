package com.mycompany.proyectofinalpcs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaPuntoVenta extends JFrame {
    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTextArea txtOrdenActual;
    private JLabel lblTotal;
    private Pedido pedidoActual;
    private static List<Pedido> listaPedidosGlobal = new ArrayList<>();
    private static int contadorPedidos = 1044;

    public VentanaPuntoVenta(Usuario usuario) {
        setTitle("FideBurguesas - Punto de Venta (Tomar Pedido)");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        pedidoActual = new Pedido("P-" + contadorPedidos++, usuario.getNombre());

        JLabel lblProd = new JLabel("Producto:");
        lblProd.setBounds(20, 20, 80, 25);
        add(lblProd);

        String[] menuItems = {"Clásica Fide - ₡2178", "Doble Queso - ₡2118", "Pollo Crispy - ₡1199", "Papas clásicas - ₡765", "Refresco - ₡800"};
        comboProductos = new JComboBox<>(menuItems);
        comboProductos.setBounds(100, 20, 200, 25);
        add(comboProductos);

        JLabel lblCant = new JLabel("Cantidad:");
        lblCant.setBounds(20, 60, 80, 25);
        add(lblCant);

        txtCantidad = new JTextField("1");
        txtCantidad.setBounds(100, 60, 60, 25);
        add(txtCantidad);

        JButton btnAgregar = new JButton("Agregar a Orden");
        btnAgregar.setBounds(180, 60, 140, 25);
        add(btnAgregar);

        txtOrdenActual = new JTextArea();
        txtOrdenActual.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtOrdenActual);
        scroll.setBounds(20, 105, 390, 200);
        add(scroll);

        lblTotal = new JLabel("Total a Pagar: ₡0.0");
        lblTotal.setBounds(20, 320, 200, 25);
        add(lblTotal);

        JButton btnEnviarCocina = new JButton("Enviar a Cocina");
        btnEnviarCocina.setBounds(240, 360, 170, 30);
        add(btnEnviarCocina);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    if (cantidad <= 0) throw new NumberFormatException();

                    int seleccion = comboProductos.getSelectedIndex();
                    String nombreItem = "";
                    double precioItem = 0.0;

                    switch (seleccion) {
                        case 0: nombreItem = "Clásica Fide"; precioItem = 2178.0; break;
                        case 1: nombreItem = "Doble Queso"; precioItem = 2118.0; break;
                        case 2: nombreItem = "Pollo Crispy"; precioItem = 1199.0; break;
                        case 3: nombreItem = "Papas clásicas"; precioItem = 765.0; break;
                        case 4: nombreItem = "Refresco"; precioItem = 800.0; break;
                    }

                    DetallePedido detalle = new DetallePedido("D-" + System.currentTimeMillis(), nombreItem, cantidad, precioItem);
                    pedidoActual.agregarDetalle(detalle);

                    txtOrdenActual.append(cantidad + "x " + nombreItem + " - Subtotal: ₡" + detalle.getSubtotal() + "\n");
                    lblTotal.setText("Total a Pagar: ₡" + pedidoActual.getTotal());
                    txtCantidad.setText("1");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad numérica válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEnviarCocina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pedidoActual.getTotal() == 0.0) {
                    JOptionPane.showMessageDialog(null, "La orden está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                listaPedidosGlobal.add(pedidoActual);
                JOptionPane.showMessageDialog(null, "¡Pedido enviado a cocina exitosamente!");
                dispose();
            }
        });
    }

    public static List<Pedido> getListaPedidosGlobal() {
        return listaPedidosGlobal;
    }
}
