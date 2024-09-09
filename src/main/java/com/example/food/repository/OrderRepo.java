package com.example.food.repository;

import com.example.food.model.Order;
import com.example.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findOrderByCustomer(User user);
    Optional<Order> findOrderByOrderID(int orderId);
}
