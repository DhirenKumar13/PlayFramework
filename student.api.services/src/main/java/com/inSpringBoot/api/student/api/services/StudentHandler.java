package com.inSpringBoot.api.student.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class StudentHandler {
	
	private static Integer counter = 0;
	
	public List<Student> studentsList = new ArrayList<>();
	
	public List<Student> getAllStudentsData() {
		counter++;
		Student s1 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s2 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s3 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s4 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s5 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s6 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s7 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s8 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s9 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s10 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s11 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s12 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s13 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		counter++;
		Student s14 = new Student("Dhiren", UUID.randomUUID().toString(),"Kumar", 24 , counter);
		studentsList.add(s1);studentsList.add(s2);studentsList.add(s3);studentsList.add(s4);
		studentsList.add(s5);studentsList.add(s6);studentsList.add(s7);studentsList.add(s8);
		studentsList.add(s9);studentsList.add(s10);studentsList.add(s11);studentsList.add(s12);
		studentsList.add(s13);studentsList.add(s14);
		return studentsList;
	}
}
