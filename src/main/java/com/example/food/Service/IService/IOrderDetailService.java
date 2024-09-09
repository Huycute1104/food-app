package com.example.food.Service.IService;

import com.example.food.ViewModel.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.food.ViewModel.Response.OrderDetailResponse.OrderDetailResponse;

public interface IOrderDetailService {
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest request);
}
