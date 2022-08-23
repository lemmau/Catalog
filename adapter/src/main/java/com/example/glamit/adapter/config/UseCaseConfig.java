package com.example.glamit.adapter.config;

import category.output.IRetrieveCategoriesRepository;
import category.usecase.RetrieveCategoriesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import product.output.ICreateProductRepository;
import product.output.IRetrieveProductsRepository;
import product.usecase.CreateProductUseCase;
import product.usecase.RetrieveProductsUseCase;

@Configuration
public class UseCaseConfig {

    final
    IRetrieveCategoriesRepository retrieveCategoriesRepository;

    final
    ICreateProductRepository createProductRepository;

    final
    IRetrieveProductsRepository retrieveProductsRepository;

    public UseCaseConfig(IRetrieveCategoriesRepository retrieveCategoriesRepository, ICreateProductRepository createProductRepository, IRetrieveProductsRepository retrieveProductsRepository) {
        this.retrieveCategoriesRepository = retrieveCategoriesRepository;
        this.createProductRepository = createProductRepository;
        this.retrieveProductsRepository = retrieveProductsRepository;
    }


    @Bean
    public RetrieveCategoriesUseCase retrieveCategoriesUseCase(){
        return new RetrieveCategoriesUseCase(retrieveCategoriesRepository);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(){
        return new CreateProductUseCase(createProductRepository);
    }

    @Bean
    public RetrieveProductsUseCase retrieveProductsUseCase(){
        return new RetrieveProductsUseCase(retrieveProductsRepository);
    }
}
