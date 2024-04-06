package com.example.food.dto.Request.FoodRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFoodRequest {
    private String foodName;
    private String foodImage;
    private String description;
    private double price;
    private int category;
}
