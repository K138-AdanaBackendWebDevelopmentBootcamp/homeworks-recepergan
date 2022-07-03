package com.rcpergan.clients;

import com.rcpergan.model.Course;
import com.rcpergan.model.Instructor;
import com.rcpergan.model.PermanentInstructor;
import com.rcpergan.model.Student;
import com.rcpergan.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class TestInsuranceClient {

    public static void main(String[] args) {

        if(checkTestData() == 0) {
            saveTestData();
        }
    }

    private static int checkTestData() {

        EntityManager en = EntityManagerUtils.getEntityManager("mysqlPU");
        return en.createQuery("from Student", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("recep", LocalDate.of(1,1,1),"fat","E");
        Student student2 = new Student("recep", LocalDate.of(1,1,1),"fat","E");
        Student student3 = new Student("recep", LocalDate.of(1,1,1),"fat","E");


        Course course1 = new Course("java","re",123);
        Course course2 = new Course("trr","hh",123);

        Instructor perInstructor1 = new PermanentInstructor("ddd","sdfdf","3456",3344);
        Instructor perInstructor2 = new PermanentInstructor("ggg","ppp","123",6554);


        Instructor vInstructor1 = new PermanentInstructor("fghj","ghj","3456",3344);
        Instructor vInstructor2 = new PermanentInstructor("fghj","j","3456",3344);

        course1.setInstructor(perInstructor1);
        course2.setInstructor(perInstructor2);

        vInstructor1.getStudentList().add(course1);
        vInstructor2.getStudentList().add(course2);


        EntityManager en = EntityManagerUtils.getEntityManager("mysqlPU");

        en.getTransaction().begin();

        //persist ..
        en.persist(student1);
        en.persist(student2);
        en.persist(student3);
        en.persist(course1);
        en.persist(course2);

        en.persist(perInstructor1);
        en.persist(perInstructor2);
        en.persist(vInstructor1);

        en.persist(vInstructor2);


        en.getTransaction().commit();

        try {
            System.out.println("All data persisted..");
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(en);

        }

    }
}
