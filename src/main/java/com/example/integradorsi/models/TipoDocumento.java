package com.example.integradorsi.models;

public class TipoDocumento {

    private int id;
    private String nombre;
    private boolean estado;

    public TipoDocumento() {
        this.id = 0;
        this.nombre = "";
        this.estado = false;
    }

    public TipoDocumento(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.estado = true;
    }

    public TipoDocumento(int id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
