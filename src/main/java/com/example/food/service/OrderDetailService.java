package com.example.food.service;

import com.example.food.dto.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.food.dto.Request.OrderRequest.CreateOrderRequest;
import com.example.food.dto.Response.OrderDetailResponse.OrderDetailResponse;
import com.example.food.model.OrderDetail;

public interface OrderDetailService {
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest request);
}
