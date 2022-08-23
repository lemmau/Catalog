package com.example.glamit.adapter;

import category.exceptions.IncompleteCategoryException;
import category.model.Category;
import com.example.glamit.adapter.service.products.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import product.exceptions.ExistingProductException;
import product.exceptions.IncompleteProductException;
import product.input.CreateProductInput;
import product.model.Product;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
	}


	@Autowired
	CreateProductInput createProductInput;

	@PostConstruct
	void preLoadProducts() throws IncompleteCategoryException, IncompleteProductException, ExistingProductException {
		createProductInput.createProduct(Product.makeProduct("1", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
		createProductInput.createProduct(Product.makeProduct("2", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));
		createProductInput.createProduct(Product.makeProduct("3", "fakeName", 100.0, "http://fake.url", Category.makeCategory(1, "fakeCategory")));

	}

}
