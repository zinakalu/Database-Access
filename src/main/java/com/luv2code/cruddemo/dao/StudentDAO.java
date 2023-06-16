package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
    
    void save(Student theStudent); //used to create student(s)
    Student findById(Integer id); //retrieving data from DB
} //define DAO interface
