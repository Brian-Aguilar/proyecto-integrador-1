package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Llocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOLocal {

    private Connection con;
    private Statement st;

    public DAOLocal() {
        this.con = Conexion.getConexion();
    }

    public List<Llocal> getAll() throws SQLException {
        List<Llocal> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM local");
            while (res.next()) {
                datos.add(new Llocal(
                        res.getInt("local_id"),
                        res.getString("nombre"),
                        res.getString("direccion"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error en la consulta de obtener los locales");
        }
        return datos;
    }

    public Llocal getById(int id) {
        Llocal local = new Llocal();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM local where local_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                local.setId(res.getInt(1));
                local.setNombre(res.getString(2));
                local.setDescripcion(res.getString(3));
                local.setEstado(res.getBoolean(4));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de obtener datos por id de local");
        }
        return local;
    }

    public void add(Llocal local) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO local (nombre, direccion) VALUES (?,?)");
            pst.setString(1, local.getNombre());
            pst.setString(2, local.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al registrar un local");
        }
    }

    public void update(Llocal local) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE local SET nombre=?, direccion=? WHERE local_id=?");
            pst.setString(1, local.getNombre());
            pst.setString(2, local.getDescripcion());
            pst.setInt(3, local.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al actualizar el local con el id: " + local.getId());
        }
    }
}
