package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.DetalleVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAODetalleVenta implements IDAO<DetalleVentas> {

    private Connection con;
    private Statement st;
    private DAOProductos daoP;
    private DAOTipoComprobante daoTC;
    private DAOLogin daoU;
    private DAOVentas daoV;
    private final Logger logger = LoggerFactory.getLogger(DAODetalleVenta.class);

    public DAODetalleVenta() {
        this.con = Conexion.getConexion();
        this.daoP = new DAOProductos();
        this.daoTC = new DAOTipoComprobante(this.con);
        this.daoU = new DAOLogin(this.con);
        this.daoV = new DAOVentas();
    }

    @Override
    public List<DetalleVentas> getAll() {
        List<DetalleVentas> datos = new ArrayList<>();

        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM detalleVenta");
            while (res.next()) {
                DetalleVentas dv = new DetalleVentas();
                dv.setVenta(daoV.getById(res.getInt("venta_id")));
                dv.setProducto(daoP.getById(res.getInt("producto_id")));
                dv.setTipo_venta(daoTC.getById(res.getInt("tipoVenta_id")));
                dv.setCantidad(res.getInt("cantidad"));
                dv.setSub_total(res.getDouble("sub_total"));
                dv.setDescuento(res.getDouble("descuento"));
                dv.setIgv(res.getDouble("igv"));
                dv.setTotal_pagar(res.getDouble("total_pagar"));
                dv.setRegistro_usuario(daoU.getById(res.getInt("registro_usuario")));
                dv.setEstado(res.getBoolean("estado"));
                datos.add(dv);
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los detalles de ventas, {}",
                    e.getMessage());
        }
        return datos;
    }

    public List<DetalleVentas> getAllById(int id) {
        List<DetalleVentas> datos = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM detalleVenta where venta_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                DetalleVentas dv = new DetalleVentas();
                dv.setVenta(daoV.getById(res.getInt("venta_id")));
                dv.setProducto(daoP.getById(res.getInt("producto_id")));
                dv.setTipo_venta(daoTC.getById(res.getInt("tipoVenta_id")));
                dv.setCantidad(res.getInt("cantidad"));
                dv.setSub_total(res.getDouble("sub_total"));
                dv.setDescuento(res.getDouble("descuento"));
                dv.setIgv(res.getDouble("igv"));
                dv.setTotal_pagar(res.getDouble("total_pagar"));
                dv.setRegistro_usuario(daoU.getById(res.getInt("registro_usuario")));
                dv.setEstado(res.getBoolean("estado"));
                datos.add(dv);
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id de detalle venta, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public void add(DetalleVentas item) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO detalleVenta "
                    + "(venta_id, producto_id, tipoVenta_id, cantidad, sub_total, descuento, igv, total_pagar, registro_usuario) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, item.getVenta().getId());
            pst.setInt(2, item.getProducto().getId());
            pst.setInt(3, item.getTipo_venta().getId());
            pst.setInt(4, item.getCantidad());
            pst.setDouble(5, item.getSub_total());
            pst.setDouble(6, item.getDescuento());
            pst.setDouble(7, item.getIgv());
            pst.setDouble(8, item.getTotal_pagar());
            pst.setInt(9, item.getRegistro_usuario().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al registrar detalle ventas, {}", e.getMessage());
        }
    }

    @Override
    public void update(DetalleVentas item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleVentas delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleVentas getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
