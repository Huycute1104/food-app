package com.example.food.serviceImplement;

import com.example.food.dto.Request.OrderDetailRequest.CreateOrderDetailRequest;
import com.example.food.dto.Response.OrderDetailResponse.OrderDetailResponse;
import com.example.food.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImplement implements OrderDetailService {
    @Override
    public OrderDetailResponse createOrderDetail(CreateOrderDetailRequest request) {
        return null;
    }
}
