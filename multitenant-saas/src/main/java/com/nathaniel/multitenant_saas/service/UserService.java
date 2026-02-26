package com.nathaniel.multitenant_saas.service;

import org.springframework.stereotype.Service;

import com.nathaniel.multitenant_saas.dto.user.CreateUserRequest;
import com.nathaniel.multitenant_saas.entity.User;
import com.nathaniel.multitenant_saas.repository.UserRepository;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User creatUser(CreateUserRequest createUserRequest){
        if(userRepository.existsByEmail(createUserRequest.email)){
            throw new RuntimeException("User already exist");
        }

        User user = new User();
        user.setEmail(createUserRequest.email);
        user.setPassword(createUserRequest.password);
        user.setRole(createUserRequest.role);

        return userRepository.save(user);
    }
}
