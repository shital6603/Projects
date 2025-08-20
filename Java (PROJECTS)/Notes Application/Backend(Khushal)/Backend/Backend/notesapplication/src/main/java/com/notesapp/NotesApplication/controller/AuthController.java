package com.notesapp.NotesApplication.controller;

import com.notesapp.NotesApplication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        authService.register(request.getEmail(), request.getPassword());
        return "User registered successfully";
    }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody AuthRequest request) {
            String token = authService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

    public static class AuthRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
