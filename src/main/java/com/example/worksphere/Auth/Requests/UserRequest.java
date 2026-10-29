package com.example.worksphere.Auth.Requests;

import com.example.worksphere.Auth.Enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class UserRequest {
    @NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name can't be less than 3 chars and more than 30 chars.")
    private String name;

    @NotBlank(message="Username is required!")
    @Size(min=3, max=40, message="Username can't be less than 2 chars and more than 40 chars.")
    private String username;

    @NotBlank(message="Email is required!")
    @Email(message="Enter a valid email address.")
    @Size(max=255, message="Email can't be more than 255 chars.")
    private String email;

    @NotBlank(message="Password is required.")
    @Size(min=8, max=30, message="Password must be between 12 to 50 chars.")
    private String password;

    private Gender gender;
}
