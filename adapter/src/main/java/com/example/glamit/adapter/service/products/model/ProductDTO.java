package com.example.glamit.adapter.service.products.model;

import com.example.glamit.adapter.service.categories.model.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

    private String sku;
    private String name;
    private Double price;
    private String imgURL;
    private CategoryDTO category;


    public ProductDTO(@JsonProperty("sku") String sku,
                      @JsonProperty("name") String name,
                      @JsonProperty("price") Double price,
                      @JsonProperty("imgURL") String imgURL,
                      @JsonProperty("category") CategoryDTO category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
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
        return imgURL;
    }

    public CategoryDTO getCategory() {
        return category;
    }
}
