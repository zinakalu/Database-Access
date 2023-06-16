package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO {


    //define field for entity manager
    private EntityManager entityManager;


    //inject enetity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional //bc we're performing an update
    public void save(Student theStudent){
        entityManager.persist(theStudent); //saves the student to the DB
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }
    
}

