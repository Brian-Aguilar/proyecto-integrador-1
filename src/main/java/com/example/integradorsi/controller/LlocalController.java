package com.example.integradorsi.controller;

import com.example.integradorsi.DAO.DAOLocal;
import com.example.integradorsi.models.Llocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LlocalController", urlPatterns = {"/LlocalController"})
public class LlocalController extends HttpServlet {

    protected final DAOLocal conexion = new DAOLocal();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LlocalController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LlocalController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String local = request.getParameter("nombre");
        //String descripcion = request.getParameter("descripcion");
        //processRequest(request, response);
        System.out.println("GET");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String editar = null;
        String local = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Llocal localRegister = new Llocal(local, descripcion);

        try {
            editar = request.getParameter("tipo");
            localRegister.setId(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
        }

        if (editar == null) {
            conexion.add(localRegister);
            session.setAttribute("msg", "Se registro exitosamente.");
        } else {
            conexion.update(localRegister);
            session.setAttribute("msg", "Se actualizo exitosamente.");
        }
        response.sendRedirect("registro/local.jsp");
    }

    @Override
    public String getServletInfo() {
        return "GET and POST of file LLocalController";
    }// </editor-fold>

}
