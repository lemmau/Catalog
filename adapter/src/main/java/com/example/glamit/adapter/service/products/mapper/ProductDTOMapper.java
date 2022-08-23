package com.example.glamit.adapter.service.products.mapper;

import category.exceptions.IncompleteCategoryException;
import com.example.glamit.adapter.service.categories.mapper.CategoryDTOMapper;
import com.example.glamit.adapter.service.products.model.ProductDTO;
import product.exceptions.IncompleteProductException;
import product.model.Product;

public class ProductDTOMapper {

    public static Product DTOToCore(ProductDTO productDTO) throws IncompleteProductException, IncompleteCategoryException {
        if(productDTO!=null)
            return Product.makeProduct(productDTO.getSku(),productDTO.getName(),productDTO.getPrice(),productDTO.getImgURL(),CategoryDTOMapper.DTOToCore(productDTO.getCategory()));
        return null;

    }

    public static ProductDTO CoreToDTO(Product product) {
        if(product!=null) {
            return new ProductDTO(product.getSku(), product.getName(), product.getPrice(), product.getImgURL(),
                    CategoryDTOMapper.CoreToDTO(product.getCategory()));
        }
        return null;
    }
}
