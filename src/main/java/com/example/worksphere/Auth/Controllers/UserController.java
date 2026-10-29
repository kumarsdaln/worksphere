package com.example.worksphere.Auth.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.worksphere.Auth.Entities.User;
import com.example.worksphere.Auth.Enums.Gender;
import com.example.worksphere.Auth.Repositories.UserRepository;
import com.example.worksphere.Auth.Requests.UpdateUserRequest;
import com.example.worksphere.Auth.Requests.UserRequest;
import com.example.worksphere.Auth.Responses.UserResponse;
import com.example.worksphere.Auth.Services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @PostMapping("/api/user/store")
    public void store(@Valid  @RequestBody UserRequest request){
        userService.store(request);
    }

    @GetMapping("/api/user/")
    public List<UserResponse> store(){
        return userService.list();
    }

    @PutMapping("/api/user/{username}/update")
    public void update(@PathVariable String username, @Valid @RequestBody UpdateUserRequest request){
        userService.update(username, request);
    }

    @DeleteMapping("/api/user/{username}/delete")
    public void delete(@PathVariable String username){
        userService.delete(username);
    }
}
