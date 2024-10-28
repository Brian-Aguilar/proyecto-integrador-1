package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoria implements IDAO<Categoria> {

    private Connection con;
    private Statement st;

    public DAOCategoria() {
        this.con = Conexion.getConexion();
    }

    @Override
    public List<Categoria> getAll() {
        List<Categoria> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM categoria");
            while (res.next()) {
                lista.add(new Categoria(
                        res.getInt("categoria_id"),
                        res.getString("nombre"),
                        res.getString("descripcion"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error en la consulta de obtener las categorias");
        }
        return lista;
    }

    @Override
    public Categoria getById(int id) {
        Categoria categoria = new Categoria();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM categoria where categoria_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                categoria.setId(res.getInt(1));
                categoria.setNombre(res.getString(2));
                categoria.setDescripcion(res.getString(3));
                categoria.setEstado(res.getBoolean(4));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de obtener datos por id de categoria");
        }
        return categoria;
    }

    @Override
    public void add(Categoria categoria) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO categoria (nombre) VALUES (?)");
            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al agregar una categoria");
        }
    }

    @Override
    public void update(Categoria categoria) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE categoria SET nombre=? WHERE categoria_id=?");
            pst.setString(1, categoria.getNombre());
            pst.setInt(3, categoria.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al actualizar la categoria con el id: " + categoria.getId());
        }
    }

    @Override
    public Categoria delete(int id) {
        Categoria categoria = new Categoria();
        try {
            categoria = getById(id);
            boolean status = !(categoria.isEstado());
            if (categoria != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE categoria set estado=? WHERE categoria_id=?");
                pst.setBoolean(1, status);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al eliminar la categoria con el id: " + id);
        }
        return categoria;
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM categoria");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al obtener tamaño de la tabla categoria");
        }
        return cantidad;
    }
}
