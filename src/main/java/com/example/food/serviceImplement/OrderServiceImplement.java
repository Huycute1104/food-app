package com.example.food.serviceImplement;

import com.example.food.model.Order;
import com.example.food.repository.OrderRepo;
import com.example.food.repository.UserRepo;
import com.example.food.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getOrderOfUser(int customerId) {
        var user = userRepo.findUserByUsersID(customerId).orElse(null);
        if(user != null){
            return orderRepo.findOrderByUser(user);
        }
        else {
            return new ArrayList<>();
        }
    }
}
