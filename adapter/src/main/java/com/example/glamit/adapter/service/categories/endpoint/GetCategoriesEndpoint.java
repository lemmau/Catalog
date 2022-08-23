package com.example.glamit.adapter.service.categories.endpoint;

import category.input.RetrieveCategoriesInput;
import com.example.glamit.adapter.service.categories.mapper.CategoryDTOMapper;
import com.example.glamit.adapter.service.categories.model.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET})
public class GetCategoriesEndpoint {
    private RetrieveCategoriesInput retrieveCategoriesInput;

    public GetCategoriesEndpoint(RetrieveCategoriesInput retrieveCategoriesInput) {
        this.retrieveCategoriesInput = retrieveCategoriesInput;
    }

    @GetMapping(value = "categories")
    public ResponseEntity<?> getCategories() {
        ResponseEntity responseEntity=null;
        try {
            List<CategoryDTO> categoryList=retrieveCategoriesInput.retrieveAll().stream().map(CategoryDTOMapper::CoreToDTO).collect(Collectors.toList());
            if (!categoryList.isEmpty()){
                return responseEntity.status(HttpStatus.OK).body(categoryList);
            }
            return responseEntity.status(HttpStatus.NO_CONTENT).body(Collections.EMPTY_LIST);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return responseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }
}
