package com.example.glamit.adapter.products.endpointUnitTest;

import category.model.Category;
import com.example.glamit.adapter.service.products.endpoint.GetProductsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import product.input.RetrieveProductsInput;
import product.model.Product;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetProductsEndpointUnitTest {

    @Mock
    RetrieveProductsInput retrieveProductsInput;

    @Spy
    List<Product> productList=productsFactory();

    @Test
    public void retrieveProducts_ThereAreProducts_return200(){
        GetProductsController getAllProductsController = new GetProductsController(retrieveProductsInput);
        when(retrieveProductsInput.retrieveAll(3, 0,"")).thenReturn(productList);
        ResponseEntity responseEntity = getAllProductsController.getProducts(3, 0, "");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void retrieveProducts_ThereAreNotProducts_return204(){
        GetProductsController getAllProductsController = new GetProductsController(retrieveProductsInput);
        when(retrieveProductsInput.retrieveAll(3, 0,"")).thenReturn(Collections.emptyList());
        ResponseEntity responseEntity = getAllProductsController.getProducts(3, 0, "");
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }


    private List<Product> productsFactory() {
        try {
            List<Product> categoryList = new ArrayList<>();
            categoryList.add(Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            categoryList.add(Product.makeProduct("2", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            categoryList.add(Product.makeProduct("3", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
            return categoryList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
