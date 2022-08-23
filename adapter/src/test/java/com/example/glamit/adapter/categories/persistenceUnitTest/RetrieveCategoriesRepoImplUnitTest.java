package com.example.glamit.adapter.categories.persistenceUnitTest;

import category.model.Category;
import com.example.glamit.adapter.data.categories.model.CategoryEntity;
import com.example.glamit.adapter.data.categories.repositoryCRUD.IFindAllCategoriesCRUD;
import com.example.glamit.adapter.data.categories.repositoryImpl.RetrieveCategoriesRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RetrieveCategoriesRepoImplUnitTest {


    @InjectMocks
    RetrieveCategoriesRepoImpl retrieveCategoriesRepoImpl;

    @Mock
    IFindAllCategoriesCRUD findAllCategoriesCRUD;

    @Spy
    List<CategoryEntity> categoryEntityList = factoryCategory();

    @Test
    public void findAll_ThereAreCategories_ReturnCategoryList() {
        when(findAllCategoriesCRUD.findAll()).thenReturn(categoryEntityList);
        List<Category> productCategories = this.retrieveCategoriesRepoImpl.findAll();
        Assertions.assertEquals(3, productCategories.size());
    }

    @Test
    public void findAll_ThereAreNotCategories_ReturnEmptyList() {
        when(findAllCategoriesCRUD.findAll()).thenReturn(Collections.emptyList());
        List<Category> productCategories = this.retrieveCategoriesRepoImpl.findAll();
        Assertions.assertEquals(0, productCategories.size());
    }


    private List<CategoryEntity> factoryCategory() {
        try {
            List<CategoryEntity> productCategories = new ArrayList<>();
            productCategories.add(new CategoryEntity(1, "fakeCategory1"));
            productCategories.add(new CategoryEntity(2, "fakeCategory2"));
            productCategories.add(new CategoryEntity(3, "fakeCategory3"));
            return productCategories;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
