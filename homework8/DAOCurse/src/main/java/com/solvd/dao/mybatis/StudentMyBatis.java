package com.solvd.dao.mybatis;

import com.solvd.dao.IStudentDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.solvd.MyBatisConf;
import com.solvd.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMyBatis implements IStudentDAO {

    static SqlSessionFactory sqlSessionFactory = MyBatisConf.buildFactoryXml();

    @Override
    public Student getEntityById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.solvd.dao.mybatis.StudentMapper.getEntityById", id);
        }
    }

    @Override
    public List<Student> getEntities() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.solvd.dao.mybatis.StudentMapper.getEntities");
        }
    }

    @Override
    public void insert(Student student) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.dao.mybatis.StudentMapper.insert", student);
            session.commit();
        }
    }

    @Override
    public void update(int id, Student student) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // Create a map containing both the id and the student object
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("student", student);
            session.update("com.solvd.dao.mybatis.StudentMapper.update", params);
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.dao.mybatis.StudentMapper.delete", id);
            session.commit();
        }
    }
}
