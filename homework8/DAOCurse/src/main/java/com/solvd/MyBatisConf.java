package com.solvd;


import com.solvd.dao.IStudentDAO;
import com.solvd.dao.mybatis.LibraryMapper;
import com.solvd.dao.mybatis.StudentMyBatis;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class MyBatisConf {

    public static SqlSessionFactory buildqlSessionFactory() {
        ResourceBundle resource = ResourceBundle.getBundle("database");

        PooledDataSource dataSource = new PooledDataSource(resource.getString("driver"),
                resource.getString("url"),
                resource.getString("username"),
                resource.getString("password"));

        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);

        configuration.addMapper(com.solvd.dao.mybatis.StudentMyBatis.class);
        configuration.addMapper(LibraryMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        return builder.build(configuration);
    }

    public static SqlSessionFactory buildFactoryXml() {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
