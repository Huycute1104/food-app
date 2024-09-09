package com.example.food.Service.IService;

import com.example.food.ViewModel.Request.CartRequest.AddToCartRequest;
import com.example.food.ViewModel.Request.CartRequest.UpdateCartRequest;
import com.example.food.ViewModel.Response.CartResponse.CartResponse;
import com.example.food.Model.Cart;

import java.util.List;

public interface ICartService {
    public CartResponse addToCart(AddToCartRequest request);
    public CartResponse updateCart(int cartId,UpdateCartRequest request);
    public CartResponse deleteCartItem(int cartId);
    public List<Cart> getCartByUser(int userId);
}
