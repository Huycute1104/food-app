package com.example.food.dto.Response.FoodResponse;

import com.example.food.model.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponse {
    private String status;
    private Food food;
}
