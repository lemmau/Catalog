package com.example.glamit.adapter.data.products.model;

import category.model.Category;
import com.example.glamit.adapter.data.categories.model.CategoryEntity;

import javax.persistence.*;

@Entity(name = "products")
public class ProductEntity {

    @Id
    private String sku;
    private String name;
    private Double price;
    private String imgurl;

    @ManyToOne(cascade=CascadeType.ALL)
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(String sku, String name, Double price, String imgURL, CategoryEntity category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.imgurl = imgURL;
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgURL() {
        return imgurl;
    }

    public CategoryEntity getCategory() {
        return category;
    }
}
