package com.example.glamit.adapter.service.products.endpoint;

import com.example.glamit.adapter.service.products.mapper.ProductDTOMapper;
import com.example.glamit.adapter.service.products.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.input.RetrieveProductsInput;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class GetProductsController {
    private RetrieveProductsInput retrieveProductsInput;

    public GetProductsController(RetrieveProductsInput retrieveProductsInput) {
        this.retrieveProductsInput = retrieveProductsInput;
    }

    @GetMapping(value = "products")
    public ResponseEntity<?> getProducts(@RequestParam(name="pagesize", defaultValue = "3") Integer pageSize,
                                      @RequestParam(name="offset", defaultValue = "0") Integer offset,
                                      @RequestParam(name="sku", defaultValue = "") String sku) {



        ResponseEntity responseEntity=null;
        if(pageSize<0 || offset<0){
            return responseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body("Only positive numbers are allowed");
        }
        try {
            List<ProductDTO> productDTOList = retrieveProductsInput.retrieveAll(pageSize, offset, sku).stream().map(ProductDTOMapper::CoreToDTO).collect(Collectors.toList());
            if(productDTOList.isEmpty()) return responseEntity.status(HttpStatus.NO_CONTENT).body("Empty List");
            return responseEntity.status(HttpStatus.OK).body(productDTOList);
        }
        catch (Exception ex){
            return responseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
