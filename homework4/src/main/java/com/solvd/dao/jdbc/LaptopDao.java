package com.solvd.dao.jdbc;

import com.solvd.dao.ILaptopDao;
import com.solvd.model.Laptops;

import java.util.List;

public class LaptopDao implements ILaptopDao {

    @Override
    public Laptops getEntityById(int index) {
        return null;
    }

    @Override
    public List<Laptops> getEntities() {
        return List.of();
    }

    @Override
    public void insert(Laptops laptops) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Laptops laptops) {

    }
}
