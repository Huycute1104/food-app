package com.example.food.dto.Response.CategoryResponse;

import com.example.food.model.Category;
import com.example.food.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private String status;
    private Category category;
}
