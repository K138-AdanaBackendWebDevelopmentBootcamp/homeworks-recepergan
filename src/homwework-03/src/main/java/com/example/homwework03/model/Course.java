package com.example.homwework03.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "coursename")
    private String courseName;
    @Column(name = "coursecode")
    private String courseCode;
    @Column(name = "coursescore")
    private int creditScore;

    @ManyToMany(mappedBy = "courseList",fetch = FetchType.LAZY)
    private List<Student> studentList = new ArrayList<Student>();

    @ManyToOne
    private Instructor instructor;

    public Course() {
    }

    public Course(String courseName, String courseCode, int creditScore) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return creditScore == course.creditScore && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode) && Objects.equals(studentList, course.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, creditScore, studentList);
    }



}
