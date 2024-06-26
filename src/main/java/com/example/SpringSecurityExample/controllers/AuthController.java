package com.example.SpringSecurityExample.controllers;

import com.example.SpringSecurityExample.dto.request.LoginReq;
import com.example.SpringSecurityExample.dto.request.UserReq;
import com.example.SpringSecurityExample.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody  @Valid LoginReq loginReq){
        return authService.login(loginReq);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserReq userReq){
        authService.register(userReq);
    }
}
