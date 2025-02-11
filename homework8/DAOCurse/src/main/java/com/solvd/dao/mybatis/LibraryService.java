package com.solvd.service;

import com.solvd.dao.mybatis.LibraryMapper;
import com.solvd.model.Library;
import com.solvd.MyBatisConf;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class LibraryService {

    private SqlSessionFactory sqlSessionFactory = MyBatisConf.buildqlSessionFactory();

    public Library getLibraryById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            return mapper.getEntityById(id);
        }
    }

    public List<Library> getAllLibraries() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            return mapper.getEntities();
        }
    }

    public void addLibrary(Library library) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            mapper.insert(library);
            session.commit();
        }
    }

    public void updateLibrary(int id, Library library) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            mapper.update(id, library);
            session.commit();
        }
    }

    public void deleteLibrary(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            LibraryMapper mapper = session.getMapper(LibraryMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }
}
