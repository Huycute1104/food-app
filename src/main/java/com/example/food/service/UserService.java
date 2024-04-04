package com.example.food.service;

import com.example.food.dto.Response.UserResponse.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserResponse banUser(int userId);
}
