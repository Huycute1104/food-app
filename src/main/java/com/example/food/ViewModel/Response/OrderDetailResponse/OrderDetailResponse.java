package com.example.food.ViewModel.Response.OrderDetailResponse;

import com.example.food.Model.OrderDetail;
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
