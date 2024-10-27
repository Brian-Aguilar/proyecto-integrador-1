package com.example.integradorsi.services;

import com.example.integradorsi.DAO.DAOLocal;
import com.example.integradorsi.models.Llocal;
import java.util.List;

public class LocalService {
    
    private DAOLocal localDAO;
    
    public LocalService() {
        this.localDAO = new DAOLocal();
    }
    
    public Llocal obtenerLocal(int id) {
        return localDAO.getById(id);
    }
    public List<Llocal> obtenerLocales() {
        return localDAO.getAll();
    }
    public void agregarLocal(Llocal local) {
        localDAO.add(local);
    }
    public void actualizarLocal(Llocal local) {
        localDAO.update(local);
    }
    public Llocal eliminarLocal(int id) {
        return localDAO.delete(id);
    }
    public int cantidadDeLocales() {
        return localDAO.size();
    }
}
