package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.TipoComprobante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoComprobante {
    
    private Connection con;
    private Statement st;
    
    public DAOTipoComprobante() {
        this.con = Conexion.getConexion();
    }
    
    public List<TipoComprobante> getAll() throws SQLException {
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
        } catch(SQLException e) {
            System.out.println(e);
            System.out.println("Error en la consulta de obtener los tipos de comprobantes");
        }
        return datos;
    }
}
