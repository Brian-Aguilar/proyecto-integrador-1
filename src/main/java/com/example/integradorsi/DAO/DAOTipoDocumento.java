package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.TipoDocumento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOTipoDocumento implements IDAO<TipoDocumento> {

    private Connection con;
    private Statement st;
    private final Logger logger = LoggerFactory.getLogger(DAOTipoDocumento.class);

    public DAOTipoDocumento() {
        this.con = Conexion.getConexion();
    }

    @Override
    public List<TipoDocumento> getAll() {
        List<TipoDocumento> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM tipoDocumento where estado=1");
            while(res.next()) {
                datos.add(new TipoDocumento(
                        res.getInt("documento_id"),
                        res.getString("nombre"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los tipos de documentos, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public TipoDocumento getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(TipoDocumento item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TipoDocumento item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoDocumento delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
