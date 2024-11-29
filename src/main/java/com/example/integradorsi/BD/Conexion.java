package com.example.integradorsi.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static Statement st;

    public static Connection getConexion() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String path_db = "jdbc:sqlite:/Users/brian/Desktop/sistemaInventario.db";
            conn = DriverManager.getConnection(path_db);
            conn.setAutoCommit(true);
            init(conn);
            try {
                dataInit(conn);
            } catch (Exception ex) {
                System.out.println("Error al insertar información base:");
                System.out.println(ex.getMessage());
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void init(Connection con) {
        try {
            st = con.createStatement();
            // Tabla de los locales
            st.executeUpdate("CREATE TABLE IF NOT EXISTS local("
                    + "    local_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "    nombre TEXT UNIQUE NOT NULL,"
                    + "    direccion TEXT NOT NULL,"
                    + "    estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla de tipo de comprobante
            st.executeUpdate("CREATE TABLE IF NOT EXISTS tipoComprobante("
                    + "    comprobante_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "    nombre TEXT UNIQUE NOT NULL,"
                    + "    estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla Marca
            st.executeUpdate("CREATE TABLE IF NOT EXISTS marca("
                    + "	marca_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " nombre TEXT UNIQUE NOT NULL,"
                    + "	descripcion TEXT,"
                    + "	estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla Categoria
            st.executeUpdate("CREATE TABLE IF NOT EXISTS categoria("
                    + "	categoria_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " nombre TEXT UNIQUE NOT NULL,"
                    + "	descripcion TEXT,"
                    + "	estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla Producto
            st.executeUpdate("CREATE TABLE IF NOT EXISTS productos("
                    + "	producto_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	nombre TEXT UNIQUE NOT NULL,"
                    + "	descripcion TEXT NOT NULL,"
                    + "	precio REAL NOT NULL,"
                    + "	categoria_id INTEGER NOT NULL,"
                    + "	marca_id INTEGER NOT NULL,"
                    + "	estado NUMERIC DEFAULT 1,"
                    + "	FOREIGN KEY (categoria_id) REFERENCES categoria (categoria_id),"
                    + "	FOREIGN KEY (marca_id) REFERENCES marca (marca_id)"
                    + ");");
            // Tabla tipo de documento
            st.executeUpdate("CREATE TABLE IF NOT EXISTS tipoDocumento("
                    + "	documento_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	nombre TEXT UNIQUE NOT NULL,"
                    + "	estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla cliente
            st.executeUpdate("CREATE TABLE IF NOT EXISTS cliente("
                    + "	cliente_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	nombre_completo TEXT NOT NULL,"
                    + "	apellido_materno TEXT NOT NULL,"
                    + "	apellido_paterno TEXT NOT NULL,"
                    + "	telefono TEXT,"
                    + "	documento_id INTEGER NOT NULL,"
                    + "	documento_informacion TEXT NOT NULL,"
                    + "	correo TEXT,"
                    + "	estado NUMERIC DEFAULT 1,"
                    + "	FOREIGN KEY (documento_id) REFERENCES tipoDocumento (documento_id)"
                    + ")");
            // Tabla usuario
            st.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios("
                    + "	usuario_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	usuario TEXT UNIQUE NOT NULL,"
                    + "	nombre_completo TEXT NOT NULL,"
                    + "	password TEXT NOT NULL,"
                    + "	is_admin NUMERIC DEFAULT 0,"
                    + "	is_vendedor NUMERIC DEFAULT 1,"
                    + "	estado NUMERIC DEFAULT 1"
                    + ")");
            // Table ingreso
            st.executeUpdate("CREATE TABLE IF NOT EXISTS ingresos("
                    + "	ingreso_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	comprobante_id INTEGER NOT NULL,"
                    + "	fecha TIMESTAMP DEFAULT (datetime('now', 'localtime')),"
                    + "	numero_comprobante INTEGER NOT NULL,"
                    + "	local_id INTEGER NOT NULL,"
                    + "	importe REAL NOT NULL,"
                    + "	registro_usuario INTEGER NOT NULL,"
                    + "	registro_fecha TIMESTAMP DEFAULT (datetime('now', 'localtime')),"
                    + "	modificar_usuario INTEGER NOT NULL,"
                    + "	modificar_fecha TIMESTAMP DEFAULT (datetime('now', 'localtime')),"
                    + "	eliminar_usuario INTEGER NOT NULL,"
                    + "	eliminar_fecha TIMESTAMP DEFAULT (datetime('now', 'localtime')),"
                    + "	estado NUMERIC DEFAULT 1,"
                    + "	FOREIGN KEY (comprobante_id) REFERENCES tipoComprobante(comprobante_id),"
                    + "	FOREIGN KEY (local_id) REFERENCES local(local_id),"
                    + "	FOREIGN KEY (registro_usuario) REFERENCES usuarios(usuario_id),"
                    + "	FOREIGN KEY (modificar_usuario) REFERENCES usuarios(usuario_id),"
                    + "	FOREIGN KEY (eliminar_usuario) REFERENCES usuarios(usuario_id)"
                    + ")");
            // Tabla detalles ingresos
            st.executeUpdate("CREATE TABLE IF NOT EXISTS detalleIngreso("
                    + "	detalle_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	ingreso_id INTEGER NOT NULL,"
                    + "	producto_id INTEGER NOT NULL,"
                    + "	cantidad INTEGER NOT NULL,"
                    + "	precio REAL NOT NULL,"
                    + "	FOREIGN KEY (ingreso_id) REFERENCES ingresos (ingreso_id),"
                    + "	FOREIGN KEY (producto_id) REFERENCES productos (producto_id)"
                    + ")");
            // Tabla tipo de venta
            st.executeUpdate("CREATE TABLE IF NOT EXISTS tipoVenta("
                    + "	tipoVenta_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	nombre TEXT UNIQUE NOT NULL,"
                    + "	descripcion TEXT,"
                    + "	estado NUMERIC DEFAULT 1"
                    + ")");
            // Tabla ventas
            st.executeUpdate("CREATE TABLE IF NOT EXISTS ventas("
                    + "	venta_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "	cliente_id INTEGER NOT NULL,"
                    + "	local_id INTEGER NOT NULL,"
                    + "	fecha_venta DATETIME DEFAULT (datetime('now', 'localtime')),"
                    + "	FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id),"
                    + "	FOREIGN KEY (local_id) REFERENCES local (local_id)"
                    + ")");
            // Tabla detalle de ventas
            st.executeUpdate("CREATE TABLE IF NOT EXISTS detalleVenta("
                    + "	venta_id INTEGER NOT NULL,"
                    + "	producto_id INTEGER NOT NULL,"
                    + "	tipoVenta_id INTEGER NOT NULL,"
                    + "	cantidad INTEGER NOT NULL,"
                    + "	sub_total REAL NOT NULL,"
                    + "	descuento REAL NOT NULL,"
                    + "	igv REAL NOT NULL,"
                    + "	total_pagar REAL NOT NULL,"
                    + "	registro_usuario INTEGER NOT NULL,"
                    + "	estado NUMERIC DEFAULT 1,"
                    + "	FOREIGN KEY (venta_id) REFERENCES ventas (venta_id),"
                    + "	FOREIGN KEY (producto_id) REFERENCES productos (producto_id),"
                    + "	FOREIGN KEY (tipoVenta_id) REFERENCES tipoVenta (tipoVenta_id),"
                    + "	FOREIGN KEY (registro_usuario) REFERENCES usuarios (usuarios_id)"
                    + ")");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas, " + e);
        }
    }

    private static void dataInit(Connection con) throws Exception {
        st = con.createStatement();
        // Datos base de usuario
        try {
            st.executeUpdate("INSERT INTO usuarios (usuario, nombre_completo, password, is_admin, is_vendedor)"
                    + "VALUES ('admin', 'Administrador', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1, 0), "
                    + "('vendedor', 'Vendedor Ejemplo', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 0, 1)");
        } catch (SQLException e) {
        }
        // Datos de la tabla local
        try {
            st.executeUpdate("INSERT INTO local (nombre, direccion) VALUES ('Los Olivos 2', 'Av.'), ('SMPL', 'Av.'), ('Callao', 'Av.'), ('Comas', 'Av.')");
        } catch (SQLException e) {
        }
        // Datos de la tabla tipo de comprobante
        try {
            st.executeUpdate("INSERT INTO tipoComprobante (nombre) VALUES ('Boleta'), ('Factura'), ('Guía'), ('Otro'), ('Nota de venta')");
        } catch (SQLException e) {
        }
        // Datos de la tabla tipo de documento
        try {
            st.executeUpdate("INSERT INTO tipoDocumento (nombre) VALUES ('DNI'), ('CE'), ('Pasaporte')");
        } catch (SQLException e) {
        }
        // Datos de la tabla Categoria
        try {
            st.executeUpdate("INSERT INTO categoria (nombre) VALUES ('Reloj'), ('Mochila'), ('Accesorio'), ('Billetera'), ('Cartera')");
        } catch (SQLException e) {
        }
        // Datos de la tabla Marca
        try {
            st.executeUpdate("INSERT INTO marca (nombre) VALUES ('Adidas'), ('Brisa'), ('Fordan Jeans'), ('Idea Uno'), ('Levis'), ('Falabella'), ('Tulula'), ('Valeska')");
        } catch (SQLException e) {
        }
        // Datos de la tabla Productos
        try {
            st.executeUpdate("INSERT INTO productos (nombre, descripcion, precio, categoria_id, marca_id) "
                    + "VALUES ('Mochila P2', 'Mochila lbl 2005', 21.10, 5, 2)");
        } catch (SQLException e) {
        }

    }

}
