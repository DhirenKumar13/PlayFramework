package repository;

import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Key;

import configuration.PlayMorphia;
import models.Student;
public class StudentRepository {
	
	@Inject
    private PlayMorphia morphia;
	
	public Student findById(Integer id) {
		Student car = morphia.
                datastore().
                createQuery(Student.class).
                field("_id").
                equal(id).
                get();
        return car;
    }
	
	public List<Student> findByName(String name) {
		List<Student> car = morphia.
                datastore().
                createQuery(Student.class).
                field("firstName").
                equal(name).asList();
        return car;
    }
	
	public void saveStudent(Student student) {
		
		morphia.datastore().save(student);
		
	}
	
}
