package com.mycompany.proyectofinalpcs;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String username;
    private String contrasena;
    private String rol;

    public Usuario(String idUsuario, String nombre, String username, String contrasena, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.username = username;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public boolean validarCredenciales(String user, String pass) {
        return this.username.equals(user) && this.contrasena.equals(pass);
    }

    public String getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }
}