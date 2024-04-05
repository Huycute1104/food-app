package com.example.food.serviceImplement;

import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.model.Category;
import com.example.food.repository.CategoryRepo;
import com.example.food.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        //get category name
        String name = request.getCategoryName();
        //check exist category
        var category = categoryRepo.findCategoriesByCategoryName(name).orElse(null);
        if(category == null){
            Category cate =  Category.builder()
                    .categoryName(name)
                    .build();
            categoryRepo.save(cate);
            return  CategoryResponse.builder()
                    .status("Create new category successfully")
                    .category(cate)
                    .build();
        }else {
            return  CategoryResponse.builder()
                    .status("Category is exist")
                    .category(null)
                    .build();
        }
    }
}
