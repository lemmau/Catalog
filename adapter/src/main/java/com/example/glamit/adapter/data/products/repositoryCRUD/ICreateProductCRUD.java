package com.example.glamit.adapter.data.products.repositoryCRUD;

import com.example.glamit.adapter.data.products.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateProductCRUD extends CrudRepository<ProductEntity,String> {
    boolean existsBySku(String sku);
}
