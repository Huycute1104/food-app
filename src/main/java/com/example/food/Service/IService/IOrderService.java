package com.example.food.Service.IService;

import com.example.food.ViewModel.Request.OrderRequest.CreateOrderRequest;
import com.example.food.ViewModel.Response.OrderResponse.OrderResponse;
import com.example.food.Model.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> getAllOrder();
    public List<Order> getOrderOfUser(int customerId);
    public OrderResponse createOrder(CreateOrderRequest request);
}
