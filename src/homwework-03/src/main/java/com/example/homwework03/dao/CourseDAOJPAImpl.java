package com.example.homwework03.dao;

import com.example.homwework03.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    EntityManager entityManager;

   // @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course",Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Course update(Course object) {
        return null;
    }
}
