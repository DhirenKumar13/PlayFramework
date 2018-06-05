package com.inSpringBoot.api.student.api.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Student> {
	public Student findById(Integer id);
}
