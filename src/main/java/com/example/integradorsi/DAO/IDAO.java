package com.example.integradorsi.DAO;

import java.util.List;

interface IDAO<T> {

    List<T> getAll();

    T getById(int id);

    void add(T item);

    void update(T item);

    T delete(int id);

    int size();
}
