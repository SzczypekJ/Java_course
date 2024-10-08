package com.solvd.dao;

import com.solvd.model.Animal;

import java.util.List;

public interface IAnimalDao extends IBaseDao<Animal>{

    @Override
    Animal getEntityById(int index);

    @Override
    List<Animal> getEntities();

    @Override
    void insert(Animal animal);

    @Override
    void delete(int index);

    @Override
    void update(int index, Animal animal);
}
