package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StudentHandler {
	
	private static Map<Integer,Student> studentMap = new HashMap<>();
	
	public Student addStudent(Student studentObj) {
		System.out.println("Request Reached Here .....");
		if(studentObj.getId()==null) {
			Integer id = studentMap.size();
			studentObj.setId(id);
		}
		studentMap.put(studentObj.getId(), studentObj);
		return studentObj;
	}
	
	public List<Student> getAllStudents() {
		return new ArrayList<>(studentMap.values());
	}
	
	public Student getOneStudentBasedOnId(Integer id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }
        return null;
	}
	
	public Student updateStudent(Student studentObj) {
		Integer id = studentObj.getId();
		if(studentMap.containsKey(id)) {
			studentObj.setToken(studentMap.get(id).getToken());
			studentMap.replace(id, studentObj);
			return studentObj;
		}
		return null;
	}
	
	public boolean deleteStudent(Integer id) {
		return studentMap.remove(id) != null;
	}
	
	public Student CreateStudent(String name,String lname,Integer age) {
		Student studentObj = new Student();
		Integer id = studentMap.size() + 100;
		String token = UUID.randomUUID().toString();
		studentObj.setId(id);
		studentObj.setToken(token);
		studentObj.setFirstName(name);
		studentObj.setAge(age);
		studentObj.setLastName(lname);
		studentMap.put(id, studentObj);
		return studentObj;
	}
	
}
