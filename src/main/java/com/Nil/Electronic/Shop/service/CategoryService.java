package com.Nil.Electronic.Shop.service;

import com.Nil.Electronic.Shop.dto.CategoryDto;
import com.Nil.Electronic.Shop.dto.PageableResponse;

public interface CategoryService {

    //	create
    CategoryDto create(CategoryDto categoryDto);

    //	uppdate
    CategoryDto update (CategoryDto categoryDto, String categoryId);

    //	delete
    void delete(String categoryId);

    //	get Alll Category
    PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    //	get single category detail
    CategoryDto get(String categoryId);
}
