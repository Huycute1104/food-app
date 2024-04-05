package com.example.food.service;

import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.model.Category;

import java.util.List;

public interface CategoryService {
    public CategoryResponse createCategory(CreateCategoryRequest request);
    public CategoryResponse updateCategory(CreateCategoryRequest request , int ID);

    public List<Category> getAllCategory();
}
