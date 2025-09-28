package com.example.sms.service;

import com.example.sms.entity.Enrollment;
import com.example.sms.repository.EnrollmentRepository;

import exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
	
	@Autowired
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
    
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
    
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
        		.orElseThrow(()->new NotFoundException("Enrollment details not found"));
    }
    
    public void deleteEnrollmentById(Long id) {
        enrollmentRepository.deleteById(id);
    }
    
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
}