package controllers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import controllers.Student;
import controllers.StudentHandler;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class StudentController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */

	/*public Result index() {
		return ok(index.render("Your new application is ready."));
	}*/

	public Result createStudent() {
		JsonNode json = request().body().asJson();

		if (json == null) {
			return badRequest();
		}

		Student student = new StudentHandler().addStudent(Json.fromJson(json, Student.class));
		return created(Json.toJson(student));
	}

	public Result retrieveStudent(Integer id) {

		Student student = new StudentHandler().getOneStudentBasedOnId(id);

		if (student == null) {
			return notFound();
		}
		JsonNode studentNode = Json.toJson(student);
		System.out.println(studentNode);
		return ok(studentNode);
	}

	public Result retrieveAllStudent() throws IOException {
		List<Student> studentsList = new StudentHandler().getAllStudents();
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode jsonData = mapper.convertValue(studentsList, JsonNode.class);
		return ok(jsonData);
	}

	public Result removeStudent(Integer id) {
		boolean student = new StudentHandler().deleteStudent(id);

		if (!student) {
			return notFound();
		}
		return ok();
	}
	
	public Result updateStudent() {
		JsonNode json = request().body().asJson();
		Student studentUpdated = new StudentHandler().updateStudent(Json.fromJson(json, Student.class));
		if(studentUpdated != null) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonData = mapper.convertValue(studentUpdated, JsonNode.class);
			return ok(jsonData);
		}
		return notFound();
	}

}
