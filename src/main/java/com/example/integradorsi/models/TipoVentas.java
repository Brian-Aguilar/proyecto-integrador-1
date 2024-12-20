package com.example.integradorsi.models;

public class TipoVentas {

    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public TipoVentas() {
        this.id = 0;
        this.nombre = null;
        this.descripcion = null;
        this.estado = false;
    }

    public TipoVentas(int id) {
        this.id = id;
        this.nombre = null;
        this.descripcion = null;
        this.estado = false;
    }

    public TipoVentas(int id, String nombre, String descripcion, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
