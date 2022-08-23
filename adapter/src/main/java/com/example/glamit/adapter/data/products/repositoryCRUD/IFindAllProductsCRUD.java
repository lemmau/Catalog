package com.example.glamit.adapter.data.products.repositoryCRUD;

import com.example.glamit.adapter.data.products.model.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFindAllProductsCRUD extends CrudRepository<ProductEntity,String > {
    List<ProductEntity> findAllBySkuContains(String sku,Pageable pageable);
}
