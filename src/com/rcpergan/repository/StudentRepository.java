package com.rcpergan.repository;

import com.rcpergan.model.Course;
import com.rcpergan.model.Student;

import java.util.List;

public interface StudentRepository {

    void deleteStudentWithId(int id);

    List<Course> getStudentCourseList(Student student);
}
