package com.solvd.dao;

import com.solvd.model.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao extends IBaseDao<Student> {

    @Select(
            "select * from mydb.Students where studentId = #{index}")
    @Results(value = {
            @Result(property="firstName", column = "firstName"),
            @Result(property="lastName", column = "lastName"),
            @Result(property="email", column = "email"),
            @Result(property="phone", column = "phone"),
    })

    @Override
    Student getEntityById(int index);

    @Override
    List<Student> getEntities();

    @Override
    void insert(Student student);

    @Override
    void delete(int index);

    @Override
    void update(int index, Student student);
}
