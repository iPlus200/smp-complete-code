package com.example.sms.service;

import com.example.sms.entity.Course;
import com.example.sms.repository.CourseRepository;

import exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
	
	@Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
        		.orElseThrow(()-> new NotFoundException("Course not found"));
    }
    
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}