package com.example.glamit.adapter.service.categories.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {

    private Integer id;
    private String name;

    public CategoryDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
