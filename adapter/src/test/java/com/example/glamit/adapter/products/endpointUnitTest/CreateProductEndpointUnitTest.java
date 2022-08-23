package com.example.glamit.adapter.products.endpointUnitTest;

import com.example.glamit.adapter.service.categories.model.CategoryDTO;
import com.example.glamit.adapter.service.products.endpoint.CreateProductEndPoint;
import com.example.glamit.adapter.service.products.model.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import product.exceptions.ExistingProductException;

import product.input.CreateProductInput;
import product.model.Product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateProductEndpointUnitTest {

    @Mock
    CreateProductInput createProductInput;

    @Test
    void createProduct_ProductNotExists_ReturnTrue() throws ExistingProductException {
        when(createProductInput.createProduct(any(Product.class))).thenReturn(true);

        CreateProductEndPoint createProductEndPoint=new CreateProductEndPoint(createProductInput);
        ProductDTO aProduct=getFakeProduct();
        ResponseEntity response= createProductEndPoint.createProduct(aProduct);

        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    void createProduct_CannotSave_ReturnFalse() throws ExistingProductException {
        when(createProductInput.createProduct(any(Product.class))).thenReturn(false);

        CreateProductEndPoint createProductEndPoint=new CreateProductEndPoint(createProductInput);
        ProductDTO aProduct=getFakeProduct();
        ResponseEntity response= createProductEndPoint.createProduct(aProduct);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
    }

    @Test
    void createProduct_ProductExists_ExistingProductException() throws ExistingProductException {
        when(createProductInput.createProduct(any(Product.class))).thenThrow(ExistingProductException.class);

        CreateProductEndPoint createProductEndPoint=new CreateProductEndPoint(createProductInput);
        ProductDTO aProduct=getFakeProduct();
        ResponseEntity response= createProductEndPoint.createProduct(aProduct);

        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED,response.getStatusCode());
    }

    private ProductDTO getFakeProduct() {
        return new ProductDTO("1", "fakeName", 100.0, "http://fake.url", new CategoryDTO(1, "fakeCategory"));
    }



}
