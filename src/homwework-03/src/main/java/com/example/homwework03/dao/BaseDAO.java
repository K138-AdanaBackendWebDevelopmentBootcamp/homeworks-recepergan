package com.example.homwework03.dao;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();
    T findById(int id);
    T save (T object);
    void deleteById(int id);
    T update (T object);
}
