package com.example.integradorsi.controller;

import com.example.integradorsi.DAO.DAODetalleVenta;
import com.example.integradorsi.DAO.DAOProductos;
import com.example.integradorsi.DAO.DAOVentas;
import com.example.integradorsi.models.Carrito;
import com.example.integradorsi.models.CarritoProd;
import com.example.integradorsi.models.Clientes;
import com.example.integradorsi.models.DetalleVentas;
import com.example.integradorsi.models.Llocal;
import com.example.integradorsi.models.Login;
import com.example.integradorsi.models.Productos;
import com.example.integradorsi.models.TipoComprobante;
import com.example.integradorsi.models.Ventas;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CarritoController", urlPatterns = {"/CarritoController"})
public class CarritoController extends HttpServlet {

    protected final DAOProductos daoP = new DAOProductos();
    protected final DAOVentas daoV = new DAOVentas();
    protected final DAODetalleVenta daoDV = new DAODetalleVenta();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        daoV.add(new Ventas(0, carrito.getCliente(), carrito.getLocal(), new Date()));
        int id_carrito = daoV.size();
        Login registro_usuario = (Login) session.getAttribute("login");
        for (CarritoProd cp : carrito.getAll()) {
            DetalleVentas d = new DetalleVentas();
            d.setVenta(new Ventas(id_carrito));
            d.setProducto(cp.getProducto());
            d.setTipo_venta(cp.getComprobante());
            d.setCantidad(cp.getCantidad());
            d.setSub_total(0);
            d.setDescuento(0);
            d.setIgv(0);
            d.setTotal_pagar(cp.getPrecio());
            d.setRegistro_usuario(registro_usuario);
            d.setEstado(true);
            daoDV.add(d);
        }
        session.setAttribute("carrito", null);
        response.sendRedirect("reportes/ventas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        System.out.println(carrito);
        if (carrito == null) {
            carrito = new Carrito();
            Llocal local = new Llocal(Integer.parseInt(request.getParameter("local")));
            carrito.setLocal(local);
            Clientes cliente = new Clientes(Integer.parseInt(request.getParameter("cliente")));
            carrito.setCliente(cliente);
        }
        CarritoProd producto = new CarritoProd();
        Productos p = daoP.getById(Integer.parseInt(request.getParameter("nombreProd")));
        producto.setProducto(p);
        TipoComprobante tipoV = new TipoComprobante(Integer.parseInt(request.getParameter("tipoVenta")));
        producto.setComprobante(tipoV);
        producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        float precioTotal = Float.parseFloat(request.getParameter("precioTotal"));
        producto.setPrecio((double) precioTotal);
        carrito.add(producto);

        session.setAttribute("carrito", carrito);
        response.sendRedirect("registro/ventas.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
