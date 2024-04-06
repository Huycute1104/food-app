package com.example.food.service;

import com.example.food.dto.Request.FoodRequest.CreateFoodRequest;
import com.example.food.dto.Request.FoodRequest.UpdateFoodRequest;
import com.example.food.dto.Response.FoodResponse.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {
    public FoodResponse createFood(CreateFoodRequest request, MultipartFile file);
    public FoodResponse updateFood(int foodId,UpdateFoodRequest request, MultipartFile file);
}
