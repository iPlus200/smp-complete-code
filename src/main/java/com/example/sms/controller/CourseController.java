package com.example.sms.controller;

import com.example.sms.entity.Course;
import com.example.sms.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@Tag(name="Controller Class",description="Controller Class Code For Course")
public class CourseController {
    
	@Autowired
	private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping
    @Operation(summary="List all course",description="Endpoint definition for getMapping to get list of all students")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }
    
    @GetMapping("/new")
    @Operation(summary="Create a course form",description="Endpoint definition for getMapping for new course form")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "create_course";
    }
    
    @PostMapping
    @Operation(summary="Save the course details",description="Endpoint definition for postMapping for saveing a new course")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
    
    @GetMapping("/edit/{id}")
    @Operation(summary="Edit course form",description="Endpoint definition for editing course form")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit_course";
    }
    
    @PostMapping("/{id}")
    @Operation(summary="Update course",description="Endpoint definition for updating course")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course) {
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setDescription(course.getDescription());
        courseService.saveCourse(existingCourse);
        return "redirect:/courses";
    }
    
    @GetMapping("/delete/{id}")
    @Operation(summary="Delete Course",description="Endpoint definition for deleting a course")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}