package com.rcpergan.controller;


import com.rcpergan.model.Course;
import com.rcpergan.model.Student;
import com.rcpergan.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    public Student findStudentById(int id) {
        return studentService.findById(id);
    }

    public void saveStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(Student student) {
        studentService.deleteFromDatabase(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteFromDatabase(id);
    }

    public void deleteStudentWithPrimaryId(int id) {
        studentService.deleteFromDatabase(id);
    }

    public void updateStudent(Student student, String name) {
        studentService.updateOnDatabase(student,name);
    }

    public List<Course> getStudentCourseList(Student student) {
        return studentService.getStudentCourseList(student);
    }


}
