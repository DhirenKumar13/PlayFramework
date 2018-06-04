package student;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;

public class StudentUtility {

	public static ObjectNode createResponse(Object res, Boolean status) {
		
		ObjectNode response = Json.newObject();
		
		response.put("statusIs", status);
		response.put("body", res.toString());

		return response;
	}

}
