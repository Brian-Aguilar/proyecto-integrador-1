package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.TipoComprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOTipoComprobante implements IDAO<TipoComprobante> {

    private Connection con;
    private Statement st;
    private final Logger logger = LoggerFactory.getLogger(DAOTipoComprobante.class);

    public DAOTipoComprobante(Connection x) {
        if (x != null) {
            this.con = x;
        } else {
            this.con = Conexion.getConexion();
        }
    }

    @Override
    public List<TipoComprobante> getAll() {
        List<TipoComprobante> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM tipoComprobante");
            while (res.next()) {
                datos.add(new TipoComprobante(
                        res.getInt("comprobante_id"),
                        res.getString("nombre"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los tipos de comprobantes, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public TipoComprobante getById(int id) {
        TipoComprobante comprobante = new TipoComprobante();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM tipoComprobante where comprobante_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                comprobante.setId(res.getInt("comprobante_id"));
                comprobante.setNombre(res.getString("nombre"));
                comprobante.setEstado(res.getBoolean("estado"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id de ingresos, {}",
                    e.getMessage());
        }
        return comprobante;
    }

    @Override
    public void add(TipoComprobante item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TipoComprobante item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoComprobante delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM tipoComprobante where estado=1");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.info("Error al obtener tamaño de tipo de comprobante, {}",
                    e.getMessage());
        }
        return cantidad;
    }
}
