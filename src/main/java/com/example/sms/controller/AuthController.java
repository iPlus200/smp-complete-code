package com.example.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.sms.entity.User;
import com.example.sms.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name="Security Controller",description="Controller Class Code For Security Authentication")
public class AuthController {
	
	@Autowired
	private final UserRepository userRepository;
	@Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    @Operation(summary="Mapping for login",description="Endpoint definition for getMapping for login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    @Operation(summary="Mapping for signUp",description="Endpoint definition for getMapping for signUp")
    public String signupPage() {
        return "signup";
    }
    
    @PostMapping("/register")
    @Operation(summary="Mapping for register",description="Endpoint definition for postMapping for register")
    public String register(@RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {
    		String formattedRole = role.startsWith("ROLE_") ? role : "ROLE_" + role;

    		User user = new User(username, passwordEncoder.encode(password), formattedRole);
    		userRepository.save(user);
    		return "redirect:/login?registered";
    }
    
}
