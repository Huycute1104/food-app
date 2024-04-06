package com.example.food.cotroller;

import com.example.food.dto.Request.CategoryRequest.CreateCategoryRequest;
import com.example.food.dto.Request.FoodRequest.CreateFoodRequest;
import com.example.food.dto.Response.CategoryResponse.CategoryResponse;
import com.example.food.dto.Response.FoodResponse.FoodResponse;
import com.example.food.service.FoodService;
import com.example.food.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("")
    //    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<FoodResponse> createFood(
            @RequestParam("foodName") String foodName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("category") int category,
            @RequestParam("file") MultipartFile file) {
        CreateFoodRequest food = CreateFoodRequest.builder()
                .foodName(foodName)
                .description(description)
                .price(price)
                .category(category)
                .build();
        FoodResponse response = foodService.createFood(food,file);
        return ResponseEntity.ok(response);
    }
}
