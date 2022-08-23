package com.example.glamit.adapter.categories.endpointUnitTest;

import category.input.RetrieveCategoriesInput;
import category.model.Category;
import com.example.glamit.adapter.service.categories.endpoint.GetCategoriesEndpoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetCategoriesEndpointUnitTest {

    @Mock
    RetrieveCategoriesInput retrieveCategoriesInput;

    @Spy
    List<Category> categoryList = factoryCategories();

    @Test
    public void getCategories_ThereAreCategories_Return200() {
        GetCategoriesEndpoint getCategoriesEndpoint = new GetCategoriesEndpoint(retrieveCategoriesInput);
        when(retrieveCategoriesInput.retrieveAll()).thenReturn(categoryList);
        ResponseEntity responseEntity = getCategoriesEndpoint.getCategories();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getCategories_ThereAreNotCategories_Return204() {
        GetCategoriesEndpoint getCategoriesEndpoint = new GetCategoriesEndpoint(retrieveCategoriesInput);
        when(retrieveCategoriesInput.retrieveAll()).thenReturn(new ArrayList<>());
        ResponseEntity responseEntity = getCategoriesEndpoint.getCategories();
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

    }

    private List<Category> factoryCategories() {
        try {
            List<Category> categoryList = new ArrayList<>();
            categoryList.add(Category.makeCategory(1, "fakeCategory1"));
            categoryList.add(Category.makeCategory(2, "fakeCategory2"));
            categoryList.add(Category.makeCategory(3, "fakeCategory3"));
            return categoryList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
