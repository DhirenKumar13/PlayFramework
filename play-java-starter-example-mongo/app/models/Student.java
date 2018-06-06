package models;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;

@Entity(value = "student")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer _id;
	private String token;
	
	public Student() {}

	public Student(String firstName, String token,String lastName, Integer age, Integer id) {
		super();
		this.firstName = firstName;
		this.token = token;
		this.lastName = lastName;
		this.age = age;
		this._id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer id) {
		this._id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", _id=" + _id
				+ ", token=" + token + "]";
	}
	
}
