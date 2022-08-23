package com.example.glamit.adapter.service.categories.mapper;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import com.example.glamit.adapter.service.categories.model.CategoryDTO;

public class CategoryDTOMapper {

    public static Category DTOToCore(CategoryDTO categoryDTO) throws IncompleteCategoryException {
        if(categoryDTO!=null)
            return Category.makeCategory(categoryDTO.getId(), categoryDTO.getName());
        return null;
    }

    public static CategoryDTO CoreToDTO(Category category) {
        if(category!=null) {
            return new CategoryDTO(category.getId(), category.getName());
        }
        return null;
    }
}
