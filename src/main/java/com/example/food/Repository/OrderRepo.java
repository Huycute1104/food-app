package com.example.food.Repository;

import com.example.food.Model.Order;
import com.example.food.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findOrderByCustomer(User user);
    Optional<Order> findOrderByOrderID(int orderId);
}
