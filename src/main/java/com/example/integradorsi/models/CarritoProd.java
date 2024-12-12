package com.example.integradorsi.models;

public class CarritoProd {

    private Productos producto;
    private TipoComprobante comprobante;
    private int cantidad;
    private double precio;

    public CarritoProd() {
    }

    public CarritoProd(Productos producto, TipoComprobante venta, int cantidad, double precio) {
        this.producto = producto;
        this.comprobante = venta;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public TipoComprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(TipoComprobante venta) {
        this.comprobante = venta;
    }

}
