package com.example.integradorsi.models;

public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private Marca marca;
    private boolean estado;

    public Productos() {
        this.id = 0;
        this.categoria = null;
        this.marca = null;
        this.estado = true;
    }
    
    public Productos(int id) {
        this.id = id;
        this.categoria = null;
        this.marca = null;
        this.estado = true;
    }

    public Productos(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = null;
        this.marca = null;
        this.estado = true;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
