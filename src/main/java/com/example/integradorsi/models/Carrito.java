package com.example.integradorsi.models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private Llocal local;
    private Clientes cliente;
    private List<CarritoProd> productos;
    private Login usuario;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public Carrito(Llocal local, Clientes cliente, Login usuario) {
        this.local = local;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.usuario = usuario;
    }

    public Llocal getLocal() {
        return local;
    }

    public void setLocal(Llocal local) {
        this.local = local;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public List<CarritoProd> getAll() {
        return this.productos;
    }

    public void add(CarritoProd producto) {
        this.productos.add(producto);
    }

}
