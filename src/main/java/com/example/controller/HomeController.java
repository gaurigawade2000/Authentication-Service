package com.example.controller;

import com.example.model.AuthRequest;
import com.example.model.UserLogin;
import com.example.service.AuthService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @Autowired
    AuthService authService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthRequest rp){
        if(authService.getUser(rp.getEmail())!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("message: User Already exist" );
        }
        UserLogin userLogin=new UserLogin();
        userLogin.setUsername(rp.getEmail());
        userLogin.setPassword(passwordEncoder.encode(rp.getPassword()));
        authService.saveUsers(userLogin);
        return ResponseEntity.ok().body(userLogin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLogin userLogin){
         UserLogin user= authService.getUser(userLogin.getUsername());
        if(user==null|| !passwordEncoder.matches(userLogin.getPassword(),user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("message: User not exist");
        }
        String token=jwtUtil.generateToken(userLogin);
        return ResponseEntity.ok("login Success" + token);
    }
}
