package controllers;

import java.util.UUID;

import javax.inject.Inject;

import models.Student;
import play.mvc.Controller;
import play.mvc.Result;
import repository.StudentRepository;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private StudentRepository carRepository;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	//List<Student> findById = carRepository.findByName("Dhiren");
    	
    	carRepository.saveStudent(new Student("Virat" ,UUID.randomUUID().toString(),"Kohli",29,1000189));
    	//System.out.println(findById);
        // return ok(Json.toJson(findById));
    	
    	return created();
    }

}
