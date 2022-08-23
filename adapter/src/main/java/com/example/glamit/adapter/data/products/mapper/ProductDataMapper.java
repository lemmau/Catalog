package com.example.glamit.adapter.data.products.mapper;

import com.example.glamit.adapter.data.categories.mapper.CategoryDataMapper;
import com.example.glamit.adapter.data.products.model.ProductEntity;
import product.exceptions.IncompleteProductException;
import product.model.Product;


public class ProductDataMapper {

    public static Product DataToCore(ProductEntity productEntity) {
        try {
            return Product.makeProduct(productEntity.getSku(),productEntity.getName(),productEntity.getPrice(),productEntity.getImgURL(),
                    CategoryDataMapper.DataToCore(productEntity.getCategory()));
        } catch (IncompleteProductException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ProductEntity CoreToData(Product product) {
        if(product!=null) {
            return new ProductEntity(product.getSku(), product.getName(), product.getPrice(), product.getImgURL(),
                    CategoryDataMapper.CoreToData(product.getCategory()));
        }
        return null;
    }

}
