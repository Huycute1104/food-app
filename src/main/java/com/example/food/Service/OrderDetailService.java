package com.example.food.Service;

import com.example.food.ViewModel.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.food.ViewModel.Response.OrderDetailResponse.OrderDetailResponse;

public interface OrderDetailService {
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest request);
}
