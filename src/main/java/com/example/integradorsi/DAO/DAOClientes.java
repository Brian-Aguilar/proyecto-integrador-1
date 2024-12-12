package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Clientes;
import com.example.integradorsi.models.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOClientes implements IDAO<Clientes> {

    private Connection con;
    private Statement st;
    private final Logger logger = LoggerFactory.getLogger(DAOClientes.class);

    public DAOClientes() {
        this.con = Conexion.getConexion();
    }

    @Override
    public List<Clientes> getAll() {
        List<Clientes> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM cliente where estado=1");
            while (res.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNombre(res.getString("nombre_completo"));
                cliente.setApellidoP(res.getString("apellido_paterno"));
                cliente.setApellidoM(res.getString("apellido_materno"));
                cliente.setTelefono(res.getInt("telefono"));
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setId(res.getInt("documento_id"));
                cliente.setTipoDocumento(tipoDocumento);
                cliente.setDocumento(res.getInt("documento_informacion"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setEstado(res.getBoolean("estado"));
                datos.add(cliente);
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los clientes, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public Clientes getById(int id) {
        Clientes cliente = new Clientes();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM cliente where cliente_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if(res != null) {
                res.next();
                cliente.setId(res.getInt("cliente_id"));
                cliente.setNombre(res.getString("nombre_completo"));
                cliente.setApellidoP(res.getString("apellido_paterno"));
                cliente.setApellidoM(res.getString("apellido_materno"));
                cliente.setTelefono(res.getInt("telefono"));
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setId(res.getInt("documento_id"));
                cliente.setTipoDocumento(tipoDocumento);
                cliente.setDocumento(res.getInt("documento_informacion"));
                cliente.setCorreo(res.getString("correo"));
                cliente.setEstado(res.getBoolean("estado"));
            }
        }catch (SQLException e) {
            logger.info("Error en la consulta de obtener el cliente con id, {}",
                    e.getMessage());
        }
        return cliente;
    }

    @Override
    public void add(Clientes item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Clientes item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clientes delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
