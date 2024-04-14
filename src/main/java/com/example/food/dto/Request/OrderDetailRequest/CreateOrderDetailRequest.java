package com.example.food.dto.Request.OrderDetailRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {
    private int foodId;
    private double price;
    private int quantity;
    private  int orderId;

}
