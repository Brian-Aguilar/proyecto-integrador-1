package com.example.integradorsi.DAO;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.models.Ingresos;
import com.example.integradorsi.models.Llocal;
import com.example.integradorsi.models.Login;
import com.example.integradorsi.models.TipoComprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOIngresos implements IDAO<Ingresos> {

    private Connection con;
    private Statement st;
    private DAOTipoComprobante daoTC;
    private DAOLocal daoL;
    private DAOLogin daoU;
    private final Logger logger = LoggerFactory.getLogger(DAOIngresos.class);

    public DAOIngresos() {
        this.con = Conexion.getConexion();
        this.daoTC = new DAOTipoComprobante(this.con);
        this.daoL = new DAOLocal(this.con);
        this.daoU = new DAOLogin(this.con);
    }

    @Override
    public List<Ingresos> getAll() {
        List<Ingresos> datos = new ArrayList<>();
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM ingresos where estado=1");
            while (res.next()) {
                Ingresos ingreso = new Ingresos();
                ingreso.setId(res.getInt("ingreso_id"));
                TipoComprobante comprobante = this.daoTC.getById(res.getInt("comprobante_id"));
                ingreso.setComprobante(comprobante);
                ingreso.setFecha(res.getDate("fecha"));
                ingreso.setNumero_comprobante(res.getInt("numero_comprobante"));
                Llocal local = this.daoL.getById(res.getInt("local_id"));
                ingreso.setLocal(local);
                ingreso.setImporte(res.getInt("importe"));
                Login registroUsuario = this.daoU.getById(res.getInt("registro_usuario"));
                ingreso.setRegistro_usuario(registroUsuario);
                ingreso.setRegistro_fecha(res.getDate("registro_fecha"));
                try {
                    Login modificarUsuario = this.daoU.getById(res.getInt("modificar_usuario"));
                    ingreso.setModificar_usuario(modificarUsuario);
                    ingreso.setModificar_fecha(res.getDate("modificar_fecha"));
                } catch (Exception e) {
                }

                try {
                    Login eliminarUsuario = this.daoU.getById(res.getInt("eliminar_usuario"));
                    ingreso.setEliminar_usuario(eliminarUsuario);
                    ingreso.setEliminar_fecha(res.getDate("eliminar_fecha"));
                } catch (Exception e) {
                }
                ingreso.setEstado(res.getBoolean("estado"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener los ingresos, {}",
                    e.getMessage());
        }
        return datos;
    }

    @Override
    public Ingresos getById(int id) {
        Ingresos ingreso = new Ingresos();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM ingresos where ingreso_id = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res != null) {
                res.next();
                ingreso.setId(res.getInt("ingreso_id"));
                TipoComprobante comprobante = this.daoTC.getById(res.getInt("comprobante_id"));
                ingreso.setComprobante(comprobante);
                ingreso.setFecha(res.getDate("fecha"));
                ingreso.setNumero_comprobante(res.getInt("numero_comprobante"));
                Llocal local = this.daoL.getById(res.getInt("local_id"));
                ingreso.setLocal(local);
                ingreso.setImporte(res.getInt("importe"));
                Login registroUsuario = this.daoU.getById(res.getInt("registro_usuario"));
                ingreso.setRegistro_usuario(registroUsuario);
                ingreso.setRegistro_fecha(res.getDate("registro_fecha"));
                try {
                    Login modificarUsuario = this.daoU.getById(res.getInt("modificar_usuario"));
                    ingreso.setModificar_usuario(modificarUsuario);
                    ingreso.setModificar_fecha(res.getDate("modificar_fecha"));
                } catch (Exception e) {
                }

                try {
                    Login eliminarUsuario = this.daoU.getById(res.getInt("eliminar_usuario"));
                    ingreso.setEliminar_usuario(eliminarUsuario);
                    ingreso.setEliminar_fecha(res.getDate("eliminar_fecha"));
                } catch (Exception e) {
                }
                ingreso.setEstado(res.getBoolean("estado"));
            }
        } catch (SQLException e) {
            logger.info("Error en la consulta de obtener datos por id de ingresos, {}",
                    e.getMessage());
        }
        return ingreso;
    }

    @Override
    public void add(Ingresos item) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO ingresos (comprobante_id, fecha, numero_comprobante, local_id, importe, registro_usuario, registro_fecha, estado)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, item.getComprobante().getId());
            pst.setDate(2, new java.sql.Date(item.getFecha().getTime()));
            pst.setInt(3, item.getNumero_comprobante());
            pst.setInt(4, item.getLocal().getId());
            pst.setInt(5, item.getImporte());
            pst.setInt(6, item.getRegistro_usuario().getId());
            pst.setDate(7, new java.sql.Date(item.getRegistro_fecha().getTime()));
            pst.setBoolean(8, item.isEstado());
            pst.executeUpdate();
        } catch (SQLException e) {
            logger.info("Error en la agregar un ingreso, {}",
                    e.getMessage());
        }
    }

    @Override
    public void update(Ingresos item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingresos delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        int cantidad = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as cantidad FROM ingresos");
            if (rs != null) {
                rs.next();
                cantidad = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.info("Error al obtener tamaño de ingresos, {}",
                    e.getMessage());
        }
        return cantidad;
    }

}
