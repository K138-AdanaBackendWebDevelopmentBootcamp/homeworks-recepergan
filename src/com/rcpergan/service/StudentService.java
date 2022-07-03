package com.rcpergan.service;

import com.rcpergan.model.Student;
import com.rcpergan.repository.CrudRepository;
import com.rcpergan.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {

    EntityManager en = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Student> findAll() {
        List<Student> studentList = en.createQuery("SELECT c FROM Student c", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return en.find(Student.class,id);
    }



    @Override
    public void saveToDatabase(Student customer) {

        try {
            en.getTransaction().begin();
            en.persist(customer);
            en.getTransaction().commit();
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(en);
        }

    }

    @Override
    public void deleteFromDatabase(Student student) {

        try {
            en.getTransaction().begin();
            en.remove(student);
            en.getTransaction().commit();
            System.out.println("Deleted ...");
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(en);
        }
    }

    @Override
    public void deleteFromDatabaseById(int id) {

    }

    @Override
    public void updateOnDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            en.getTransaction().begin();
            Student foundStudent = findById(id);
            en.remove(foundStudent);
            en.getTransaction().commit();
            System.out.println("Deleted ...");
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(en);
        }
    }

        @Override
    public void deleteCustomerWithId(int id) {
        try {
            en.getTransaction().begin();
            en.createQuery("FROM Student s WHERE s.id =: sudId",Student.class).setParameter("sudId",id).getSingleResult();
            en.getTransaction().commit();
            System.out.println("Deleted ...");
        } catch (Exception e) {
            en.getTransaction().rollback();
        } finally {
            // EntityManagerUtils.closeEntityManager(en);
        }
    }
}