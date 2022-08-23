package com.example.glamit.adapter.data.categories.mapper;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import com.example.glamit.adapter.data.categories.model.CategoryEntity;

public class CategoryDataMapper {

    public static Category DataToCore(CategoryEntity categoryEntity) {
        try {
            return Category.makeCategory(categoryEntity.getId(), categoryEntity.getName());
        } catch (IncompleteCategoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CategoryEntity CoreToData(Category category) {
        if(category!=null) {
            return new CategoryEntity(category.getId(), category.getName());
        }
        return null;
    }

}
