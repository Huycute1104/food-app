package com.example.food.cotroller;

import com.example.food.auth.AuthenticationRequest;
import com.example.food.auth.AuthenticationResponse;
import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.service.CategoryService;
import com.example.food.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    //    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }
}
