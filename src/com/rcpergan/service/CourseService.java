package com.rcpergan.service;

import com.rcpergan.model.Course;
import com.rcpergan.repository.CrudRepository;

import java.util.List;

public class CourseService implements CrudRepository<Course> {
    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public void saveToDatabase(Course object) {

    }

    @Override
    public void deleteFromDatabase(Course object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Course object, String name) {

    }
}
