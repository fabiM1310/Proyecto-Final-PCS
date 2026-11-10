
package com.mycompany.proyectofinalpcs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaCocina extends JFrame {
    private JList<String> listaPedidosUI;
    private DefaultListModel<String> modeloLista;
    private JButton btnMarcarListo;

    public VentanaCocina() {
        setTitle("FideBurguesas - Monitor de Cocina");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Pedidos Pendientes en Cocina");
        lblTitulo.setBounds(20, 20, 300, 25);
        add(lblTitulo);

        modeloLista = new DefaultListModel<>();
        listaPedidosUI = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaPedidosUI);
        scroll.setBounds(20, 50, 390, 200);
        add(scroll);

        btnMarcarListo = new JButton("Marcar como Listo");
        btnMarcarListo.setBounds(250, 270, 160, 30);
        add(btnMarcarListo);

        cargarPedidosPendientes();

        btnMarcarListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaPedidosUI.getSelectedIndex();
                if (index != -1) {
                    List<Pedido> pedidos = VentanaPuntoVenta.getListaPedidosGlobal();
                    // Buscar pedido pendiente
                    int contador = 0;
                    for (Pedido p : pedidos) {
                        if (p.getEstado().equals("Pendiente")) {
                            if (contador == index) {
                                p.setEstado("Listo");
                                break;
                            }
                            contador++;
                        }
                    }
                    cargarPedidosPendientes();
                    JOptionPane.showMessageDialog(null, "Pedido marcado como Listo.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un pedido de la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void cargarPedidosPendientes() {
        modeloLista.clear();
        List<Pedido> pedidos = VentanaPuntoVenta.getListaPedidosGlobal();
        for (Pedido p : pedidos) {
            if (p.getEstado().equals("Pendiente")) {
                modeloLista.addElement("Pedido: " + p.getIdPedido() + " - Total: ₡" + p.getTotal() + " [" + p.getEstado() + "]");
            }
        }
    }
}