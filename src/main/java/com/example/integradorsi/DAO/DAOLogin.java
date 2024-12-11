package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOLogin implements IDAO<Login> {

    private Connection con;
    private Statement st;
    private final Logger logger = LoggerFactory.getLogger(DAOLocal.class);

    public DAOLogin(Connection x) {
        if (x != null) {
            this.con = x;
        } else {
            this.con = Conexion.getConexion();
        }
    }

    @Override
    public List<Login> getAll() {
        List<Login> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM usuarios WHERE is_vendedor=true");
            while (res.next()) {
                lista.add(new Login(
                        res.getInt("usuario_id"),
                        res.getString("usuario"),
                        res.getString("nombre_completo"),
                        res.getBoolean("is_vendedor"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los usuarios, {}",
                    e.getMessage());
        }
        return lista;
    }

    @Override
    public Login getById(int id) {
        Login dato = new Login();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE usuario_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                dato = new Login(
                        res.getInt("usuario_id"),
                        res.getString("usuario"),
                        res.getString("nombre_completo"),
                        res.getBoolean("is_vendedor"),
                        res.getBoolean("estado")
                );
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id de usuario, {}",
                    e.getMessage());
        }
        return dato;
    }

    @Override
    public void add(Login item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Login item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Login delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Login getByAuth(Login u) {
        Login usuario = new Login();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND password = ?");
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getPassword());
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                usuario.setId(res.getInt("usuario_id"));
                usuario.setUsuario(res.getString("usuario"));
                usuario.setNombre_completo(res.getString("nombre_completo"));
                usuario.setIs_admin(res.getBoolean("is_admin"));
                usuario.setIs_vendedor(res.getBoolean("is_vendedor"));
                usuario.setEstado(res.getBoolean("estado"));
            }
        } catch (SQLException e) {
            logger.info("Error al iniciar sesion, {}",
                    e.getMessage());
        }
        return usuario;
    }
}
