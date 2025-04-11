package com.Nil.Electronic.Shop.controller;

import com.Nil.Electronic.Shop.dto.ApiResponceMessage;
import com.Nil.Electronic.Shop.dto.CategoryDto;
import com.Nil.Electronic.Shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto2 = categoryService.create(categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto2, HttpStatus.OK);

    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable String CategoryId
    ){
        CategoryDto update = categoryService.update(categoryDto, CategoryId);
        return new ResponseEntity<CategoryDto> (update,HttpStatus.OK);
    }
    public ResponseEntity<ApiResponceMessage> updateCategory(@PathVariable String categoryId){
        categoryService.delete(categoryId);
        ApiResponceMessage responsemassage = ApiResponceMessage
                .builder()
                .massage("Delete Successfully !!")
                .status(HttpStatus.OK)
                .Success(true)
                .build();
        return new ResponseEntity<ApiResponceMessage>(responsemassage, HttpStatus.OK);
    }
}
