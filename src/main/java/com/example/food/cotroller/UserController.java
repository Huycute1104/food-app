package com.example.food.cotroller;

import com.example.food.dto.Request.UserRequest.UpdatePasswordRequest;
import com.example.food.dto.Request.UserRequest.UpdateUserRequest;
import com.example.food.dto.Response.UserResponse.UserResponse;
import com.example.food.model.User;
import com.example.food.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<User> getAllUsers() {
        return userService.getALL();
    }

    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @GetMapping("/getCustomer")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<User> getCustomer() {
        return userService.getCustomer();
    }
    @GetMapping("/getStaff")
//    @PreAuthorize("hasAuthority('admin:read')")
    public List<User> getStaff() {
        return userService.getStaff();
    }

    @PutMapping("/banUser/{id}")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<UserResponse> banUserByID(@PathVariable int id) {
        UserResponse response = userService.banUser(id);
        if (response.getUser() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/unbanUser/{id}")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<UserResponse> unbanUserByID(@PathVariable int id) {
        UserResponse response = userService.unbanUser(id);
        if (response.getUser() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/updateUser/{userId}")
//    @PreAuthorize("hasAuthority('customer:update')")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable int userId,
            @RequestBody UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUser(userId, updateUserRequest));
    }

    @PutMapping("/changePassword/{userId}")
//    @PreAuthorize("hasAuthority('customer:update')")
    public ResponseEntity<UserResponse> changePassword(
            @PathVariable int userId,
            @RequestBody UpdatePasswordRequest request) {
        return ResponseEntity.ok(userService.updatePassword(userId, request));
    }
}
