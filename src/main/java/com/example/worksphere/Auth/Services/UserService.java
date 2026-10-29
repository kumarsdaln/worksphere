package com.example.worksphere.Auth.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.worksphere.Auth.Entities.User;
import com.example.worksphere.Auth.Repositories.UserRepository;
import com.example.worksphere.Auth.Requests.UpdateUserRequest;
import com.example.worksphere.Auth.Requests.UserRequest;
import com.example.worksphere.Auth.Responses.UserResponse;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UserService {
    private final UserRepository userRepository;

    public void store(UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setGender(request.getGender());

        userRepository.save(user);
    }

    public List<UserResponse> list(){
        return userRepository.findAll()
               .stream()
               .map(user -> new UserResponse(user.getName(), user.getUsername()))
               .toList();
    }

    public void update(String username, UpdateUserRequest request){
        User user = userRepository.findByUsername(username).orElseThrow(
            () -> new RuntimeException("User not found")
        );

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setDob(request.getDob());
        user.setGender(request.getGender());

        userRepository.save(user);
    }

    public void delete(String username){
        User user = userRepository.findByUsername(username).orElseThrow(
            () -> new RuntimeException("User not found")
        );

        userRepository.delete(user);
    }
}
