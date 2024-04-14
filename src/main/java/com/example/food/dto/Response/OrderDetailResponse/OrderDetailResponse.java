package com.example.food.dto.Response.OrderDetailResponse;

import com.example.food.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private OrderDetail orderDetail;
    private String status;

}
