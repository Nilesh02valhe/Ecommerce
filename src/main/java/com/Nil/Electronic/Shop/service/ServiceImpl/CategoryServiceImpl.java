package com.Nil.Electronic.Shop.service.ServiceImpl;

import com.Nil.Electronic.Shop.dto.CategoryDto;
import com.Nil.Electronic.Shop.dto.PageableResponse;
import com.Nil.Electronic.Shop.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        return null;
    }

    @Override
    public void delete(String categoryId) {

    }

    @Override
    public PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public CategoryDto get(String categoryId) {
        return null;
    }
}
