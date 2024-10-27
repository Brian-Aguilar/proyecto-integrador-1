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

public class DAOLocal implements IDAO<Llocal> {

    private Connection con;
    private Statement st;

    public DAOLocal() {
        this.con = Conexion.getConexion();
    }

    @Override
    public List<Llocal> getAll() {
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public Llocal delete(int id) {
        Llocal local = new Llocal();
        try {
            local = getById(id);
            boolean status = !(local.isEstado());
            if (local != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE local set estado=? WHERE local_id=?");
                pst.setBoolean(1, status);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al eliminar el local con el id: " + id);
        }
       return local;
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM local");
            if(rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al obtener tamaño de la tabla local");
        }
        return cantidad;
    }
}
