package com.example.glamit.adapter.service.products.endpoint;

import category.exceptions.IncompleteCategoryException;
import com.example.glamit.adapter.service.products.mapper.ProductDTOMapper;
import com.example.glamit.adapter.service.products.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.exceptions.ExistingProductException;
import product.exceptions.IncompleteProductException;
import product.input.CreateProductInput;

@RestController
@RequestMapping("/catalog")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class CreateProductEndPoint {

    private CreateProductInput createProductInput;
    public CreateProductEndPoint(CreateProductInput createProductInput) {
        this.createProductInput = createProductInput;
    }

    @PostMapping(value = "products")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO aProduct) {
        ResponseEntity responseEntity=null;
        try {
            boolean result=this.createProductInput.createProduct(ProductDTOMapper.DTOToCore(aProduct));
            if(result) return responseEntity.status(HttpStatus.OK).body(true);
            return responseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        } catch (ExistingProductException e) {
            return responseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        } catch (IncompleteProductException | IncompleteCategoryException iex) {
            return responseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(iex.getMessage());
        } catch ( Exception ex) {
            return responseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
