package com.example.food.Cotroller;

import com.example.food.ViewModel.Request.OrderRequest.CreateOrderRequest;
import com.example.food.ViewModel.Response.OrderResponse.OrderResponse;
import com.example.food.Model.Order;
import com.example.food.Service.IService.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @GetMapping("")
    //    @PreAuthorize("hasAuthority('admin:read')")
    public List<Order> getAllUsers() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<Order> getOrderByUser(@PathVariable int id) {
        return orderService.getOrderOfUser(id);
    }

    @PostMapping("")
//    @PreAuthorize("hasAuthority('customer:create')")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }
}
