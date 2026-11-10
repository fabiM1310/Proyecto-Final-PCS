package com.mycompany.proyectofinalpcs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JButton btnRegistrar;
    private List<Usuario> usuariosRegistrados;

    public VentanaLogin() {
        usuariosRegistrados = new ArrayList<>();
        usuariosRegistrados.add(new Usuario("1", "Ana García", "anagarcia", "1234", "Cajero"));

        setTitle("FideBurguesas - Inicio de Sesión");
        setSize(340, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(110, 30, 160, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 70, 80, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(110, 70, 160, 25);
        add(txtContrasena);

        btnIngresar = new JButton("Iniciar Sesión");
        btnIngresar.setBounds(30, 120, 125, 30);
        add(btnIngresar);

        btnRegistrar = new JButton("Registrar Usuario");
        btnRegistrar.setBounds(160, 120, 140, 30);
        add(btnRegistrar);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = txtUsuario.getText();
                    String pass = new String(txtContrasena.getPassword());

                    if (user.isEmpty() || pass.isEmpty()) {
                        throw new FideBurguesasExcepcion("Debe llenar todos los campos.");
                    }

                    Usuario encontrado = null;
                    for (Usuario u : usuariosRegistrados) {
                        if (u.validarCredenciales(user, pass)) {
                            encontrado = u;
                            break;
                        }
                    }

                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, "¡Bienvenido(a) " + encontrado.getNombre() + "!");
                        dispose();
                        new VentanaMenuPrincipal(encontrado).setVisible(true);
                    } else {
                        throw new FideBurguesasExcepcion("Credenciales incorrectas.");
                    }
                } catch (FideBurguesasExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistro();
            }
        });
    }

    private void abrirVentanaRegistro() {
        JTextField txtNombre = new JTextField();
        JTextField txtNuevoUser = new JTextField();
        JPasswordField txtNuevaPass = new JPasswordField();
        String[] roles = {"Cajero", "Administrador", "Cocina"};
        JComboBox<String> comboRol = new JComboBox<>(roles);

        Object[] formulario = {
            "Nombre Completo:", txtNombre,
            "Nombre de Usuario:", txtNuevoUser,
            "Contraseña:", txtNuevaPass,
            "Rol:", comboRol
        };

        int opcion = JOptionPane.showConfirmDialog(this, formulario, "Registro de Nuevo Usuario", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText().trim();
            String user = txtNuevoUser.getText().trim();
            String pass = new String(txtNuevaPass.getPassword()).trim();
            String rol = (String) comboRol.getSelectedItem();

            if (nombre.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String idGenerado = String.valueOf(usuariosRegistrados.size() + 1);
            usuariosRegistrados.add(new Usuario(idGenerado, nombre, user, pass, rol));
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente. Ya puede iniciar sesión.");
        }
    }
}