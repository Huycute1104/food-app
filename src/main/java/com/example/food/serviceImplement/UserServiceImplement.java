package com.example.food.serviceImplement;

import com.example.food.dto.Response.UserResponse.UserResponse;
import com.example.food.repository.UserRepo;
import com.example.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepo userRepo;
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
}
