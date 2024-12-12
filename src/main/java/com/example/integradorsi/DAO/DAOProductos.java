package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOProductos implements IDAO<Productos> {
    
    private Connection con;
    private Statement st;
    private DAOCategoria cat;
    private DAOMarca mar;
    private final Logger logger = LoggerFactory.getLogger(DAOProductos.class);
    
    public DAOProductos() {
        this.con = Conexion.getConexion();
        this.cat = new DAOCategoria(this.con);
        this.mar = new DAOMarca(this.con);
    }
    
    @Override
    public List<Productos> getAll() {
        List<Productos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM productos where estado=1");
            while (res.next()) {
                Productos prod = new Productos();
                prod.setId(res.getInt("producto_id"));
                prod.setNombre(res.getString("nombre"));
                prod.setPrecio(res.getDouble("precio"));
                int categoria_id = res.getInt("categoria_id");
                prod.setCategoria(cat.getById(categoria_id));
                int marca_id = res.getInt("marca_id");
                prod.setMarca(mar.getById(marca_id));
                prod.setEstado(res.getBoolean("estado"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los productos, {}",
                    e.getMessage());
        }
        
        return lista;
    }
    
    @Override
    public Productos getById(int id) {
        Productos producto = new Productos();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM productos where producto_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                producto.setId(res.getInt("producto_id"));
                producto.setNombre(res.getString("nombre"));
                producto.setDescripcion(res.getString("descripcion"));
                producto.setPrecio(res.getDouble("precio"));
                int categoria_id = res.getInt("categoria_id");
                producto.setCategoria(cat.getById(categoria_id));
                int marca_id = res.getInt("marca_id");
                producto.setMarca(mar.getById(marca_id));
                producto.setEstado(res.getBoolean("estado"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id del producto, {}",
                    e.getMessage());
        }
        return producto;
    }
    
    @Override
    public void add(Productos item) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO productos (nombre, descripcion, precio, categoria_id, marca_id) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, item.getNombre());
            pst.setString(2, item.getDescripcion());
            pst.setDouble(3, item.getPrecio());
            pst.setInt(4, item.getCategoria().getId());
            pst.setInt(5, item.getMarca().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al registrar un producto, {}", e.getMessage());
        }
    }
    
    @Override
    public void update(Productos item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Productos delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM productos");
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
