package com.example.food.cotroller;

import com.example.food.model.Order;
import com.example.food.model.User;
import com.example.food.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("")
    //    @PreAuthorize("hasAuthority('admin:read')")
    public List<Order> getAllUsers() {
        return orderService.getAllOrder();
    }
}
