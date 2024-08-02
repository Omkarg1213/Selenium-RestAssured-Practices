package restAssuredTestScripts;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import static io.restassured.RestAssured.*;

public class CreateGitHubRepository {

	@Test
	public void TCreateGitHubRepository() {
	    
	        String baseUrl = "https://api.github.com/user/repos";
	        String token = System.getProperty("GIT_TOKEN");
	        String repoName = "omkargRestAssuredRepo";

	        String requestBody = "{\n" +
	                "  \"name\": \"" + repoName + "\",\n" +
	                "  \"private\": false,\n" +
	                "  \"auto_init\": true\n" +
	                "}";

	        given()
	            .header("Authorization", "token " + token)
	            .header("Content-Type", "application/json")
	            .body(requestBody)
	        .when()
	            .post(baseUrl)
	        .then()
	            .statusCode(201)  // Expecting a successful creation (status code 201)
	            .log().all();     // Log the response details
	    }
}
