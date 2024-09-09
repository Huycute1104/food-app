package com.example.food.ViewModel.Response.CategoryResponse;

import com.example.food.Model.Category;
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
