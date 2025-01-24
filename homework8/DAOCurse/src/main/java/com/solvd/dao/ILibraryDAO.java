package com.solvd.dao;

import com.solvd.model.Library;
import com.solvd.model.School;

import java.util.List;

public interface ILibraryDAO extends IBaseDao<Library>{
    @Override
    Library getEntityById(int id);

    @Override
    List<Library> getEntities();

    @Override
    void insert(Library library);

    @Override
    void update(int id, Library library);

    @Override
    void delete(int id);
}
