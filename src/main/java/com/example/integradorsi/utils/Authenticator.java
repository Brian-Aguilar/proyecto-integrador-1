package com.example.integradorsi.utils;

import com.example.integradorsi.models.Login;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authenticator {

    public static void validated(HttpServletRequest req,
            HttpServletResponse res) throws ServletException {
        HttpSession session = req.getSession();
        try {
            Login usuario = (Login) session.getAttribute("login");
            String pathDf = req.getServletPath();
            if (usuario == null) {
                if (!pathDf.contains("login")) {
                    res.sendRedirect("login.jsp");
                }
            } else {
                if (pathDf.contains("login")) {
                    res.sendRedirect(req.getContextPath());
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
