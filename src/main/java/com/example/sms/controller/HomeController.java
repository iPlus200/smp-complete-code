package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name="Home Controller")
public class HomeController {
    @GetMapping("/")
    @Operation(summary="Index page routing")
    public String home() {
        return "index";
    }
}