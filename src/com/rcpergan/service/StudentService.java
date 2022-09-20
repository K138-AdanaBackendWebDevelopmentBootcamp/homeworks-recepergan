package com.rcpergan.service;

import com.rcpergan.model.Course;
import com.rcpergan.model.Student;
import com.rcpergan.repository.CrudRepository;
import com.rcpergan.repository.StudentRepository;
import com.rcpergan.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;


public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {

        List<Student> studentList = em.createQuery("FROM Student ", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void saveToDatabase(Student student) {

        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            //  EntityManagerUtils.closeEntityManager(em);

        }


    }

    @Override
    public void deleteFromDatabase(Student student) {
        try {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
            System.out.println("Deleted...");
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            //  EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();
            Student foundStudent = findById(id);
            em.remove(foundStudent);
            em.getTransaction().commit();
            System.out.println("Deleted");
        }catch (Exception e ) {
            em.getTransaction().rollback();
        }finally {
            //  EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void updateOnDatabase(Student student, String name) {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
            System.out.println("Update...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            //  EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void deleteStudentWithId(int id) {

    }

    @Override
    public List<Course> getStudentCourseList(Student student) {
        Student foundStudent = em.find(Student.class,student.getId());
        return foundStudent.getCourseList();
    }
}