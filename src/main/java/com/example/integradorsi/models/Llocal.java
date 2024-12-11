package com.example.integradorsi.models;

public class Llocal {

    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public Llocal() {
        this.id = 0;
        this.nombre = null;
        this.descripcion = null;
        this.estado = false;
    }

    public Llocal(int id) {
        this.id = id;
        this.nombre = null;
        this.descripcion = null;
        this.estado = false;
    }

    public Llocal(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.descripcion = null;
        this.estado = true;
    }

    public Llocal(String nombre, String descripcion) {
        this.id = 0;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = true;
    }

    public Llocal(int id, String nombre, String descripcion, boolean estado) {
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

    @Override
    public String toString() {
        return "Llocal{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

}
