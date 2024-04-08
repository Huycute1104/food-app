package com.example.food.repository;

import com.example.food.model.Order;
import com.example.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findOrderByUser(User user);
}
