package com.rcpergan.clients;

import com.rcpergan.controller.StudentController;
import com.rcpergan.model.*;
import com.rcpergan.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class TestInsuranceClient {

    public static void main(String[] args) {

        if(checkTestData() == 0) {
            saveTestData();
       }

        StudentController studentControlller = new StudentController();
        List<Student> studentList = studentControlller.findAllStudents();

        System.out.println("1********************");
        System.out.println("1.1----------------------");
        for(Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("1.2----------------------");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.println("1.3-------------------");
        Iterator<Student> studentIterator = studentList.iterator();
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
        System.out.println("1.4-----------------------");
        studentList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        System.out.println("1.5----------------------");
        studentList.forEach((s) ->
                System.out.println(s));
        System.out.println("1.6--------------");
        //method reference
        studentList.forEach(System.out::println);
        System.out.println("2.---------------");

        System.out.println(studentControlller.findStudentById(1));

        System.out.println("3---------------");

        Student newStudent = new Student("alex",LocalDate.of(1993,12,13),"alipasa","Erkek");
        studentControlller.saveStudent(newStudent);
        studentList.forEach(System.out::println);

        System.out.println("4---------------------");
        //studentControlller.deleteStudent(studentList.get(4));
        studentList.forEach(System.out::println);

        System.out.println("5-------------------");

        //studentControlller.deleteStudent(3);
        studentList.forEach(System.out::println);

        System.out.println("6------------------------");

        //studentControlller.deleteStudentWithPrimaryId(3);
        studentList.forEach(System.out::println);

        System.out.println("7-----------------------------");

        Student foundStudent = studentList.get(0);
        foundStudent.setName("van hoojdonk");
        //studentControlller.updateStudent(foundStudent,foundStudent.getName());
        studentList.forEach(System.out::println);

        System.out.println("8----------------------");

        List<Course> courseList = studentControlller.getStudentCourseList(foundStudent);
        System.out.println(courseList);

        System.out.println("9-----------------------");
        for(Course course : foundStudent.getCourseList()) {
            System.out.println(course);
        }






    }

    private static int checkTestData() {

        EntityManager en = EntityManagerUtils.getEntityManager("mysqlPU");
        return en.createQuery("from Student", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("recep", LocalDate.of(1993,11,3),"kasımpasa","E");
        Student student2 = new Student("ali", LocalDate.of(1994,12,2),"inönü","E");
        Student student3 = new Student("veli", LocalDate.of(1995,10,5),"kadıköy","E");


        Course course1 = new Course("java","00",123);
        Course course2 = new Course(".net","11",456);
        Course course3 = new Course("python","21",126);

        Instructor perResearcher1 = new PermanentResearcher("ddd","sdfdf","3456",3344);
        Instructor perResercher2 = new PermanentResearcher("ggg","ppp","123",6554);


        Instructor vResercher1 = new VisitingResearcher("fghj","ghj","3456",3344);
        Instructor vResercher2 = new VisitingResearcher("fghj","j","3456",3344);

        student1.getCourseList().add(course1);
        student2.getCourseList().add(course2);
        student3.getCourseList().add(course3);
        student2.getCourseList().add(course1);


        course1.setInstructor(vResercher1);
        course2.setInstructor(perResearcher1);
        course3.setInstructor(vResercher2);



        EntityManager en = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
        en.getTransaction().begin();

        //persist ..
        en.persist(student1);
        en.persist(student2);
        en.persist(student3);
        en.persist(course1);
        en.persist(course2);
        en.persist(course3);

        en.persist(perResearcher1);
        en.persist(perResercher2);
        en.persist(vResercher1);

        en.persist(vResercher2);


        en.getTransaction().commit();


            System.out.println("All data persisted..");
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(en);

        }

    }
}
