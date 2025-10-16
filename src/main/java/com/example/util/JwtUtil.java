package com.example.util;

import com.example.model.UserLogin;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {


    public String generateToken(UserLogin userLogin){
        String token="8988";
        return token;
    }
}
