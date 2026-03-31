package com.litshelf.litshelf_api.controller;

import java.util.Map;
import com.litshelf.litshelf_api.dto.AuthResponse;
import com.litshelf.litshelf_api.config.JwtUtil;
import com.litshelf.litshelf_api.entity.User; 
import com.litshelf.litshelf_api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Log this to your IDE console to prove it's working
        System.out.println("Processing registration for: " + request.getEmail());

        User user = new User();
        user.setName(request.getUsername()); 
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}

// --- DTO CLASSES (Keep these OUTSIDE the AuthController class braces) ---

class RegisterRequest {
    private String username;
    private String email;
    private String password;

    public RegisterRequest() {} // Mandatory for Jackson

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {} // Mandatory for Jackson

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}