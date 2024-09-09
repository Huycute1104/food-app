package com.example.food.Service.IService;

import com.example.food.ViewModel.Request.FoodRequest.CreateFoodRequest;
import com.example.food.ViewModel.Request.FoodRequest.UpdateFoodRequest;
import com.example.food.ViewModel.Response.FoodResponse.FoodResponse;
import com.example.food.Model.Food;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IFoodService {
    public List<Food> getAll();
    public Optional<Food> getFoodByID(int id);
    public FoodResponse createFood(CreateFoodRequest request, MultipartFile file);
    public FoodResponse updateFood(int foodId,UpdateFoodRequest request, MultipartFile file);
    public FoodResponse deleteFood(int foodId);
}
