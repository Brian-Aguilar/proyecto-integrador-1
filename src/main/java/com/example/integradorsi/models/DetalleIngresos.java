package com.example.integradorsi.models;

public class DetalleIngresos {

    private int id;
    private Ingresos ingreso;
    private Productos producto;
    private int cantidad;
    private double precio;

    public DetalleIngresos() {
        this.id = 0;
        this.ingreso = new Ingresos();
        this.producto = new Productos();
        this.cantidad = 0;
        this.precio = 0.0;
    }
    
    public DetalleIngresos(Ingresos ingreso, Productos producto, int cantidad, double precio) {
        this.id = 0;
        this.ingreso = ingreso;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public DetalleIngresos(int id, Ingresos ingreso, Productos producto, int cantidad, double precio) {
        this.id = id;
        this.ingreso = ingreso;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingresos getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingresos ingreso) {
        this.ingreso = ingreso;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
