package com.example.glamit.adapter.products.persistenceUnitTest;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import com.example.glamit.adapter.data.categories.model.CategoryEntity;
import com.example.glamit.adapter.data.products.model.ProductEntity;
import com.example.glamit.adapter.data.products.repositoryCRUD.ICreateProductCRUD;
import com.example.glamit.adapter.data.products.repositoryImpl.CreateProductRepositoryRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import product.exceptions.IncompleteProductException;
import product.model.Product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateProductRepoImplUnitTest {

    @InjectMocks
    CreateProductRepositoryRepoImpl createProductRepoImpl;

    @Mock
    ICreateProductCRUD createProductCRUD;

    @Test
    public void saveProduct_ProductSaved_ReturnTrue() throws IncompleteCategoryException, IncompleteProductException {
        Product product =getFakeProduct();
        when(createProductCRUD.save(any(ProductEntity.class))).thenReturn(new ProductEntity("1", "fakeName", 100.0, "http://fake.url", new CategoryEntity(1, "fakeCategory")));
        Assertions.assertTrue(createProductRepoImpl.save(product));
    }

    @Test
    public void saveProduct_CannotSave_ReturnFalse() throws IncompleteCategoryException, IncompleteProductException {
        Product product = getFakeProduct();
        when(createProductCRUD.save(any(ProductEntity.class))).thenThrow(RuntimeException.class);
        Assertions.assertFalse(createProductRepoImpl.save(product));
    }

    private Product getFakeProduct() throws IncompleteProductException, IncompleteCategoryException {
        return Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory"));
    }
}
