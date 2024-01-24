package com.example.mvcdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvcdemo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    //User findByUsername(String username);

 }
