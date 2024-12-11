package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOMarca implements IDAO<Marca> {

    private Connection con;
    private Statement st;
    private final Logger logger = LoggerFactory.getLogger(DAOLocal.class);

    public DAOMarca(Connection x) {
        if (x != null) {
            this.con = x;
        } else {
            this.con = Conexion.getConexion();
        }
    }

    @Override
    public List<Marca> getAll() {
        List<Marca> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM marca");
            while (res.next()) {
                lista.add(new Marca(
                        res.getInt("marca_id"),
                        res.getString("nombre"),
                        res.getString("descripcion"),
                        res.getBoolean("estado")
                ));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los marcas, {}",
                    e.getMessage());
        }
        return lista;
    }

    @Override
    public Marca getById(int id) {
        Marca marca = new Marca();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM marca where marca_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                marca.setId(res.getInt(1));
                marca.setNombre(res.getString(2));
                marca.setDescripcion(res.getString(3));
                marca.setEstado(res.getBoolean(4));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id de marca, {}",
                    e.getMessage());
        }
        return marca;
    }

    @Override
    public void add(Marca marca) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO marca (nombre, descripcion) VALUES (?)");
            pst.setString(1, marca.getNombre());
            pst.setString(2, marca.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al registrar una marca, {}", e.getMessage());
        }
    }

    @Override
    public void update(Marca marca) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE marca SET nombre=? WHERE categoria_id=?");
            pst.setString(1, marca.getNombre());
            pst.setInt(3, marca.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al actualizar la marca con el id: {}, {}",
                    marca.getId(), e.getMessage());
        }
    }

    @Override
    public Marca delete(int id) {
        Marca marca = new Marca();
        try {
            marca = getById(id);
            boolean status = !(marca.isEstado());
            if (marca != null) {
                PreparedStatement pst = con.prepareStatement("UPDATE marca set estado=? WHERE categoria_id=?");
                pst.setBoolean(1, status);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            logger.info("Error al eliminar la marca con el id: {}, {}",
                    id, e.getMessage());
        }
        return marca;
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM marca");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.info("Error al obtener el tamaño en la tabla marca, {}",
                    e.getMessage());
        }
        return cantidad;
    }
}
