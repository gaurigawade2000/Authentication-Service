package com.example.repository;

import com.example.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AuthRepository extends JpaRepository<UserLogin,String> {

    UserLogin findByUsername(String username);

}
