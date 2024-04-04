package com.example.food.service;

import com.example.food.dto.Request.UserRequest.UpdatePasswordRequest;
import com.example.food.dto.Request.UserRequest.UpdateUserRequest;
import com.example.food.dto.Response.UserResponse.UserResponse;
import com.example.food.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserResponse banUser(int userId);
    public UserResponse unbanUser(int userId);
    public UserResponse updateUser(int userId, UpdateUserRequest request );
    public UserResponse updatePassword(int userId, UpdatePasswordRequest request );
    public List<User> getALL();
    public List<User> getCustomer();
}
