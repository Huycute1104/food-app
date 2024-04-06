package com.example.food.serviceImplement;

import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.dto.Response.FoodResponse.FoodResponse;
import com.example.food.model.Category;
import com.example.food.repository.CategoryRepo;
import com.example.food.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> getCategoryByID(int id) {
        return categoryRepo.findCategoriesByCategoryId(id);
    }

    @Override
    public CategoryResponse deleteCategory(int id) {
        var food = categoryRepo.findCategoriesByCategoryId(id).orElse(null);
        if (food == null) {
            return CategoryResponse.builder()
                    .status("Food not found")
                    .category(null)
                    .build();
        }else{
            categoryRepo.delete(food);
            return CategoryResponse.builder()
                    .status("Food deleted successfully")
                    .category(null)
                    .build();
        }
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        //get category name
        String name = request.getCategoryName();
        //check exist category
        var category = categoryRepo.findCategoriesByCategoryName(name).orElse(null);
        if (category == null) {
            if (isValidName(name)) {
                Category cate = Category.builder()
                        .categoryName(name)
                        .build();
                categoryRepo.save(cate);
                return CategoryResponse.builder()
                        .status("Create new category successfully")
                        .category(cate)
                        .build();
            }else{
                return CategoryResponse.builder()
                        .status("The Category Name must be between 3 and 20 char and should not contain any special characters.")
                        .category(null)
                        .build();
            }

        } else {
            return CategoryResponse.builder()
                    .status("Category is exist")
                    .category(null)
                    .build();
        }
    }

    private boolean isValidName(String name) {
        //Check validate category name
        return name != null && name.length() <= 20 && name.length() >= 3 && !name.matches(".*[^a-zA-Z0-9].*");
    }

    @Override
    public CategoryResponse updateCategory(CreateCategoryRequest request, int ID) {
        //get category name
        String name = request.getCategoryName();
        //check exist category
        var category = categoryRepo.findCategoriesByCategoryId(ID).orElse(null);
        if (category != null) {
            if (isValidName(name)) {
                category.setCategoryName(name);
                categoryRepo.save(category);
                return CategoryResponse.builder()
                        .status("Update category successfully")
                        .category(category)
                        .build();
            } else {
                return CategoryResponse.builder()
                        .status("The Category Name must be between 3 and 20 char and should not contain any special characters.")
                        .category(null)
                        .build();
            }
        } else {
            return CategoryResponse.builder()
                    .status("Category not found")
                    .category(null)
                    .build();
        }
    }


}
