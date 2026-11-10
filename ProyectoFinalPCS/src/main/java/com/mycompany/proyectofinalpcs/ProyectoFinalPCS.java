package com.mycompany.proyectofinalpcs;

public class ProyectoFinalPCS {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }
}
