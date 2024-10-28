package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOMarca;
import com.example.integradorsi.models.Marca;
import java.util.List;

public class MarcaService {
    private DAOMarca marcaDAO;
    
    public MarcaService() {
        this.marcaDAO = new DAOMarca();
    }
    
    public Marca obtenerMarca(int id) {
        return marcaDAO.getById(id);
    }
    public List<Marca> obtenerMarcas() {
        return marcaDAO.getAll();
    }
    public void agregarMarca(Marca marca) {
        marcaDAO.add(marca);
    }
    public void actualizarMarca(Marca marca) {
        marcaDAO.update(marca);
    }
    public Marca eliminarMarca(int id) {
        return marcaDAO.delete(id);
    }
    public int cantidadMarca() {
        return marcaDAO.size();
    }
    
}
