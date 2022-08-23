package com.example.glamit.adapter.data.products.repositoryImpl;

import com.example.glamit.adapter.data.products.mapper.ProductDataMapper;
import com.example.glamit.adapter.data.products.repositoryCRUD.ICreateProductCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import product.model.Product;
import product.output.ICreateProductRepository;

@Repository
public class CreateProductRepositoryRepoImpl implements ICreateProductRepository {

    @Autowired
    ICreateProductCRUD createProductCRUD;

    @Override
    public boolean existBySKU(String sku) {
        return createProductCRUD.existsBySku(sku);
    }

    @Override
    public boolean save(Product product) {
        try {
            if (product != null) {
                createProductCRUD.save(ProductDataMapper.CoreToData(product));
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
