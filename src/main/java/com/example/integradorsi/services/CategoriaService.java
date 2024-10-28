package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOCategoria;
import com.example.integradorsi.models.Categoria;
import java.util.List;

public class CategoriaService {
    private DAOCategoria categoriaDAO;
    
    public CategoriaService() {
        this.categoriaDAO = new DAOCategoria();
    }
    
    public Categoria obtenerCategoria(int id) {
        return categoriaDAO.getById(id);
    }
    public List<Categoria> obtenerCategorias() {
        return categoriaDAO.getAll();
    }
    public void agregarCategoria(Categoria categoria) {
        categoriaDAO.add(categoria);
    }
    public void actualizarCategoria(Categoria categoria) {
        categoriaDAO.update(categoria);
    }
    public Categoria eliminarCategoria(int id) {
        return categoriaDAO.delete(id);
    }
    public int cantidadDeCategoria() {
        return categoriaDAO.size();
    }
}
