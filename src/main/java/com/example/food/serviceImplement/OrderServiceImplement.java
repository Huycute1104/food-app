package com.example.food.serviceImplement;

import com.example.food.model.Order;
import com.example.food.repository.OrderRepo;
import com.example.food.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }
}
