package com.example.food.ViewModel.Request.FoodRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {
    private String foodName;
    private String foodImage;
    private String description;
    private double price;
    private LocalDateTime dateAt;
    private int quantity;
    private int category;

}
