package com.example.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Course name required")
    private String courseName;
    @NotBlank(message = "Course description required")
    private String description;
    
    public Course() {
    }
    
    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}