package com.example.integradorsi.controller;

import com.example.integradorsi.models.Categoria;
import com.example.integradorsi.models.Marca;
import com.example.integradorsi.models.Productos;
import com.example.integradorsi.services.ProductosService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {
    
    protected final ProductosService service = new ProductosService();

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
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio").trim());
        int categoria_id = Integer.parseInt(request.getParameter("categoria"));
        Categoria categoria = new Categoria();
        categoria.setId(categoria_id);
        int marca_id = Integer.parseInt(request.getParameter("marca"));
        Marca marca = new Marca();
        marca.setId(marca_id);
        Productos prod = new Productos();
        prod.setNombre(nombre);
        prod.setDescripcion(descripcion);
        prod.setPrecio(precio);
        prod.setCategoria(categoria);
        prod.setMarca(marca);
        service.agregarProducto(prod);
        response.sendRedirect("gestion/productos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
