package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOClientes;
import com.example.integradorsi.models.Clientes;
import java.util.List;

public class ClientesService {
    private DAOClientes clientesDAO;
    
    public ClientesService() {
        this.clientesDAO = new DAOClientes();
    }
    
    public List<Clientes> obtenerClientes() {
        return clientesDAO.getAll();
    }
    
}
