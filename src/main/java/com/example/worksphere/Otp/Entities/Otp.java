package com.example.worksphere.Otp.Entities;

import java.time.LocalDateTime;

import com.example.worksphere.Otp.Enums.OtpType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="otp")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Otp {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String otp;

    @Enumerated(EnumType.STRING)
    private OtpType type;

    private int attempts = 0;

    private boolean verified = false;

    private LocalDateTime verifiedAt;

    private LocalDateTime createdAt;

    private LocalDateTime expriedAt;
}
