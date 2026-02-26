package com.nathaniel.multitenant_saas.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nathaniel.multitenant_saas.dto.user.CreateUserRequest;
import com.nathaniel.multitenant_saas.entity.User;
import com.nathaniel.multitenant_saas.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<User> register(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);
        return ResponseEntity.ok(user);
    }
}
