package com.Nil.Electronic.Shop.service.ServiceImpl;

import com.Nil.Electronic.Shop.dto.CategoryDto;
import com.Nil.Electronic.Shop.dto.PageableResponse;
import com.Nil.Electronic.Shop.entity.Category;
import com.Nil.Electronic.Shop.exception.ResourceNotFoundException;
import com.Nil.Electronic.Shop.helper.Helper;
import com.Nil.Electronic.Shop.repository.CategoryRepository;
import com.Nil.Electronic.Shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;

import java.awt.print.Pageable;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category saveCategory = categoryRepository.save(category);
        return mapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        Category category1 = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category Not Found Exception"));
        category1.setCategory(categoryDto.getCategoryId());
        category1.setTitle(categoryDto.getTitle());
        category1.setDescription(categoryDto.getDescription());
        category1.setCoverImage(categoryDto.getCoverImage());
        Category updateCategory = categoryRepository.save(category1);
        return mapper.map(updateCategory, CategoryDto.class);
        return null;
    }

    @Override
    public void delete(String categoryId) {
        Category category1 = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category Not Found Exception"));
        categoryRepository.delete(category1);
    }

    @Override
    public PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort= (sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        PageRequest page= PageRequest.of(pageNumber,pageSize,sort);
        Page<Category> All =categoryRepository.findAll(pageable);

        PageableResponse <CategoryDto> pageableResponse=Helper.getPageableResponse(page, CategoryDto.class);
        return pageableResponse;
    }

    @Override
    public CategoryDto get(String categoryId) {

        return null;
    }
}
