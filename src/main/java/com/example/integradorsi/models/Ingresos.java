package com.example.integradorsi.models;

import java.util.Date;

public class Ingresos {

    private int id;
    private TipoComprobante comprobante;
    private Date fecha;
    private int numero_comprobante;
    private Llocal local;
    private int importe;
    private Login registro_usuario;
    private Date registro_fecha;
    private Login modificar_usuario;
    private Date modificar_fecha;
    private Login eliminar_usuario;
    private Date eliminar_fecha;
    private boolean estado;

    public Ingresos() {
        this.id = 0;
        this.comprobante = new TipoComprobante();
        this.registro_usuario = new Login();
        this.registro_fecha = new Date();
        this.modificar_usuario = null;
        this.modificar_fecha = null;
        this.eliminar_usuario = null;
        this.eliminar_fecha = null;
        this.estado = false;
    }
    public Ingresos(int id) {
        this.id = id;
    }

    public Ingresos(TipoComprobante comprobante, Date fecha, int numero_comprobante, Llocal local, int importe, Login registro_usuario, Date registro_fecha) {
        this.comprobante = comprobante;
        this.fecha = fecha;
        this.numero_comprobante = numero_comprobante;
        this.local = local;
        this.importe = importe;
        this.registro_usuario = registro_usuario;
        this.registro_fecha = registro_fecha;
        this.estado = true;
    }

    public Ingresos(int id, TipoComprobante comprobante, Date fecha, int numero_comprobante, Llocal local, int importe, Login registro_usuario, Date registro_fecha, Login modificar_usuario, Date modificar_fecha, Login eliminar_usuario, Date eliminar_fecha, boolean estado) {
        this.id = id;
        this.comprobante = comprobante;
        this.fecha = fecha;
        this.numero_comprobante = numero_comprobante;
        this.local = local;
        this.importe = importe;
        this.registro_usuario = registro_usuario;
        this.registro_fecha = registro_fecha;
        this.modificar_usuario = modificar_usuario;
        this.modificar_fecha = modificar_fecha;
        this.eliminar_usuario = eliminar_usuario;
        this.eliminar_fecha = eliminar_fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoComprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(TipoComprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero_comprobante() {
        return numero_comprobante;
    }

    public void setNumero_comprobante(int numero_comprobante) {
        this.numero_comprobante = numero_comprobante;
    }

    public Llocal getLocal() {
        return local;
    }

    public void setLocal(Llocal local) {
        this.local = local;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Login getRegistro_usuario() {
        return registro_usuario;
    }

    public void setRegistro_usuario(Login registro_usuario) {
        this.registro_usuario = registro_usuario;
    }

    public Date getRegistro_fecha() {
        return registro_fecha;
    }

    public void setRegistro_fecha(Date registro_fecha) {
        this.registro_fecha = registro_fecha;
    }

    public Login getModificar_usuario() {
        return modificar_usuario;
    }

    public void setModificar_usuario(Login modificar_usuario) {
        this.modificar_usuario = modificar_usuario;
    }

    public Date getModificar_fecha() {
        return modificar_fecha;
    }

    public void setModificar_fecha(Date modificar_fecha) {
        this.modificar_fecha = modificar_fecha;
    }

    public Login getEliminar_usuario() {
        return eliminar_usuario;
    }

    public void setEliminar_usuario(Login eliminar_usuario) {
        this.eliminar_usuario = eliminar_usuario;
    }

    public Date getEliminar_fecha() {
        return eliminar_fecha;
    }

    public void setEliminar_fecha(Date eliminar_fecha) {
        this.eliminar_fecha = eliminar_fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
