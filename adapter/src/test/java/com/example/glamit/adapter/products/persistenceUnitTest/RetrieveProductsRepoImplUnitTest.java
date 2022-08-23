package com.example.glamit.adapter.products.persistenceUnitTest;

import com.example.glamit.adapter.data.categories.model.CategoryEntity;
import com.example.glamit.adapter.data.products.model.ProductEntity;
import com.example.glamit.adapter.data.products.repositoryCRUD.IFindAllProductsCRUD;
import com.example.glamit.adapter.data.products.repositoryImpl.RetrieveProductsRepoImpl;
import org.springframework.data.domain.Pageable;
import product.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RetrieveProductsRepoImplUnitTest {


    @InjectMocks
    RetrieveProductsRepoImpl retrieveProductsRepoImpl;

    @Mock
    IFindAllProductsCRUD findAllProductsCRUD;

    @Spy
    List<ProductEntity> productEntityList = factoryProduct();

    @Test
    public void findAll_ExistProducts_ReturnProductList() {
        when(findAllProductsCRUD.findAllBySkuContains(any(String.class),any(Pageable.class))).thenReturn(productEntityList);
        List<Product> productProducts = (List<Product>) this.retrieveProductsRepoImpl.findAll(3,0,"");
        Assertions.assertEquals(3, productProducts.size());
    }

    @Test
    public void findAll_NotExistProducts_ReturnEmptyList() {
        when(findAllProductsCRUD.findAllBySkuContains(any(String.class),any(Pageable.class))).thenReturn(new ArrayList<>());
        List<Product> productProducts = (List<Product>) this.retrieveProductsRepoImpl.findAll(3,0,"");
        Assertions.assertEquals(0, productProducts.size());
    }


    private List<ProductEntity> factoryProduct() {
        try {
            List<ProductEntity> productProducts = new ArrayList<>();
            productProducts.add(new ProductEntity("1", "fakeName", 100.0, "http://fake.url", new CategoryEntity(1, "fakeCategory")));
            productProducts.add(new ProductEntity("2", "fakeName", 100.0, "http://fake.url", new CategoryEntity(1, "fakeCategory")));
            productProducts.add(new ProductEntity("3", "fakeName", 100.0, "http://fake.url", new CategoryEntity(1, "fakeCategory")));
            return productProducts;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
