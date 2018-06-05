package com.inSpringBoot.api.student.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public void insertAllList(List<Student> studentList) {
		studentList.forEach(listItem -> repository.save(listItem));
	}
	
	public Student insert(Student student) {
		Student saved = repository.save(student);
		return saved;
	}
}
