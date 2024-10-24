package com.example.integradorsi.models;

public class TipoComprobante {
    private int id;
    private String nombre;
    private boolean estado;
    
    public TipoComprobante() {
    }
    
    public TipoComprobante(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.estado = true;
    }
    
    public TipoComprobante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = true;
    }
    
    public TipoComprobante(int id, String nombre, boolean estado) {
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
