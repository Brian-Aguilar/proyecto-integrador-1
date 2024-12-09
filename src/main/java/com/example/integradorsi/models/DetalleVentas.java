package com.example.integradorsi.models;

public class DetalleVentas {
    private Ventas venta;
    private Productos producto;
    private TipoVentas tipo_venta;
    private int cantidad;
    private double sub_total;
    private double descuento;
    private double igv;
    private double total_pagar;
    private Login registro_usuario;
    private boolean estado;

    public DetalleVentas() {
    }

    public DetalleVentas(Ventas venta, Productos producto, TipoVentas tipo_venta, int cantidad, double sub_total, double descuento, double igv, double total_pagar, Login registro_usuario, boolean estado) {
        this.venta = venta;
        this.producto = producto;
        this.tipo_venta = tipo_venta;
        this.cantidad = cantidad;
        this.sub_total = sub_total;
        this.descuento = descuento;
        this.igv = igv;
        this.total_pagar = total_pagar;
        this.registro_usuario = registro_usuario;
        this.estado = estado;
    }
    
    

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public TipoVentas getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(TipoVentas tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

    public Login getRegistro_usuario() {
        return registro_usuario;
    }

    public void setRegistro_usuario(Login registro_usuario) {
        this.registro_usuario = registro_usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
