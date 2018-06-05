package controllers;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

public class MyController extends Controller {

	private final WSClient ws;
	
	private HttpExecutionContext ec;
	
	private StudentHandler handler = new StudentHandler();

    @Inject
    public MyController(HttpExecutionContext ec, WSClient ws) {
        this.ec = ec;
        this.ws = ws;
    }

	Function<WSResponse, Result> resultFromResponse = new Function<WSResponse, Result>() {
		@Override
		public Result apply(WSResponse response) {
			System.out.println(response.asJson());
			JsonNode json = response.asJson();
			Result result = ok(json);
			return result;
		}
	};

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 */
	public CompletionStage<Result> getAllStudents() {
		WSRequest request = ws.url("http://localhost:9001");
		WSRequest requestWithHeader = request.setContentType("application/json").addHeader("headerReceived", "Play");
		//CompletionStage<Result> response = request.get().thenApply(resultFromResponse);
		return requestWithHeader.get().thenApply(resultFromResponse);
	}
	
	public CompletionStage<Result> createAStudent() {
		WSRequest request = ws.url("http://localhost:9001");
		WSRequest requestWithHeader = request.setContentType("application/json").addHeader("headerReceived", "Play");
		Student createStudent = handler.CreateStudent("Anushka", "Sharma", 29);
		JsonNode json = Json.toJson(createStudent);
		String asText = json.asText();
		System.out.println(asText);
		//CompletionStage<Result> response = request.get().thenApply(resultFromResponse);
		return requestWithHeader.post(json).thenApply(resultFromResponse);
	}
	
	public CompletionStage<Result> createAStudentFromPost() {
		
		WSRequest request = ws.url("http://localhost:9001");
		WSRequest requestWithHeader = request.setContentType("application/json").addHeader("headerReceived", "Play");
		String asText = request().body().asText();
		System.out.println(asText);
		return requestWithHeader.post(request().body().asJson()).thenApply(resultFromResponse);
		
	}
	
	

}