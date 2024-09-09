package com.example.food.Service.IService;

import com.example.food.ViewModel.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.ViewModel.Response.CategoryResponse.CategoryResponse;
import com.example.food.Model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public CategoryResponse createCategory(CreateCategoryRequest request);
    public CategoryResponse updateCategory(CreateCategoryRequest request , int ID);

    public List<Category> getAllCategory();

    public Optional<Category> getCategoryByID(int id);
    public CategoryResponse deleteCategory(int id);
}
