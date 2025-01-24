package com.solvd.dao;

import com.solvd.model.Student;

import java.util.List;

public interface IStudentDAO extends IBaseDao<Student>{

    @Override
    Student getEntityById(int id);

    @Override
    List<Student> getEntities();

    @Override
    void insert(Student student);

    @Override
    void update(int id, Student student);

    @Override
    void delete(int id);
}
