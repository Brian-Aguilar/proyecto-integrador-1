package com.example.integradorsi.models;

public class Marca {

    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public Marca() {
    }

    public Marca(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.descripcion = "";
        this.estado = true;
    }

    public Marca(int id, String nombre, String descripcion, boolean estado) {
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
