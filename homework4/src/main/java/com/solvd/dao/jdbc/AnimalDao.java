package com.solvd.dao.jdbc;

import com.solvd.dao.IAnimalDao;
import com.solvd.model.Animal;

import java.util.List;

public class AnimalDao implements IAnimalDao {
    @Override
    public Animal getEntityById(int index) {
        return null;
    }

    @Override
    public List<Animal> getEntities() {
        return List.of();
    }

    @Override
    public void insert(Animal animal) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Animal animal) {

    }
}
