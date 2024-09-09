package com.example.food.ServiceImplement;

import com.example.food.ViewModel.Request.UserRequest.UpdatePasswordRequest;
import com.example.food.ViewModel.Request.UserRequest.UpdateUserRequest;
import com.example.food.ViewModel.Response.UserResponse.UserResponse;
import com.example.food.Enums.Role;
import com.example.food.Model.User;
import com.example.food.Repository.UserRepo;
import com.example.food.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getALL() {
        return userRepo.findAll();
    }

    @Override
    public List<User> getCustomer() {
        List<User> allUsers = userRepo.findAll();
        return allUsers.stream()
                .filter(user -> user.getRole() == Role.CUSTOMER )
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getStaff() {
        List<User> allUsers = userRepo.findAll();
        return allUsers.stream()
                .filter(user -> user.getRole() == Role.STAFF )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findUserByUsersID(id);
    }

    @Override
    public UserResponse banUser(int userId) {
        //find user by userid
        var banUser = userRepo.findUserByUsersID(userId).orElse(null);
//        var banUser = userRepo.findUserByUsersID(userID).orElse(null);
        if (banUser != null) {
            banUser.setUserStatus(false);
            userRepo.save(banUser);
            return UserResponse.builder()
                    .status("Ban User Successful")
                    .user(banUser)
                    .build();
        } else {
            return UserResponse.builder()
                    .status("User Not Found")
                    .user(null)
                    .build();

        }
    }

    @Override
    public UserResponse unbanUser(int userId) {
        //find user by userid
        var unBanUser = userRepo.findUserByUsersID(userId).orElse(null);
        if (unBanUser != null) {
            unBanUser.setUserStatus(true);
            userRepo.save(unBanUser);
            return UserResponse.builder()
                    .status("UnBan User Successful")
                    .user(unBanUser)
                    .build();
        } else {
            return UserResponse.builder()
                    .status("User Not Found")
                    .user(null)
                    .build();

        }
    }

    @Override
    public UserResponse updateUser(int userId, UpdateUserRequest request) {
        //get value from request
        String accountName = request.getAccountName();
        String phone = request.getPhone();
        //find user by id
        var existedUser = userRepo.findUserByUsersID(userId).orElse(null);
        if (existedUser != null) {
            existedUser.setAccountName(accountName);
            existedUser.setPhone(phone);
            userRepo.save(existedUser);
            return UserResponse.builder()
                    .status("Update User Successful")
                    .user(existedUser)
                    .build();
        } else {
            return UserResponse.builder()
                    .status("User Not Found")
                    .user(null)
                    .build();

        }
    }

    private boolean isValidPassword(String password) {
        //Check validate password
        return password != null && password.length() >= 6 && !password.matches(".*[^a-zA-Z0-9].*");
    }

    @Override
    public UserResponse updatePassword(int userId, UpdatePasswordRequest request) {
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();
        var existedUser = userRepo.findUserByUsersID(userId).orElse(null);
        if (existedUser != null) {
            if (isValidPassword(password)) {
                if (password.equals(confirmPassword)) {
                    existedUser.setPassword(passwordEncoder.encode(password));
                    userRepo.save(existedUser);
                    return UserResponse.builder()
                            .status("Password updated successfully")
                            .user(existedUser)
                            .build();
                } else {
                    return UserResponse.builder()
                            .status("Passwords do not match")
                            .user(null)
                            .build();
                }

            } else {
                return UserResponse.builder()
                        .status("The password must be at least 6 characters long and should not contain any special characters.")
                        .user(null)
                        .build();
            }
        } else {
            return UserResponse.builder()
                    .status("User Not Found")
                    .user(null)
                    .build();

        }

    }


}
