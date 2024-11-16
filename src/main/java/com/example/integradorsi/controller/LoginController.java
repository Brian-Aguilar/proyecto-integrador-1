package com.example.integradorsi.controller;

import com.example.integradorsi.models.Login;
import com.example.integradorsi.services.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected final LoginService service = new LoginService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("login", null);
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String usuario, password;

        try {
            usuario = request.getParameter("usuario");
            password = request.getParameter("password");
            Login u = service.authenticator(new Login(
                    usuario, password));

            if (u.getId() != 0) {
                session.setAttribute("login", u);
                response.sendRedirect(request.getContextPath());
            } else {
                System.out.println(u);
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
