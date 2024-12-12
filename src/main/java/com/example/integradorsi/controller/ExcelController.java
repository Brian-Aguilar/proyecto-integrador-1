package com.example.integradorsi.controller;

import com.example.integradorsi.DAO.DAODetalleIngresos;
import com.example.integradorsi.DAO.DAODetalleVenta;
import com.example.integradorsi.models.DetalleIngresos;
import com.example.integradorsi.models.DetalleVentas;
import com.example.integradorsi.utils.SaveExcel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcelController", urlPatterns = {"/ExcelController"})
public class ExcelController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExcelController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExcelController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "";
        String tipo = request.getParameter("tipo");
        if ("ingreso".equals(tipo)) {
            ruta = "/Users/brian/NetBeansProjects/IntegradorSI/ingreso.xlsx";
            DAODetalleIngresos daoDI = new DAODetalleIngresos();
            List<DetalleIngresos> lista = daoDI.getAll();
            SaveExcel<DetalleIngresos> excel = new SaveExcel<>(ruta, "ingresos");
            try {
                excel.reporteIngresos(lista);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            response.sendRedirect("reportes/ingresos.jsp");
        } else if ("venta".equals(tipo)) {
            ruta = "/Users/brian/NetBeansProjects/IntegradorSI/ventas.xlsx";
            DAODetalleVenta daoDV = new DAODetalleVenta();
            List<DetalleVentas> lista = daoDV.getAll();
            SaveExcel<DetalleVentas> excel = new SaveExcel<>(ruta, "ventas");
            try {
                excel.reporteVentas(lista);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            response.sendRedirect("reportes/ventas.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
