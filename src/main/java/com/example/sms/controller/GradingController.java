package com.example.sms.controller;

import com.example.sms.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name="Grading Controller")
public class GradingController {
	
	@Autowired
    private final StudentService studentService;

    public GradingController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping("/grades")
    @Operation(summary="List all grading")
    public String showGradingPage(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "grades";
    }
}