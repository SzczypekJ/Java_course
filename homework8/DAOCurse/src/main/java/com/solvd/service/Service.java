package com.solvd.service;

import com.solvd.dao.IStudentDAO;
import com.solvd.dao.jdbc.StudentDAO;
import com.solvd.dao.mybatis.StudentMyBatis;

import java.util.ResourceBundle;

public class Service {
    public static IStudentDAO getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if (resourceBundle.getString("type").equals("jdbc")){
            return new StudentDAO();
        } else {
            return new StudentMyBatis();
        }
    }
}
