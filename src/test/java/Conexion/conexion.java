package Conexion;

import com.example.integradorsi.BD.Conexion;
import com.example.integradorsi.DAO.DAOTipoComprobante;
import com.example.integradorsi.models.Llocal;
import com.example.integradorsi.models.TipoComprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class conexion {

    public static void main(String[] args) {
        try {
            DAOTipoComprobante d = new DAOTipoComprobante();
            for(TipoComprobante c : d.getAll()) {
                System.out.println(c.getNombre());
            }
                   
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
