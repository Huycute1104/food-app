package com.example.food.repository;

import com.example.food.model.Food;
import com.example.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food,Integer> {
}
