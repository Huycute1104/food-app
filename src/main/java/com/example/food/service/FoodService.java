package com.example.food.service;

import com.example.food.dto.Request.FoodRequest.CreateFoodRequest;
import com.example.food.dto.Request.FoodRequest.UpdateFoodRequest;
import com.example.food.dto.Response.FoodResponse.FoodResponse;
import com.example.food.model.Food;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    public List<Food> getAll();
    public Optional<Food> getFoodByID(int id);
    public FoodResponse createFood(CreateFoodRequest request, MultipartFile file);
    public FoodResponse updateFood(int foodId,UpdateFoodRequest request, MultipartFile file);
    public FoodResponse deleteFood(int foodId);
}
