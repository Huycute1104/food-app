package com.example.food.service;

import com.example.food.dto.Request.CartRequest.AddToCartRequest;
import com.example.food.dto.Response.CartResponse.CartResponse;

public interface CartService {
    public CartResponse addToCart(AddToCartRequest request);
}
