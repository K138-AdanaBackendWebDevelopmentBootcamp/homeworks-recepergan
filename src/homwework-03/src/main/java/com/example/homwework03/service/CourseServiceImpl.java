package com.example.homwework03.service;

import com.example.homwework03.dao.CourseDAO;
import com.example.homwework03.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService<Course> {

    CourseDAO courseDAO;

   // @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
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
