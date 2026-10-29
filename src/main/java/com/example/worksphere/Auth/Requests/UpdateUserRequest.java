package com.example.worksphere.Auth.Requests;

import com.example.worksphere.Auth.Enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
public class UpdateUserRequest {
    @NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name can't be less than 3 chars and more than 30 chars.")
    private String name;

    @Size(max=15, message="Phone number must be less than 15 chars")
    private String phone;

    private String dob;

    private Gender gender;
}
