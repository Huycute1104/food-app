package com.example.food.ViewModel.Response.CartResponse;

import com.example.food.Model.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private String status;
    private Cart cart;
}
