package com.example.food.repository;

import com.example.food.model.Food;
import com.example.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food,Integer> {
    Optional<Food> findFoodByFoodID(int id);
    Optional<Food> findFoodByFoodName(String name);
}
