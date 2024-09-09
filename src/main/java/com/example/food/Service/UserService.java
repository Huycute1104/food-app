package com.example.food.Service;

import com.example.food.ViewModel.Request.UserRequest.UpdatePasswordRequest;
import com.example.food.ViewModel.Request.UserRequest.UpdateUserRequest;
import com.example.food.ViewModel.Response.UserResponse.UserResponse;
import com.example.food.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public UserResponse banUser(int userId);
    public UserResponse unbanUser(int userId);
    public UserResponse updateUser(int userId, UpdateUserRequest request );
    public UserResponse updatePassword(int userId, UpdatePasswordRequest request );
    public List<User> getALL();
    public List<User> getCustomer();
    public List<User> getStaff();
    public Optional<User> getUserById(int id);
}
