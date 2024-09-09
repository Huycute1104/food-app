package com.example.food.ViewModel.Request.FoodRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodRequest {
    private String foodName;
    private String foodImage;
    private String description;
    private double price;
    private int quantity;
    private int category;
}
