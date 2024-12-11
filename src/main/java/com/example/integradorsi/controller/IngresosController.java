package com.example.integradorsi.controller;

import com.example.integradorsi.DAO.DAODetalleIngresos;
import com.example.integradorsi.DAO.DAOIngresos;
import com.example.integradorsi.models.DetalleIngresos;
import com.example.integradorsi.models.Ingresos;
import com.example.integradorsi.models.Llocal;
import com.example.integradorsi.models.Login;
import com.example.integradorsi.models.Productos;
import com.example.integradorsi.models.TipoComprobante;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IngresosController", urlPatterns = {"/IngresosController"})
public class IngresosController extends HttpServlet {

    protected final DAOIngresos daoI = new DAOIngresos();
    protected final DAODetalleIngresos daoDI = new DAODetalleIngresos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Productos producto_id = new Productos(Integer.parseInt(request.getParameter("producto")));
        TipoComprobante comprobante = new TipoComprobante(Integer.parseInt(request.getParameter("tipo_comprobante")));
        int comprobante_numero = Integer.parseInt(request.getParameter("comprobante"));
        Date fecha_p = null;
        try {
            fecha_p = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
        }
        Llocal local = new Llocal(Integer.parseInt(request.getParameter("local")));
        int importe = Integer.parseInt(request.getParameter("importe"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        Login usuario = new Login(Integer.parseInt(request.getParameter("usuario")));
        Ingresos ingreso = new Ingresos(comprobante, fecha_p, comprobante_numero, local, importe, usuario, new Date());
        daoI.add(ingreso);
        Ingresos ingreso_id = new Ingresos(daoI.size());
        System.out.println(daoI.size());
        DetalleIngresos di = new DetalleIngresos(ingreso_id, producto_id, cantidad, precio);
        daoDI.add(di);
        response.sendRedirect("registro/ingresos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
