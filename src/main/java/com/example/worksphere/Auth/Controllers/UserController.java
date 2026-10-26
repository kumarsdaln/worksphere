package com.example.worksphere.Auth.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.worksphere.Auth.Entities.User;
import com.example.worksphere.Auth.Enums.Gender;
import com.example.worksphere.Auth.Repositories.UserRepository;
import com.example.worksphere.Auth.Requests.UserRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    
    @PostMapping("/api/user/store")
    public void store(@Valid  @RequestBody UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setGender(request.getGender());

        userRepository.save(user);
    }
}
