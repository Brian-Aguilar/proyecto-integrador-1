package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOLogin;
import com.example.integradorsi.models.Login;
import java.util.List;

public class LoginService {
    private DAOLogin loginDAO;
    
    public LoginService() {
        this.loginDAO = new DAOLogin(null);
    }
    
    public List<Login> obtenerUsuarios() {
        return loginDAO.getAll();
    }
    
    public Login authenticator(Login usuario) {
        return loginDAO.getByAuth(usuario);
    }
}
