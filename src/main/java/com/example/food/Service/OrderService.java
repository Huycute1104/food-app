package com.example.food.Service;

import com.example.food.ViewModel.Request.OrderRequest.CreateOrderRequest;
import com.example.food.ViewModel.Response.OrderResponse.OrderResponse;
import com.example.food.Model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();
    public List<Order> getOrderOfUser(int customerId);
    public OrderResponse createOrder(CreateOrderRequest request);
}
