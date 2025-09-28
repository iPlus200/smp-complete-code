package com.example.sms.controller;

import com.example.sms.entity.Enrollment;
import com.example.sms.entity.Student;
import com.example.sms.entity.Course;
import com.example.sms.service.EnrollmentService;
import com.example.sms.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
@Tag(name="Enrollment Controller",description="Controller class code for enrollment")
public class EnrollmentController {
	
	@Autowired
    private final EnrollmentService enrollmentService;
	@Autowired
	private final StudentService studentService;
	@Autowired
	private final CourseService courseService;

    public EnrollmentController(EnrollmentService enrollmentService, 
                               StudentService studentService,
                               CourseService courseService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.courseService = courseService;
    }
    
    @GetMapping
    @Operation(summary="List all enrollments")
    public String listEnrollments(Model model) {
        model.addAttribute("enrollments", enrollmentService.getAllEnrollments());
        return "enrollments";
    }

    @GetMapping("/{id}")
    @Operation(summary="View an Enrollment")
    public String viewEnrollment(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment == null) {
            redirectAttributes.addFlashAttribute("error", "Enrollment not found.");
            return "redirect:/enrollments";
        }

        model.addAttribute("enrollment", enrollment);
        return "enrollment_detail";
    }
    
    @GetMapping("/new")
    @Operation(summary="Create enrollment form")
    public String createEnrollmentForm(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();
        
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "create_enrollment";
    }
    
    @PostMapping
    @Operation(summary="Save Enrollment")
    public String saveEnrollment(@RequestParam("studentId") Long studentId,
                                 @RequestParam("courseId") Long courseId,
                                 @RequestParam(value = "grade", required = false) String grade) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        
        if (student == null || course == null) {
            return "redirect:/enrollments?error";
        }
        
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setGrade(grade != null ? grade : "");
        
        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/enrollments";
    }
    
    @GetMapping("/edit/{id}")
    @Operation(summary="Edit enrollment form")
    public String editEnrollmentForm(@PathVariable Long id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        List<Student> students = studentService.getAllStudents();
        List<Course> courses = courseService.getAllCourses();
        
        model.addAttribute("enrollment", enrollment);
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "edit_enrollment";
    }
    
    @PostMapping("/update/{id}")
    @Operation(summary="Update Enrollment")
    public String updateEnrollment(@PathVariable Long id,
                                  @RequestParam("studentId") Long studentId,
                                  @RequestParam("courseId") Long courseId,
                                  @RequestParam(value = "grade", required = false) String grade,
                                  RedirectAttributes redirectAttributes) {
        try {
            Enrollment existingEnrollment = enrollmentService.getEnrollmentById(id);
            Student student = studentService.getStudentById(studentId);
            Course course = courseService.getCourseById(courseId);

            if (existingEnrollment == null) {
                redirectAttributes.addFlashAttribute("error", "Enrollment not found.");
                return "redirect:/enrollments";
            }

            if (student == null || course == null) {
                redirectAttributes.addFlashAttribute("error", "Invalid student or course selected.");
                return "redirect:/enrollments/edit/" + id;
            }

            existingEnrollment.setStudent(student);
            existingEnrollment.setCourse(course);
            existingEnrollment.setGrade(grade != null ? grade : "");

            enrollmentService.saveEnrollment(existingEnrollment);
            redirectAttributes.addFlashAttribute("success", "Enrollment updated successfully!");
            return "redirect:/enrollments";
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while updating the enrollment. Please check your data.");
            return "redirect:/enrollments/edit/" + id;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An unexpected error occurred while updating the enrollment.");
            return "redirect:/enrollments/edit/" + id;
        }
    }
    
    @GetMapping("/delete/{id}")
    @Operation(summary="Delete Enrollment")
    public String deleteEnrollment(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Enrollment enrollment = enrollmentService.getEnrollmentById(id);
            if (enrollment == null) {
                redirectAttributes.addFlashAttribute("error", "Enrollment not found.");
                return "redirect:/enrollments";
            }

            enrollmentService.deleteEnrollmentById(id);
            redirectAttributes.addFlashAttribute("success", "Enrollment deleted successfully!");
            return "redirect:/enrollments";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while deleting the enrollment.");
            return "redirect:/enrollments";
        }
    }
    
    @GetMapping("/student/{id}")
    @Operation(summary="View Student Enrollments")
    public String viewStudentEnrollments(@PathVariable Long id, Model model) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(id);
        Student student = studentService.getStudentById(id);
        
        model.addAttribute("enrollments", enrollments);
        model.addAttribute("student", student);
        return "student_enrollments";
    }
}