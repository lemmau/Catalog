package com.example.glamit.adapter.data.products.repositoryImpl;

import com.example.glamit.adapter.data.products.mapper.ProductDataMapper;
import com.example.glamit.adapter.data.products.repositoryCRUD.IFindAllProductsCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import product.model.Product;
import product.output.IRetrieveProductsRepository;


import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RetrieveProductsRepoImpl implements IRetrieveProductsRepository {

    @Autowired
    IFindAllProductsCRUD findAllProductsCRUD;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll(Integer pageSize, Integer offset, String sku) {
        Pageable page= PageRequest.of(offset,pageSize);
        return this.findAllProductsCRUD.findAllBySkuContains(sku, page).stream().map(ProductDataMapper::DataToCore).collect(Collectors.toList());
    }
}
