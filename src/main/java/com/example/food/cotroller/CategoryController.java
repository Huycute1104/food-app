package com.example.food.cotroller;

import com.example.food.auth.AuthenticationRequest;
import com.example.food.auth.AuthenticationResponse;
import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Request.UserRequest.UpdateUserRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.dto.Response.UserResponse.UserResponse;
import com.example.food.model.Category;
import com.example.food.model.User;
import com.example.food.service.CategoryService;
import com.example.food.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<Category> getAllUsers() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<Category> getCategoryByID(@PathVariable int id) {
        return categoryService.getCategoryByID(id);
    }
    @PostMapping("")
    //    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<CategoryResponse> updateUser(
            @PathVariable int id,
            @RequestBody CreateCategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(request,id));
    }

}
