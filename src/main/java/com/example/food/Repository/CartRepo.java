package com.example.food.Repository;

import com.example.food.Model.Cart;
import com.example.food.Model.Food;
import com.example.food.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart,Integer> {
    Optional<Cart> findCartByUserAndFood(User user, Food food);
    Optional<Cart> findCartByCartID(int cartId);
    List<Cart> findByUser(User user);
}
