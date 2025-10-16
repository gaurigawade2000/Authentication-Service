package com.example.service;

import com.example.model.AuthRequest;
import com.example.model.UserLogin;
import com.example.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    @Autowired
    AuthRepository authRepo;
    public UserLogin getUser(String username){
        return authRepo.findByUsername(username);
    }
    public void saveUsers(UserLogin userLogin){
         authRepo.save(userLogin);

    }
}
