package com.example.sms.service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

import exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
	
	@Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
        		.orElseThrow(()->new NotFoundException("Student not found"));
    }
    
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}