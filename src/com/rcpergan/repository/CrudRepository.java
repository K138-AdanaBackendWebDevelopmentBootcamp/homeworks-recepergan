package com.rcpergan.repository;

import com.rcpergan.model.Student;

import java.util.List;

public interface CrudRepository <T>{

    List<T> findAll();
    T findById(int id);
    void saveToDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(int id);
    void updateOnDatabase(T object, String name);


}
