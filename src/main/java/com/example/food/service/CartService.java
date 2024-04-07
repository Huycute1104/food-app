package com.example.food.service;

import com.example.food.dto.Request.CartRequest.AddToCartRequest;
import com.example.food.dto.Request.CartRequest.UpdateCartRequest;
import com.example.food.dto.Response.CartResponse.CartResponse;

public interface CartService {
    public CartResponse addToCart(AddToCartRequest request);
    public CartResponse updateCart(int cartId,UpdateCartRequest request);
}
