package com.example.glamit.adapter.data.categories.repositoryImpl;

import category.model.Category;
import category.output.IRetrieveCategoriesRepository;
import com.example.glamit.adapter.data.categories.mapper.CategoryDataMapper;
import com.example.glamit.adapter.data.categories.repositoryCRUD.IFindAllCategoriesCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RetrieveCategoriesRepoImpl implements IRetrieveCategoriesRepository {

    @Autowired
    IFindAllCategoriesCRUD findAllCategoriesCRUD;

    @Override
    public List<Category> findAll() {
        return findAllCategoriesCRUD.findAll().stream().map(CategoryDataMapper::DataToCore).collect(Collectors.toList());
    }
}
