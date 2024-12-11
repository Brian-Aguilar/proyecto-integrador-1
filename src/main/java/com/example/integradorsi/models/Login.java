package com.example.integradorsi.models;

import com.example.integradorsi.utils.PasswordMe;

public class Login {

    private int id;
    private String usuario;
    private String nombre_completo;
    private String password;
    private boolean is_admin;
    private boolean is_vendedor;
    private boolean estado;

    public Login() {
        this.id = 0;
        this.nombre_completo = "Error";
        this.is_admin = false;
        this.is_vendedor = true;
    }
    public Login(int id) {
        this.id = id;
        this.nombre_completo = null;
        this.is_admin = false;
        this.is_vendedor = false;
    }

    public Login(String usuario, String password) {
        this.id = 0;
        this.usuario = usuario;
        setPasswordHash(password);
        this.nombre_completo = "";
        this.is_admin = false;
        this.is_vendedor = false;
        this.estado = true;
    }

    public Login(String usuario, String nombre_completo, String password) {
        this.id = 0;
        this.usuario = usuario;
        this.nombre_completo = nombre_completo;
        setPasswordHash(password);
        this.is_admin = false;
        this.is_vendedor = true;
        this.estado = true;
    }

    public Login(int id, String usuario, String nombre_completo, boolean is_vendedor, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.nombre_completo = nombre_completo;
        this.is_admin = false;
        this.is_vendedor = is_vendedor;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordHash(String password) {
        PasswordMe hash = new PasswordMe(password);
        this.password = hash.convertir();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isIs_vendedor() {
        return is_vendedor;
    }

    public void setIs_vendedor(boolean is_vendedor) {
        this.is_vendedor = is_vendedor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
