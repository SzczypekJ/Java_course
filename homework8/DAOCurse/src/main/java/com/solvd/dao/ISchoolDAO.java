package com.solvd.dao;

import com.solvd.model.School;
import com.solvd.model.Student;

import java.util.List;

public interface ISchoolDAO extends IBaseDao<School> {
    @Override
    School getEntityById(int id);

    @Override
    List<School> getEntities();

    @Override
    void insert(School school);

    @Override
    void update(int id, School school);

    @Override
    void delete(int id);
}
