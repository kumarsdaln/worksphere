package com.example.worksphere.Auth.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.worksphere.Auth.Entities.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> {
    
}
