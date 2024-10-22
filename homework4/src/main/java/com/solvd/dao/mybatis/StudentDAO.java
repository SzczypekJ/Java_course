package com.solvd.dao.mybatis;

import com.solvd.MyBatisConf;
import com.solvd.dao.IStudentDao;
import com.solvd.model.Student;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.List;

public class StudentDAO implements IStudentDao {
    //Interface
    static SqlSessionFactory sqlSessionFactory
            = MyBatisConf.buildqlSessionFactory();

    //XML
//    static SqlSessionFactory sqlSessionFactory
//            = MyBatisConf.buildqlSessionFactory();
    @Override
    public Student getEntityById(int index) {
        //Interface
        try(SqlSession session = sqlSessionFactory.openSession()) {
            Student student = session.selectOne("com.solvd.dao.IStudentDao.getEntityById", index);
            return student;
        }

        //XML
//        try(SqlSession session = sqlSessionFactory.openSession()) {
//            Student student = session.selectOne("StudentMapper.getEntityById", index);
//            return student;
//        }
    }

    @Override
    public List<Student> getEntities() {
        return null;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Student student) {

    }
}
