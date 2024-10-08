package com.solvd.dao;

import com.solvd.model.Laptops;

import java.util.List;

public interface ILaptopDao extends IBaseDao<Laptops> {

    @Override
    Laptops getEntityById(int index);

    @Override
    List<Laptops> getEntities();

    @Override
    void insert(Laptops laptops);

    @Override
    void delete(int index);

    @Override
    void update(int index, Laptops laptops);
}
