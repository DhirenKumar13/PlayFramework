package com.inSpringBoot.api.student.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentHandler handler;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public List<Student> storeStudent(@RequestHeader String headerReceived) {
		System.out.println("Got a request from ..."+headerReceived);
		System.out.println("Got a request ...");
		List<Student> list = repository.findAll();
		System.out.println(list);
		return list;
		//studentService.insertAllList(handler.getAllStudentsData());
	}
	
	@GetMapping("/id/{id}")
	public Student getStudent(@PathVariable String sid) {
		Integer id = Integer.valueOf(sid);
		return repository.findById(id);
	}
	
	@GetMapping("/toPlay")
	public Student createStudentFromPlay() {
		Student s = new Student();
		s.setFirstName("Dhiren");
		s.setLastName("Kumar");
		s.setAge(23);
		s.setId(2);
		s.setToken(UUID.randomUUID().toString());
		HttpEntity<Student> studentEntity = new HttpEntity<Student>(s);
		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:9000",
				HttpMethod.POST, studentEntity, Student.class);
		return exchange.getBody();
	}
	
	@GetMapping("/fromPlay")
	public Student getStudentFromPlay() {
		
		ResponseEntity<Student> exchange = restTemplate.exchange("http://localhost:9000",
				HttpMethod.GET, null, Student.class);
		
		exchange.getBody();
		
		System.out.println(exchange.getBody());
		
		return restTemplate.getForObject("http://localhost:9000/all", Student.class);
	}
	
	@PostMapping
	public Student storeAStudent(@RequestBody Student student){
		return studentService.insert(student);
	}
}
