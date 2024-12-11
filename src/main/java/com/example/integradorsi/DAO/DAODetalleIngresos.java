package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.DetalleIngresos;
import com.example.integradorsi.models.Ingresos;
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

public class DAODetalleIngresos implements IDAO<DetalleIngresos> {

    private final Connection con;
    private Statement st;
    private final DAOIngresos daoI;
    private final DAOProductos daoP;
    private final Logger logger = LoggerFactory.getLogger(DAODetalleIngresos.class);

    public DAODetalleIngresos() {
        this.con = Conexion.getConexion();
        this.daoI = new DAOIngresos();
        this.daoP = new DAOProductos();
    }

    @Override
    public List<DetalleIngresos> getAll() {
        List<DetalleIngresos> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM detalleIngreso");
            while (res.next()) {
                DetalleIngresos di = new DetalleIngresos();
                di.setId(res.getInt("detalle_id"));
                Ingresos ingreso = this.daoI.getById(res.getInt("ingreso_id"));
                di.setIngreso(ingreso);
                Productos producto = this.daoP.getById(res.getInt("producto_id"));
                di.setProducto(producto);
                di.setCantidad(res.getInt("cantidad"));
                di.setPrecio(res.getInt("precio"));
                datos.add(di);
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los detalles de ingresos, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public DetalleIngresos getById(int id) {
        DetalleIngresos di = new DetalleIngresos();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM detalleIngreso where detalle_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                di.setId(res.getInt("detalle_id"));
                Ingresos ingreso = this.daoI.getById(res.getInt("ingreso_id"));
                di.setIngreso(ingreso);
                Productos producto = this.daoP.getById(res.getInt("producto_id"));
                di.setProducto(producto);
                di.setCantidad(res.getInt("cantidad"));
                di.setPrecio(res.getInt("precio"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los detalles de ingresos por id, {}",
                    e.getMessage());
        }
        return di;
    }

    @Override
    public void add(DetalleIngresos item) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO detalleIngreso (ingreso_id, producto_id, cantidad, precio) "
                    + "VALUES (?, ?, ?, ?)");
            pst.setInt(1, item.getIngreso().getId());
            pst.setInt(2, item.getProducto().getId());
            pst.setInt(3, item.getCantidad());
            pst.setDouble(4, item.getPrecio());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error al agregar un detalle de ingreso, {}",
                    e.getMessage());
        }
    }

    @Override
    public void update(DetalleIngresos item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleIngresos delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM detalleIngreso");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.info("Error al obtener el tamaño de la tabala detalle de ingreso, {}",
                    e.getMessage());
        }
        return cantidad;
    }

}
