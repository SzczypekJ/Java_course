package com.solvd.service;

import com.solvd.dao.IStudentDao;
import com.solvd.dao.jdbc.StudentDao;
import com.solvd.dao.mybatis.StudentDAO;

import java.util.ResourceBundle;

public class StudentService {

    public static IStudentDao getStudentSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new StudentDao();
        } else {
            return new StudentDAO();
        }
    }
}
