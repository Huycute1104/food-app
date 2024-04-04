package com.example.food.service;

import com.example.food.dto.Request.UserRequest.UpdatePasswordRequest;
import com.example.food.dto.Request.UserRequest.UpdateUserRequest;
import com.example.food.dto.Response.UserResponse.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserResponse banUser(int userId);
    public UserResponse unbanUser(int userId);
    public UserResponse updateUser(int userId, UpdateUserRequest request );
    public UserResponse updatePassword(int userId, UpdatePasswordRequest request );
}
