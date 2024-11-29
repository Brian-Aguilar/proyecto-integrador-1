package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOProductos;
import com.example.integradorsi.models.Productos;
import java.util.List;

public class ProductosService {
    private DAOProductos productosDAO;
    
    public ProductosService() {
        this.productosDAO = new DAOProductos();
    }
    
    public Productos obtenerProducto(int id) {
        return productosDAO.getById(id);
    }
    
    public List<Productos> obtenerProductos() {
        return productosDAO.getAll();
    }
    
    public void agregarProducto(Productos producto) {
        productosDAO.add(producto);
    }
    
    public void actualizarProducto(Productos producto) {
        productosDAO.update(producto);
    }
    
    public Productos eliminarProducto(int id) {
        return productosDAO.delete(id);
    }
    
    public int cantidadProductos() {
        return productosDAO.size();
    }
}
