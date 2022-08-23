package com.example.glamit.adapter.data.categories.repositoryCRUD;

import com.example.glamit.adapter.data.categories.model.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFindAllCategoriesCRUD extends CrudRepository<CategoryEntity,Integer> {
    List<CategoryEntity> findAll();
}
