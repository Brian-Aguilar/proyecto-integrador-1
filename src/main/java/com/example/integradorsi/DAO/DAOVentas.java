package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Clientes;
import com.example.integradorsi.models.Llocal;
import com.example.integradorsi.models.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOVentas implements IDAO<Ventas> {
    
    private Connection con;
    private Statement st;
    private DAOClientes daoC;
    private DAOLocal daoL;
    private final Logger logger = LoggerFactory.getLogger(DAOVentas.class);
    
    public DAOVentas() {
        this.con = Conexion.getConexion();
        this.daoC = new DAOClientes();
        this.daoL = new DAOLocal(this.con);
    }
    
    @Override
    public List<Ventas> getAll() {
        List<Ventas> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM ventas");
            while (res.next()) {
                Clientes cliente = daoC.getById(res.getInt("cliente_id"));
                Llocal local = daoL.getById(res.getInt("local_id"));
                datos.add(new Ventas(res.getInt("venta_id"),
                        cliente,
                        local,
                        res.getDate("fecha_venta")));
            }
        } catch (SQLException e) {
            logger.info("Error al obtener Ventas, {}",
                    e.getMessage());
        }
        return datos;
    }
    
    @Override
    public Ventas getById(int id) {
        Ventas venta = new Ventas();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM ventas where venta_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                Clientes cliente = daoC.getById(res.getInt("cliente_id"));
                Llocal local = daoL.getById(res.getInt("local_id"));
                venta.setId(res.getInt("venta_id"));
                venta.setCliente(cliente);
                venta.setLocal(local);
                venta.setFecha_venta(res.getDate("fecha_venta"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener el id de ventas, {}",
                    e.getMessage());
        }
        return venta;
    }
    
    @Override
    public void add(Ventas item) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO ventas (cliente_id, local_id, fecha_venta) VALUES (?,?,?)");
            pst.setInt(1, item.getCliente().getId());
            pst.setInt(2, item.getLocal().getId());
            pst.setDate(3, new java.sql.Date(item.getFecha_venta().getTime()));
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al registrar una venta, {}", e.getMessage());
        }
    }
    
    @Override
    public void update(Ventas item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Ventas delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM ventas");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.info("Error al obtener el tamaño en la tabla productos, {}",
                    e.getMessage());
        }
        return cantidad;
    }
    
}
