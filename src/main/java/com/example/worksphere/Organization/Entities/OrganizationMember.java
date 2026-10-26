package com.example.worksphere.Organization.Entities;

import java.time.LocalDateTime;

import com.example.worksphere.Auth.Entities.User;
import com.example.worksphere.Organization.Enums.MemberStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="organization_members")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class OrganizationMember {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name="organizarion_id")
    private Organization organization;

    @ManyToOne 
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDateTime joinedAt;

    private LocalDateTime leavedAt;
}
