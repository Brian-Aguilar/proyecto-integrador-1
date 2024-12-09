package com.example.integradorsi.models;

import java.util.Date;

public class Ventas {
    private int id;
    private Clientes cliente;
    private Llocal local;
    private Date fecha_venta;

    public Ventas() {
        this.id = 0;
        this.cliente = new Clientes();
        this.local = new Llocal();
        this.fecha_venta = null;
    }

    public Ventas(int id, Clientes cliente, Llocal local, Date fecha_venta) {
        this.id = id;
        this.cliente = cliente;
        this.local = local;
        this.fecha_venta = fecha_venta;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Llocal getLocal() {
        return local;
    }

    public void setLocal(Llocal local) {
        this.local = local;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    
}
